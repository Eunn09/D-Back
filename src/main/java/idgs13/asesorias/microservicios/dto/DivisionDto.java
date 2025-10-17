package idgs13.asesorias.microservicios.dto;

import java.util.List;

public class DivisionDto {
    private Long id;
    private String nombre;
    private String clave;
    private Boolean estatus;
    private List<ProgramaEducativoDto> programas;

    public DivisionDto() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getClave() { return clave; }
    public void setClave(String clave) { this.clave = clave; }

    public Boolean getEstatus() { return estatus; }
    public void setEstatus(Boolean estatus) { this.estatus = estatus; }

    public List<ProgramaEducativoDto> getProgramas() { return programas; }
    public void setProgramas(List<ProgramaEducativoDto> programas) { this.programas = programas; }
}
