package med.voll.api.model.entity;

import jakarta.persistence.*;
import lombok.*;
import med.voll.api.model.dto.DoctorDTO;
import med.voll.api.model.dto.ResponseDoctorDTO;
import med.voll.api.model.dto.UpdateDoctorDataDTO;
import med.voll.api.utils.enums.Specialty;

@Entity(name = "doctors")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String crm;

    @Enumerated(EnumType.STRING)
    private Specialty specialty;

    @Embedded
    private Address address;

    private boolean active;

    public Doctor(DoctorDTO doctorDTO) {
        this.active = true;
        this.phone = doctorDTO.phone();
        this.name = doctorDTO.name();
        this.email = doctorDTO.email();
        this.crm = doctorDTO.crm();
    }

    public void update(UpdateDoctorDataDTO doctor) {
        if (doctor.name() != null) this.name = doctor.name();
        if (doctor.phone() != null) this.phone = doctor.phone();
    }

    public void updateStatus(Doctor doctor) {
        doctor.active = false;
    }
}
