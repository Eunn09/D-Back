    package idgs13.asesorias.microservicios.repository;

    import java.util.List;

    import org.springframework.data.jpa.repository.JpaRepository;
    import org.springframework.stereotype.Repository;

    import idgs13.asesorias.microservicios.entity.Division; // RUTA CORREGIDA

    /**
     * Interfaz de Repositorio para la entidad Division. 
     * Hereda de JpaRepository, proporcionando métodos CRUD básicos.
     */
    @Repository
    public interface DivisionRepository extends JpaRepository<Division, Long> {
        
        // Método para buscar todas las Divisiones por su estado.
        List<Division> findByEstado(Boolean estado);
    }
