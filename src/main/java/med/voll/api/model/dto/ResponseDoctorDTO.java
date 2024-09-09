package med.voll.api.model.dto;

import med.voll.api.model.entity.Address;
import med.voll.api.model.entity.Doctor;
import med.voll.api.utils.enums.Specialty;

public record ResponseDoctorDTO(
        Long id,
        String name,
        String crm,
        Specialty specialty) {

    public ResponseDoctorDTO(Doctor doctor) {
        this(doctor.getId(), doctor.getName(), doctor.getCrm(), doctor.getSpecialty());
    }
}
