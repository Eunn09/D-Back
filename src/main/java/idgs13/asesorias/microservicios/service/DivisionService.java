package idgs13.asesorias.microservicios.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import idgs13.asesorias.microservicios.dto.DivisionDto;
import idgs13.asesorias.microservicios.dto.ProgramaEducativoDto;
import idgs13.asesorias.microservicios.entity.Division;
import idgs13.asesorias.microservicios.entity.ProgramaEducativo;
import idgs13.asesorias.microservicios.repository.DivisionRepository;

@Service
public class DivisionService {

    @Autowired
    private DivisionRepository divisionRepository;

    // --- Buscar todos ---
    public List<Division> buscarTodos() {
        return divisionRepository.findAll();
    }

    // --- Buscar por ID ---
    public Division buscarPorId(Long id) {
        return divisionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Division no encontrada"));
    }

    // --- Crear división ---
    public Division crearDivision(DivisionDto dto) {
        Division division = new Division();
        division.setNombre(dto.getNombre());
        division.setEstado(dto.getEstado() != null ? dto.getEstado() : true);

        List<ProgramaEducativo> programas = dto.getProgramasEducativos() != null ? 
            dto.getProgramasEducativos().stream()
                .map(peDto -> {
                    ProgramaEducativo pe = new ProgramaEducativo();
                    pe.setNombre(peDto.getNombre());
                    pe.setDivision(division);
                    return pe;
                }).collect(Collectors.toList()) : List.of();

        division.setProgramasEducativos(programas);

        return divisionRepository.save(division);
    }

    // --- Actualizar división ---
    public Division actualizarDivision(Long id, DivisionDto dto) {
        Division division = buscarPorId(id);
        division.setNombre(dto.getNombre());
        division.setEstado(dto.getEstado() != null ? dto.getEstado() : division.getEstado());

        division.getProgramasEducativos().clear();
        if (dto.getProgramasEducativos() != null) {
            List<ProgramaEducativo> programas = dto.getProgramasEducativos().stream()
                    .map(peDto -> {
                        ProgramaEducativo pe = new ProgramaEducativo();
                        pe.setNombre(peDto.getNombre());
                        pe.setDivision(division);
                        return pe;
                    }).collect(Collectors.toList());
            division.getProgramasEducativos().addAll(programas);
        }

        return divisionRepository.save(division);
    }

    // --- Baja lógica ---
    public Division bajaLogicaDivision(Long id) {
        Division division = buscarPorId(id);
        division.setEstado(false);
        return divisionRepository.save(division);
    }

    // --- Baja física ---
    public void eliminarDivision(Long id) {
        Division division = buscarPorId(id);
        divisionRepository.delete(division);
    }
}
