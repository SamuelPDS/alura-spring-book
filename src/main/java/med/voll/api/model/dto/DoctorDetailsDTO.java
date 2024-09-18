package med.voll.api.model.dto;

import med.voll.api.model.entity.Address;
import med.voll.api.model.entity.Doctor;
import med.voll.api.utils.enums.Specialty;

public record DoctorDetailsDTO(Long id, String name, String email, String crm, Specialty specialty, Address address) {
    public DoctorDetailsDTO(Doctor doctor){
        this(doctor.getId(), doctor.getName(), doctor.getEmail(), doctor.getCrm(), doctor.getSpecialty(), doctor.getAddress());
    }
}
