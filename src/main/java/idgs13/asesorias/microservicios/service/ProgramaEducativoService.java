package idgs13.asesorias.microservicios.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import idgs13.asesorias.microservicios.dto.ProgramaEducativoDto;
import idgs13.asesorias.microservicios.entity.Division;
import idgs13.asesorias.microservicios.entity.ProgramaEducativo;
import idgs13.asesorias.microservicios.repository.ProgramaEducativoRepository;
import idgs13.asesorias.microservicios.repository.DivisionRepository;

@Service
public class ProgramaEducativoService {

    @Autowired
    private ProgramaEducativoRepository peRepository;

    @Autowired
    private DivisionRepository divisionRepository;

    // --- CRUD Básico ---

    public List<ProgramaEducativo> buscarTodos() {
        return peRepository.findAll();
    }

    public ProgramaEducativo buscarPorId(Long id) {
        return peRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Programa Educativo no encontrado"));
    }

    public ProgramaEducativo crearPrograma(Long divisionId, ProgramaEducativoDto dto) {
        Division division = divisionRepository.findById(divisionId)
                .orElseThrow(() -> new RuntimeException("Division no encontrada"));
        ProgramaEducativo pe = new ProgramaEducativo();
        pe.setNombre(dto.getNombre());
        pe.setDivision(division);
        return peRepository.save(pe);
    }

    public ProgramaEducativo actualizarPrograma(Long id, ProgramaEducativoDto dto) {
        ProgramaEducativo pe = buscarPorId(id);
        pe.setNombre(dto.getNombre());
        return peRepository.save(pe);
    }

    public ProgramaEducativo bajaLogicaPrograma(Long id) {
        ProgramaEducativo pe = buscarPorId(id);
        pe.getDivision().setEstado(false); // Opcional: desactiva la división si quieres
        return peRepository.save(pe);
    }

    public void eliminarPrograma(Long id) {
        peRepository.delete(buscarPorId(id));
    }
}
