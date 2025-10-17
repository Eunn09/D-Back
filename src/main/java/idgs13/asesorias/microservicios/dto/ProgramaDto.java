package idgs13.asesorias.microservicios.dto;

public class ProgramaDto {
    private Long id;
    private String nombre;
    private Boolean estatus;

    public ProgramaDto() {}
    
    public ProgramaDto(Long id, String nombre) { 
        this.id = id; 
        this.nombre = nombre; 
    }
    
    public ProgramaDto(Long id, String nombre, Boolean estatus) { 
        this.id = id; 
        this.nombre = nombre;
        this.estatus = estatus;
    }

    public Long getId() { 
        return id; 
    }
    
    public void setId(Long id) { 
        this.id = id; 
    }
    
    public String getNombre() { 
        return nombre; 
    }
    
    public void setNombre(String nombre) { 
        this.nombre = nombre; 
    }
    
    public Boolean getEstatus() { 
        return estatus; 
    }
    
    public void setEstatus(Boolean estatus) { 
        this.estatus = estatus; 
    }
}