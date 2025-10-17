package idgs13.asesorias.microservicios.dto;


import java.util.List;


public class DivisionCreateDto {
private String nombre;
private String clave;
private List<ProgramaDto> programas;


public String getNombre() { return nombre; }
public void setNombre(String nombre) { this.nombre = nombre; }
public String getClave() { return clave; }
public void setClave(String clave) { this.clave = clave; }
public List<ProgramaDto> getProgramas() { return programas; }
public void setProgramas(List<ProgramaDto> programas) { this.programas = programas; }
}