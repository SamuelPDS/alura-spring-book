package med.voll.api.model.entity;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Embeddable
public class Address {
    @NotBlank
    private String street;
    @NotBlank
    private String number;
    @NotBlank
    private String neighborhood;
    @NotBlank
    private String city;
    @NotBlank
    @Pattern(regexp = "\\d{8}")
    private String cep;
}
