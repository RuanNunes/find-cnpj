package picpay.com.find.cnpj.domain;

import io.quarkus.mongodb.panache.MongoEntity;
import io.quarkus.mongodb.panache.PanacheMongoEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@MongoEntity(collection = "cnpj_dados_cnae_secundarios")
public class CnpjDadosCnaeSecundarios extends PanacheMongoEntity {
    private Integer tipo_de_registro;
    private String indicador;
    private Double tipo_atualizacao;
    private Double cnpj;
    private Integer cnae_secundario;
    private String filler;
}
