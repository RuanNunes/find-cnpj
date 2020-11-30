import pandas as pd
import rest_post as post

def migrate_partition(path, chunk_size):
    path_tab_codigo_municipios_siafi = path.format('tab_codigo_municipios_siafi.csv')
    count = 1
    lines_data = 0
    for data in pd.read_csv(path_tab_codigo_municipios_siafi, encoding = 'UTF-8', sep = '#', chunksize = chunk_size):
        lines_data += data.shape[0]
        data_json = data.to_json(orient='records')
        patc = 'http://localhost:8080/api/{}'
        target ='tabCodigoMunicipioSiafi/v1/list'
        request = post.postList(data_json, patc, target)
        if(request.status_code != 201):
            label = path.format('json/') + 'tab_codigo_municipios_siafi' + str(count) + '.json'
            data.to_json(label, orient='records')
            print('Erro ao processar. arquivo salvo na pasta /json para reprocessamento' + str(count) )
            count += 1
        else:
            print('concluido tab_codigo_municipios_siafi ' + str(count))
            count += 1

    return lines_data