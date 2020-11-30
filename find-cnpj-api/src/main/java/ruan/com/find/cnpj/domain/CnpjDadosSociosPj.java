package picpay.com.find.cnpj.domain;

import io.quarkus.mongodb.panache.MongoEntity;
import io.quarkus.mongodb.panache.PanacheMongoEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@MongoEntity(collection = "cnpj_dados_socios_pj")
public class CnpjDadosSociosPj extends PanacheMongoEntity{
    private Integer tipo_de_registro;                       
    private String indicador;                               
    private String tipo_atualizacao;                        
    private Double cnpj;                                    
    private Double identificador_socio;                     
    private String nome_socio;                              
    private String cnpj_cpf_socio;                          
    private Double cod_qualificacao_socio;                  
    private Integer percentual_capital_socio;               
    private String data_entrada_sociedade;                  
    private String cod_pais;                                
    private String nome_pais_socio;                         
    private String cpf_representante_legal;                 
    private String nome_representante;                      
    private Double cod_qualificacao_representante_legal;    
    private String fillter;                                 
    private String fim_registro;

}
