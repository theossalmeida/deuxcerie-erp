package Deuxcerie.erp.backend.database_structure;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCliente;
    @Setter
    private String nome;
    @Setter
    @Column(unique = true)
    private String email;
    @Setter
    private String telefone;
    @Setter
    private int idade;

    public Cliente() {}

    public Cliente(String nome, String email, String telefone, int idade) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.idade = idade;
    }

}
