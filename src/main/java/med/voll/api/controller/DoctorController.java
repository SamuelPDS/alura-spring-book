package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.model.dto.DoctorDTO;
import med.voll.api.model.dto.DoctorDetailsDTO;
import med.voll.api.model.dto.ResponseDoctorDTO;
import med.voll.api.model.dto.UpdateDoctorDataDTO;
import med.voll.api.model.entity.Doctor;
import med.voll.api.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("doctor")
public class DoctorController {
    @Autowired
    private DoctorRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<DoctorDetailsDTO> createDoctor(@RequestBody @Valid DoctorDTO doctorDTO, UriComponentsBuilder uriBuilder) {
        var doctor = repository.save(new Doctor(doctorDTO));
        var uri = uriBuilder.path("/doctor/{id}").buildAndExpand(doctor.getId()).toUri();
        return ResponseEntity.created(uri).body(new DoctorDetailsDTO(doctor));

        //o status 201 precisa devolver o proprio codigo, o corpo e um cabeçalho location
    }

    @GetMapping
    public ResponseEntity<Page<ResponseDoctorDTO>> getAllDoctor(@PageableDefault(size = 10) Pageable pageable){
        var doctors = repository.findAllByActiveTrue(pageable);
        return ResponseEntity.ok(doctors.map(ResponseDoctorDTO::new));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DoctorDetailsDTO> updateDoctor(UpdateDoctorDataDTO dto) {
        var doctor = repository.getReferenceById(dto.id());
        doctor.update(dto);
        return ResponseEntity.ok(new DoctorDetailsDTO(doctor));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> deleteDoctor(@PathVariable Long id) {
        var doctor = repository.getReferenceById(id);
        doctor.updateStatus(doctor);
        return ResponseEntity.noContent().build();
    }
}
