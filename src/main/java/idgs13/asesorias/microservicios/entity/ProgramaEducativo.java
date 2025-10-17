package idgs13.asesorias.microservicios.entity;


import jakarta.persistence.*;


@Entity
@Table(name = "programas_educativos")
public class ProgramaEducativo {


@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;


@Column(nullable = false)
private String nombre;


@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "division_id")
private Division division;


// getters y setters
public Long getId() { return id; }
public void setId(Long id) { this.id = id; }
public String getNombre() { return nombre; }
public void setNombre(String nombre) { this.nombre = nombre; }
public Division getDivision() { return division; }
public void setDivision(Division division) { this.division = division; }
public void setEstatus(boolean b) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'setEstatus'");
}
public Object getEstatus() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getEstatus'");
}
}