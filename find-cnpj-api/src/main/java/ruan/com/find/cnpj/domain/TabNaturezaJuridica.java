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
@MongoEntity(collection = "tab_natureza_juridica")
public class TabNaturezaJuridica extends PanacheMongoEntity {
    private Integer cod_natureza_juridica;
    private String nm_natureza_juridica;
    private Integer cod_subclass_natureza_juridica;
    private String nm_subclass_natureza_juridica;
}
