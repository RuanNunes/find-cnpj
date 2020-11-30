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
@MongoEntity(collection = "tab_cnpj_entes_publicos")
public class TabCnpjEntesPublicos extends PanacheMongoEntity {
    private Double cnpj;
    private Integer cod_natureza_juridica;
    private String nome_empresarial;
    private String ente_federativo_responsavel;
    private String ente_principal;
    private String situacao;
}
