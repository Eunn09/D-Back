package idgs13.asesorias.microservicios.Controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import idgs13.asesorias.microservicios.dto.ProgramaEducativoDto;
import idgs13.asesorias.microservicios.entity.ProgramaEducativo;
import idgs13.asesorias.microservicios.service.ProgramaEducativoService;

@RestController
@RequestMapping("/api/programas")
public class ProgramaEDController {

    @Autowired
    private ProgramaEducativoService peService;

    // --- GET todos ---
    @GetMapping
    public ResponseEntity<List<ProgramaEducativoDto>> getAllProgramas() {
        List<ProgramaEducativoDto> dtos = peService.buscarTodos().stream()
                .map(pe -> new ProgramaEducativoDto(pe.getId(), pe.getNombre()))
                .collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }

    // --- GET por ID ---
    @GetMapping("/{id}")
    public ResponseEntity<ProgramaEducativoDto> getProgramaById(@PathVariable Long id) {
        ProgramaEducativo pe = peService.buscarPorId(id);
        return ResponseEntity.ok(new ProgramaEducativoDto(pe.getId(), pe.getNombre()));
    }

    // --- POST: Crear programa dentro de una división ---
    @PostMapping("/division/{divisionId}")
    public ResponseEntity<ProgramaEducativoDto> createPrograma(@PathVariable Long divisionId,
                                                               @RequestBody ProgramaEducativoDto dto) {
        ProgramaEducativo pe = peService.crearPrograma(divisionId, dto);
        return ResponseEntity.ok(new ProgramaEducativoDto(pe.getId(), pe.getNombre()));
    }

    // --- PUT: Actualizar programa ---
    @PutMapping("/{id}")
    public ResponseEntity<ProgramaEducativoDto> updatePrograma(@PathVariable Long id,
                                                               @RequestBody ProgramaEducativoDto dto) {
        ProgramaEducativo pe = peService.actualizarPrograma(id, dto);
        return ResponseEntity.ok(new ProgramaEducativoDto(pe.getId(), pe.getNombre()));
    }

    // --- PATCH: Baja lógica ---
    @PatchMapping("/{id}/baja-logica")
    public ResponseEntity<ProgramaEducativoDto> bajaLogicaPrograma(@PathVariable Long id) {
        ProgramaEducativo pe = peService.bajaLogicaPrograma(id);
        return ResponseEntity.ok(new ProgramaEducativoDto(pe.getId(), pe.getNombre()));
    }

    // --- DELETE: Baja física ---
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPrograma(@PathVariable Long id) {
        peService.eliminarPrograma(id);
        return ResponseEntity.noContent().build();
    }
}
