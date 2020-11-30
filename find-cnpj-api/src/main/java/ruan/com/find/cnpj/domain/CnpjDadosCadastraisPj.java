package picpay.com.find.cnpj.domain;

import io.quarkus.mongodb.panache.MongoEntity;
import io.quarkus.mongodb.panache.PanacheMongoEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.codecs.pojo.annotations.BsonProperty;

/**
 * @author ruannunes
 * @version 1.0
 * @Data 23/11/20
 */

@MongoEntity(collection = "cnpj_dados_cadastrais_pj")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CnpjDadosCadastraisPj extends PanacheMongoEntity{
    private Integer tipo_de_registro;
    private String indicador;
    private Integer tipo_atualizacao;
    private Double cnpj;
    private Integer identificador_matriz_filial; 
    private String razao_social;  
    private String nome_fantasia;  
    private Integer situacao_cadastral; 
    private String data_situacao_cadastral;  
    private Integer motivo_situacao_cadastral; 
    private String nm_cidade_exterior;
    private Integer cod_pais; 
    private String nm_pais;
    private Integer codigo_natureza_juridica; 
    private String data_inicio_atividade;  
    private Integer cnae_fiscal; 
    private String descricao_tipo_logradouro;  
    private String logradouro;  
    private String numero;  
    private String complemento;  
    private String bairro;  
    private Integer cep; 
    private String uf;  
    private Integer codigo_municipio; 
    private String municipio;  
    private String ddd_telefone_1;  
    private String ddd_telefone_2;  
    private String ddd_fax;  
    private String correio_eletronico;  
    private Integer qualificacao_responsavel; 
    private Double capital_social_empresa;
    private Integer porte_empresa; 
    private Integer opcao_pelo_simples; 
    private String data_opcao_pelo_simples;
    private String data_exclusao_simples;
    private String opcao_pelo_mei;  
    private String situacao_especial;
    private String data_situacao_especial;
    private Integer filler; 
    private String fim_registro;  

    public static CnpjDadosCadastraisPj findByCnpj(final Double cnpj){
        return find("cnpj", cnpj).firstResult();
    }

	public static boolean exists(final Double cnpj) { return findByCnpj(cnpj) != null;}
    
}
