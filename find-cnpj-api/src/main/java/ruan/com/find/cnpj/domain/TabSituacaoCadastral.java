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
@MongoEntity(collection = "tab_situacao_cadastral")
public class TabSituacaoCadastral extends PanacheMongoEntity{
    private Integer cod_situacao_cadastral;
    private String  nm_situacao_cadastral;
}
