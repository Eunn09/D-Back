package idgs13.asesorias.microservicios.service;


import idgs13.asesorias.microservicios.dto.DivisionCreateDto;
import idgs13.asesorias.microservicios.dto.DivisionDto;
import idgs13.asesorias.microservicios.dto.DivisionUpdateDto;


import java.util.List;


public interface DivisionService {
DivisionDto createDivision(DivisionCreateDto dto);
DivisionDto updateDivision(Long id, DivisionUpdateDto dto);
void deleteDivision(Long id);
DivisionDto changeStatus(Long id, Boolean estatus);
DivisionDto getById(Long id);
List<DivisionDto> getAll();
}