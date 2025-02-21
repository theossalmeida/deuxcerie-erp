package Deuxcerie.erp.backend.database_structure;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
public class PedidosAberto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPedidoAberto;

    @ManyToOne
    @JoinColumn(name = "idPedido")
    @Setter
    private Pedidos pedido;

    @ManyToOne
    @JoinColumn(name = "idProduto")
    @Setter
    private Produtos produto;

    @Setter
    private int quantidade;
}
