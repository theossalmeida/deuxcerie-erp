package Deuxcerie.erp.backend.database_connections;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.Date;

public class FluxoFinanceiro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMovimentacao;
    private float valorMovimentado;
    private String descricaoMovimentacao;
    private String tipoMovimentacao;
    private Date dataMovimentacao;
}
