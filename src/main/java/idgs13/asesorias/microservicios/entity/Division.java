package idgs13.asesorias.microservicios.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Entidad principal que representa una División en la base de datos.
 */
@Entity
@Table(name = "divisiones")
public class Division {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nombre;

    // Campo para el borrado lógico (habilitado/deshabilitado)
    @Column(nullable = false)
    private Boolean estado = true;

    // Relación OneToMany con ProgramaEducativo
    @OneToMany(mappedBy = "division", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<ProgramaEducativo> programasEducativos = new ArrayList<>();

    // --- Getters y Setters ---

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public Boolean getEstado() { return estado; }
    public void setEstado(Boolean estado) { this.estado = estado; }

    public List<ProgramaEducativo> getProgramasEducativos() { return programasEducativos; }
    public void setProgramasEducativos(List<ProgramaEducativo> programasEducativos) { this.programasEducativos = programasEducativos; }
}