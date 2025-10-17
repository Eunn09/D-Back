package idgs13.asesorias.microservicios.repository;


import idgs13.asesorias.microservicios.entity.Division;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;


public interface DivisionRepository extends JpaRepository<Division, Long> {
Optional<Division> findByClave(String clave);
}