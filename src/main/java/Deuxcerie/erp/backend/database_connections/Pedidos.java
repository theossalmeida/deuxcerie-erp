package Deuxcerie.erp.backend.database_connections;
import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Pedidos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPedido;
    @ManyToOne
    @JoinColumn(name = "idCliente")
    private Cliente cliente;
    private String status;
    private float valorTotal;
    private String descricao;
    private Date dataPedido;
    private Date dataEntrega;
    private int prazo;
}
