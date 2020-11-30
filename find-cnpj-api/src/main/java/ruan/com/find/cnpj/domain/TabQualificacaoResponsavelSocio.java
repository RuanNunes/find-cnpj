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
@MongoEntity(collection = "tab_qualificacao_responsavel_socio")
public class TabQualificacaoResponsavelSocio extends PanacheMongoEntity {
    private Integer cod_qualificacao_responsavel_socio;
    private String nm_qualificacao_responsavel_socio;
    private String coletado_atualmente;
}
