package idgs13.asesorias.microservicios.entity;

import jakarta.persistence.*;

/**
 * Entidad que representa un Programa Educativo (PE), asociado a una División.
 */
@Entity
@Table(name = "programas_educativos")
public class ProgramaEducativo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nombre;

    // Relación ManyToOne con Division
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "division_id", nullable = false)
    private Division division;

    // --- Getters y Setters ---

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public Division getDivision() { return division; }
    public void setDivision(Division division) { this.division = division; }
}