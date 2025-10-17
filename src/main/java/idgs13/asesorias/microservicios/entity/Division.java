
package idgs13.asesorias.microservicios.entity;


import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "divisiones")
public class Division {


@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;


@Column(nullable = false)
private String nombre;


@Column(nullable = false, unique = true)
private String clave;


@Column(nullable = false)
private Boolean estatus = true;


@OneToMany(mappedBy = "division", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
private Set<ProgramaEducativo> programas = new HashSet<>();


// getters y setters
public Long getId() { return id; }
public void setId(Long id) { this.id = id; }
public String getNombre() { return nombre; }
public void setNombre(String nombre) { this.nombre = nombre; }
public String getClave() { return clave; }
public void setClave(String clave) { this.clave = clave; }
public Boolean getEstatus() { return estatus; }
public void setEstatus(Boolean estatus) { this.estatus = estatus; }
public Set<ProgramaEducativo> getProgramas() { return programas; }
public void setProgramas(Set<ProgramaEducativo> programas) { this.programas = programas; }
}