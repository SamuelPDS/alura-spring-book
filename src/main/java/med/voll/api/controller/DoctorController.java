package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.model.dto.DoctorDTO;
import med.voll.api.model.dto.ResponseDoctorDTO;
import med.voll.api.model.dto.UpdateDoctorDataDTO;
import med.voll.api.model.entity.Doctor;
import med.voll.api.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("doctor")
public class DoctorController {
    @Autowired
    private DoctorRepository repository;

    @PostMapping
    @Transactional
    public Doctor createDoctor(@RequestBody @Valid DoctorDTO doctorDTO) {
        return repository.save(new Doctor(doctorDTO));
    }

    @GetMapping
    public Page<ResponseDoctorDTO> getAllDoctor(@PageableDefault(size = 10) Pageable pageable){
        var doctors = repository.findAllByActiveTrue(pageable);
        return doctors.map(ResponseDoctorDTO::new);
    }

    @PutMapping
    @Transactional
    public void updateDoctor(UpdateDoctorDataDTO dto) {
        var doctor = repository.getReferenceById(dto.id());
        doctor.update(dto);
    }

    @PutMapping("/{id}")
    @Transactional
    public void deleteDoctor(@PathVariable Long id) {
        var doctor = repository.getReferenceById(id);
        doctor.updateStatus(doctor);

    }
}
