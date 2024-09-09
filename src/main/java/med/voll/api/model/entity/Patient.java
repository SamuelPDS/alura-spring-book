package med.voll.api.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.model.dto.PatientDTO;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String cpf;
    private String phone;
    private String email;
    private Address address;

    public Patient(PatientDTO patientDTO) {
        this.name = patientDTO.name();
        this.cpf = patientDTO.cpf();
        this.phone = patientDTO.phone();
        this.email = patientDTO.email();
        this.address = patientDTO.address();
    }
}
