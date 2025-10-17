package idgs13.asesorias.microservicios.Controller;


import idgs13.asesorias.microservicios.dto.*;
import idgs13.asesorias.microservicios.service.DivisionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/divisiones")
public class DivisionController {

    private final DivisionService divisionService;

    public DivisionController(DivisionService divisionService) {
        this.divisionService = divisionService;
    }

    @PostMapping
    public ResponseEntity<DivisionDto> create(@RequestBody DivisionCreateDto dto) {
        return ResponseEntity.ok(divisionService.createDivision(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DivisionDto> update(@PathVariable Long id, @RequestBody DivisionUpdateDto dto) {
        return ResponseEntity.ok(divisionService.updateDivision(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        divisionService.deleteDivision(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/estatus")
    public ResponseEntity<DivisionDto> changeStatus(@PathVariable Long id, @RequestParam Boolean estatus) {
        return ResponseEntity.ok(divisionService.changeStatus(id, estatus));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DivisionDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(divisionService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<DivisionDto>> getAll() {
        return ResponseEntity.ok(divisionService.getAll());
    }

    // Endpoint para que otros microservicios pidan varias divisiones por ids (POST)
    @PostMapping("/byid")
    public ResponseEntity<List<DivisionDto>> getByIds(@RequestBody List<Long> ids) {
        List<DivisionDto> all = divisionService.getAll();
        return ResponseEntity.ok(
            all.stream()
                .filter(d -> ids.contains(d.getId()))
                .collect(Collectors.toList())
        );
    }
}