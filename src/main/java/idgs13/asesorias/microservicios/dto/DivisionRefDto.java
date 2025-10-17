// File: dto/DivisionRefDto.java
package idgs13.asesorias.microservicios.dto;

public class DivisionRefDto {
    private Long divisionId;
    private String nombre;
    private String clave;

    public DivisionRefDto() {}

    public DivisionRefDto(Long divisionId, String nombre, String clave) {
        this.divisionId = divisionId;
        this.nombre = nombre;
        this.clave = clave;
    }

    // Getters y Setters
    public Long getDivisionId() { return divisionId; }
    public void setDivisionId(Long divisionId) { this.divisionId = divisionId; }
    
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    
    public String getClave() { return clave; }
    public void setClave(String clave) { this.clave = clave; }
}