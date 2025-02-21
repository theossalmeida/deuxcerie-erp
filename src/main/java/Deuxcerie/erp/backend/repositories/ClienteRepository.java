package Deuxcerie.erp.backend.repositories;
import Deuxcerie.erp.backend.database_structure.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Optional<Cliente> findByEmail(String email);
}
