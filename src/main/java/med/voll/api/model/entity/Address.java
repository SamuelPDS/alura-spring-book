package med.voll.api.model.entity;

import jakarta.persistence.Embeddable;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Embeddable
public class Address {
    private String street;
    private String number;
    private String neighborhood;
    private String city;
    private String cep;
}
