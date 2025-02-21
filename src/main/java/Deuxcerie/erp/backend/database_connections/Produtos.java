package Deuxcerie.erp.backend.database_connections;
import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Produtos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduto;
    private String nomeProduto;
    private String categoriProduto;
    private String descricaoProduto;
}
