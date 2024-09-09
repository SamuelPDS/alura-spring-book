package med.voll.api.controller;

import med.voll.api.model.dto.DoctorDTO;
import med.voll.api.model.dto.PatientDTO;
import med.voll.api.model.entity.Patient;
import med.voll.api.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("patient")
public class PatientController {
    @Autowired
    private PatientRepository repository;

    @PostMapping
    public void createPatient(@RequestBody PatientDTO patientDTO) {
        repository.save(new Patient(patientDTO));
    }
}
