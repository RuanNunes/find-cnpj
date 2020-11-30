## Projeto find-cnpj
esse projeto tem com objetivo disponibilizar de forma gratuita uma api para consultas sobre empresas brasileiras.
inicialmente o projeto é composto em dois projetos ramificados, um para tratar da api e disponibilização dos dados
e outro projeto para tratar da analise dos dados e migração.

#find-cnpj-api
<p>esse projeto referece a api para consulta por cnpj, api foi desenvolvida utilizando a seguinte stack:
<li>Quarkus
<li>Java 11
<li>Mongo Db
<p/>

#migrate-cnpj 
projeto para inicialmente ler arquivos csv e migrar de forma particionada chamando o projeto find-cnpj-api <br>
stack:
<li> python
<li> pandas
 
