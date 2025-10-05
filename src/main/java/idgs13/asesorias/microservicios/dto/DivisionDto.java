package idgs13.asesorias.microservicios.dto;

import java.util.List;

/**
 * DTO utilizado para enviar datos de una División al cliente (operaciones GET).
 * Incluye el estado y la lista de Programas Educativos asociados.
 */
public class DivisionDto {
    private Long id;
    private String nombre;
    private Boolean estado;
    private List<ProgramaEducativoDto> programasEducativos;

    // Constructor sin argumentos
    public DivisionDto() {}

    // Constructor con argumentos
    public DivisionDto(Long id, String nombre, Boolean estado, List<ProgramaEducativoDto> programasEducativos) {
        this.id = id;
        this.nombre = nombre;
        this.estado = estado;
        this.programasEducativos = programasEducativos;
    }

    // --- Getters y Setters ---

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public Boolean getEstado() { return estado; }
    public void setEstado(Boolean estado) { this.estado = estado; }

    public List<ProgramaEducativoDto> getProgramasEducativos() { return programasEducativos; }
    public void setProgramasEducativos(List<ProgramaEducativoDto> programasEducativos) { this.programasEducativos = programasEducativos; }
}