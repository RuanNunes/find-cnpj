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
@MongoEntity(collection = "tab_cnae")
public class TabCnae extends PanacheMongoEntity {
    private String cod_secao;
    private String nm_secao;
    private Double cod_divisao;
    private String nm_divisao;
    private Double cod_grupo;
    private String nm_grupo;
    private String cod_classe;
    private String nm_classe;
    private Double cod_cnae;
    private String nm_cnae;  
}
