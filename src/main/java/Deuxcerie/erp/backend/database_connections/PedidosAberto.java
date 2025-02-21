package Deuxcerie.erp.backend.database_connections;
import jakarta.persistence.*;

import java.util.Date;

@Entity
public class PedidosAberto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPedido;
    @ManyToOne
    @JoinColumn(name = "idPedido")
    private Pedidos pedido;
    @ManyToOne
    @JoinColumn(name = "idProduto")
    private Produtos produto;
    private int quantidade;
}
