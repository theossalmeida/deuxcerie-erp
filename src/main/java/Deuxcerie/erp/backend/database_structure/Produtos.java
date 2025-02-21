package Deuxcerie.erp.backend.database_structure;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Produtos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long idProduto;

    @Setter
    @Getter
    private String nomeProduto;

    @Setter
    @Getter
    private String categoriProduto;

    @Setter
    @Getter
    private String descricaoProduto;
}
