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
@MongoEntity(collection = "tab_codigo_municipios_siafi")
public class TabCodigoMunicipioSiafi extends PanacheMongoEntity {
    private Integer codigo_siafi;
    private Double cnpj;
    private String descricao;
    private String uf;
    private Double codigo_ibge;
}
