package med.voll.api.model.entity;

import jakarta.persistence.*;
import lombok.*;
import med.voll.api.model.dto.DoctorDTO;
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
    private String crm;

    @Enumerated(EnumType.STRING)
    private Specialty especialty;

    @Embedded
    private Address address;

    public Doctor(DoctorDTO doctorDTO) {

    }
}
