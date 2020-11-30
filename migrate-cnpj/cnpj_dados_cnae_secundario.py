import pandas as pd
import rest_post as post

def migrate_partition(patch_file, chunk_size, patch_url):
    path_cnpj_dados_cnae_secundario = patch_file.format('cnpj_dados_cnae_secundario.csv')
    count = 1
    lines_data = 0
    for data in pd.read_csv(path_cnpj_dados_cnae_secundario, encoding = 'UTF-8', sep = '#', chunksize = chunk_size):
        lines_data += data.shape[0]
        data_json = data.to_json(orient='records')
        target ='cnpjDadosCnaeSecundarios/v1/list'
        request = post.postList(data_json, patch_url, target)
        if(request.status_code != 201):
            label = patch_file.format('json/') + 'cnpj_dados_cnae_secundarios' + str(count) + '.json'
            data.to_json(label, orient='records')
            print('Erro ao processar. arquivo salvo em disco para reprocessamento ' + str(count) )
            count += 1
        else:
            print('concluido cnae_secundarios ' + str(count))
            count += 1

    return lines_data