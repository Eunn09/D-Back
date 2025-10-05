package idgs13.asesorias.microservicios.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import idgs13.asesorias.microservicios.entity.ProgramaEducativo;

@Repository
public interface ProgramaEducativoRepository extends JpaRepository<ProgramaEducativo, Long> {
    // Si quieres buscar por nombre o filtrado futuro, se puede agregar aquí
}
