package idgs13.asesorias.microservicios.service;

import idgs13.asesorias.microservicios.dto.*;
import idgs13.asesorias.microservicios.entity.Division;
import idgs13.asesorias.microservicios.entity.ProgramaEducativo;
import idgs13.asesorias.microservicios.repository.DivisionRepository;
import idgs13.asesorias.microservicios.service.DivisionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class DivisionServiceImpl implements DivisionService {

    private final DivisionRepository divisionRepository;

    public DivisionServiceImpl(DivisionRepository divisionRepository) {
        this.divisionRepository = divisionRepository;
    }

    @Override
    public DivisionDto createDivision(DivisionCreateDto dto) {
        Division division = new Division();
        division.setNombre(dto.getNombre());
        division.setClave(dto.getClave());
        division.setEstatus(true);
        
        if (dto.getProgramas() != null) {
            dto.getProgramas().forEach(p -> {
                ProgramaEducativo pe = new ProgramaEducativo();
                pe.setNombre(p.getNombre());
                pe.setDivision(division);
                division.getProgramas().add(pe);
            });
        }
        
        Division saved = divisionRepository.save(division);
        return toDto(saved);
    }

    @Override
    public DivisionDto updateDivision(Long id, DivisionUpdateDto dto) {
        Division division = divisionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Division no encontrada: " + id));
        
        if (dto.getNombre() != null) {
            division.setNombre(dto.getNombre());
        }
        
        if (dto.getClave() != null) {
            division.setClave(dto.getClave());
        }
        
        if (dto.getEstatus() != null) {
            division.setEstatus(dto.getEstatus());
        }
        
        // Reemplazar programas si se proporcionan
        if (dto.getProgramas() != null) {
            division.getProgramas().clear();
            dto.getProgramas().forEach(p -> {
                ProgramaEducativo pe = new ProgramaEducativo();
                pe.setNombre(p.getNombre());
                pe.setDivision(division);
                division.getProgramas().add(pe);
            });
        }
        
        Division saved = divisionRepository.save(division);
        return toDto(saved);
    }

    @Override
    public void deleteDivision(Long id) {
        divisionRepository.deleteById(id);
    }

    @Override
    public DivisionDto changeStatus(Long id, Boolean estatus) {
        Division division = divisionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Division no encontrada: " + id));
        division.setEstatus(estatus);
        return toDto(divisionRepository.save(division));
    }

    @Override
    public DivisionDto getById(Long id) {
        return divisionRepository.findById(id)
                .map(this::toDto)
                .orElseThrow(() -> new RuntimeException("Division no encontrada: " + id));
    }

    @Override
    public List<DivisionDto> getAll() {
        return divisionRepository.findAll()
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

   private DivisionDto toDto(Division d) {
    DivisionDto dto = new DivisionDto();
    dto.setId(d.getId());
    dto.setNombre(d.getNombre());
    dto.setClave(d.getClave());
    dto.setEstatus(d.getEstatus());
    dto.setProgramas(d.getProgramas().stream()
            .map(p -> new ProgramaEducativoDto(p.getId(), p.getNombre()))
            .collect(Collectors.toList()));
    return dto;
}
}