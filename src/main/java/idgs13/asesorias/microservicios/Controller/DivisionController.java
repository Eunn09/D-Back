package idgs13.asesorias.microservicios.Controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import idgs13.asesorias.microservicios.dto.DivisionDto;
import idgs13.asesorias.microservicios.dto.ProgramaEducativoDto;
import idgs13.asesorias.microservicios.entity.Division;
import idgs13.asesorias.microservicios.entity.ProgramaEducativo;
import idgs13.asesorias.microservicios.service.DivisionService;

@RestController
@RequestMapping("/api/divisiones")
public class DivisionController {

    @Autowired
    private DivisionService divisionService;

    // --- Helper para mapear Division -> DivisionViewDto ---
    private DivisionDto convertToViewDto(Division division) {
        List<ProgramaEducativoDto> peDtos = division.getProgramasEducativos().stream()
                .map(pe -> new ProgramaEducativoDto(pe.getId(), pe.getNombre()))
                .collect(Collectors.toList());
        return new DivisionDto(division.getId(), division.getNombre(), division.getEstado(), peDtos);
    }

    // --- GET: Listar todas las divisiones ---
    @GetMapping
    public ResponseEntity<List<DivisionDto>> getAllDivisiones() {
        List<Division> divisiones = divisionService.buscarTodos();
        List<DivisionDto> dtos = divisiones.stream()
                .map(this::convertToViewDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }

    // --- GET: Obtener división por ID ---
    @GetMapping("/{id}")
    public ResponseEntity<DivisionDto> getDivisionById(@PathVariable Long id) {
        Division division = divisionService.buscarPorId(id);
        return ResponseEntity.ok(convertToViewDto(division));
    }

    // --- POST: Crear nueva división ---
    @PostMapping
    public ResponseEntity<DivisionDto> createDivision(@RequestBody DivisionDto dto) {
        Division division = divisionService.crearDivision(dto);
        return ResponseEntity.ok(convertToViewDto(division));
    }

    // --- PUT: Actualizar división existente ---
    @PutMapping("/{id}")
    public ResponseEntity<DivisionDto> updateDivision(@PathVariable Long id, @RequestBody DivisionDto dto) {
        Division division = divisionService.actualizarDivision(id, dto);
        return ResponseEntity.ok(convertToViewDto(division));
    }

    // --- PATCH: Baja lógica ---
    @PatchMapping("/{id}/baja-logica")
    public ResponseEntity<DivisionDto> bajaLogicaDivision(@PathVariable Long id) {
        Division division = divisionService.bajaLogicaDivision(id);
        return ResponseEntity.ok(convertToViewDto(division));
    }

    // --- DELETE: Baja física ---
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarDivision(@PathVariable Long id) {
        divisionService.eliminarDivision(id);
        return ResponseEntity.noContent().build();
    }
}
