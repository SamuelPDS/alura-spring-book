package med.voll.api.controller;

import jakarta.transaction.Transactional;
import med.voll.api.model.dto.DoctorDTO;
import med.voll.api.model.entity.Doctor;
import med.voll.api.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("doctor")
public class DoctorController {
    @Autowired
    private DoctorRepository repository;

    @PostMapping
    @Transactional
    public Doctor createDoctor(@RequestBody DoctorDTO doctorDTO) {
        return repository.save(new Doctor(doctorDTO));
    }
}
