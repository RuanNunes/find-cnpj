import pandas as pd
import rest_post as post

def migrate_partition(patch_file, chunk_size, patch_url):
    count = 1
    lines_data = 0
    path_cnpj_dados_cadastrais_pj = patch_file.format('cnpj_dados_cadastrais_pj.csv')
    for data in pd.read_csv(path_cnpj_dados_cadastrais_pj, encoding = 'UTF-8', sep = '#', chunksize = chunk_size):
        lines_data += data.shape[0]
        data_json = data.to_json(orient='records')
        target = 'cnpjDadosCadastrais/v1/list'
        request = post.postList(data_json,patch_url , target)
        if(request.status_code != 201):
            label = patch_file.format('json/') + 'cnpj_dados_cadastrais_pj' + str(count) + '.json'
            data.to_json(label, orient='records')
            print('Erro ao processar. arquivo salvo em disco para reprocessamento ' + str(count) )
            count += 1
        else:
            print('concluido cnpj_dados_cadastrais ' + str(count))
            count += 1

    return lines_data