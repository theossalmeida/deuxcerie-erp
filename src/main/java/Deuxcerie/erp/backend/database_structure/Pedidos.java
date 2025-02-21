package Deuxcerie.erp.backend.database_structure;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Entity
public class Pedidos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPedido;

    @ManyToOne
    @JoinColumn(name = "idCliente")
    @Setter
    private Cliente cliente;

    @Setter
    private String status;

    @Setter
    private float valorTotal;

    @Setter
    private String descricao;

    @Setter
    private Date dataPedido;

    @Setter
    private Date dataEntrega;

    @Setter
    private int prazo;
}
