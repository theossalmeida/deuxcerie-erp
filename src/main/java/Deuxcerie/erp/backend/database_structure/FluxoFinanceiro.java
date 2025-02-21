package Deuxcerie.erp.backend.database_structure;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Getter
@Entity
public class FluxoFinanceiro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMovimentacao;

    @Setter
    private float valorMovimentado;

    @Setter
    private String descricaoMovimentacao;

    @Setter
    private String tipoMovimentacao;

    @Setter
    private Date dataMovimentacao;
}
