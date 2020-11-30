import cnpj_dados_cnae_secundario as cnae_secundario
import tab_cnae as cnae
import tab_situacao_cadastral as situacao
import tab_qualificacao_responsavel_socio as qualificacao_responsavel_socio
import tab_natureza_juridica as natureza_juridica
import tab_codigo_municipios_siafi as municipios_siafi
import tab_cnpj_entes_publicos as entes_publicos
import cnpj_dados_cadastrais
import cnpj_dados_socios
import timeit
patch_file = '/Users/ruannunes/develope/picpay/pocs/cnpj/data/{}'
patch_url = 'http://localhost:8080/api/{}'
total_time = 0
total_lines = 0

def sum_total_lines(l):
    global total_lines
    total_lines = l + total_lines

def print_lines(time,lines):
    sum_total_lines(lines)
    print('duração: %f' % time)
    print('linhas migradas: ' + str(lines))
    print('')

def time_global(t_end, t_ini):
    time = t_end - t_ini
    global total_time
    total_time += time
    return time

def exec_migrate_situacao_cadastral():
    t_ini = timeit.default_timer()
    lines = situacao.migrate_partition(patch_file,50)
    t_end = timeit.default_timer()
    print_lines(time_global(t_end,t_ini),lines)

def exec_qualificacao_responsavel_socio():
    t_ini = timeit.default_timer()
    lines = qualificacao_responsavel_socio.migrate_partition(patch_file, 50)
    t_end = timeit.default_timer()
    print_lines(time_global(t_end, t_ini), lines)

def exec_natureza_juridica():
    t_ini = timeit.default_timer()
    lines = natureza_juridica.migrate_partition(patch_file,50)
    t_end = timeit.default_timer()
    print_lines(time_global(t_end, t_ini), lines)

def exec_municipioes_siafi():
    t_ini = timeit.default_timer()
    lines = municipios_siafi.migrate_partition(patch_file,5000)
    t_end = timeit.default_timer()
    print_lines(time_global(t_end, t_ini), lines)

def exec_cnae():
    t_ini = timeit.default_timer()
    lines = cnae.migrate_partition(patch_file, 5000)
    t_end = timeit.default_timer()
    print_lines(time_global(t_end, t_ini), lines)

def exec_entes_publicos():
    t_ini = timeit.default_timer()
    lines = entes_publicos.migrate_partition(patch_file,50000)
    t_end = timeit.default_timer()
    print_lines(time_global(t_end, t_ini), lines)

def exec_cnae_secundario():
    t_ini = timeit.default_timer()
    lines = cnae_secundario.migrate_partition(patch_file, 70000,patch_url)
    t_end = timeit.default_timer()
    print_lines(time_global(t_end, t_ini), lines)

def exec_cnpj_dados_socios():
    t_ini = timeit.default_timer()
    lines = cnpj_dados_socios.migrate_partition(patch_file, 10000, patch_url)
    t_end = timeit.default_timer()
    print_lines(time_global(t_end, t_ini), lines)

def exec_cnpj_dados_cadastrais():
    t_ini = timeit.default_timer()
    lines = cnpj_dados_cadastrais.migrate_partition(patch_file, 10000, patch_url)
    t_end = timeit.default_timer()
    print_lines(time_global(t_end, t_ini), lines)

if __name__ == '__main__':
    # arquivos pequenos
    exec_migrate_situacao_cadastral()
    exec_qualificacao_responsavel_socio()
    exec_natureza_juridica()
    exec_municipioes_siafi()
    exec_cnae()

    # arquivos grandes
    exec_entes_publicos()
    # exec_cnae_secundario()
    # exec_cnpj_dados_socios()
    # exec_cnpj_dados_cadastrais()
    print('Tempo Total em ms: ' + str(total_time))
    print('Total de linhas migradas: ' + str(total_lines))





