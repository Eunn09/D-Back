package idgs13.asesorias.microservicios.dto;


import java.util.List;


public class DivisionUpdateDto {
private Long id;
private String nombre;
private String clave;
private Boolean estatus;
private List<ProgramaDto> programas;


// getters y setters
public Long getId() { return id; }
public void setId(Long id) { this.id = id; }
public String getNombre() { return nombre; }
public void setNombre(String nombre) { this.nombre = nombre; }
public String getClave() { return clave; }
public void setClave(String clave) { this.clave = clave; }
public Boolean getEstatus() { return estatus; }
public void setEstatus(Boolean estatus) { this.estatus = estatus; }
public List<ProgramaDto> getProgramas() { return programas; }
public void setProgramas(List<ProgramaDto> programas) { this.programas = programas; }
}