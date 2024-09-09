package med.voll.api.model.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import med.voll.api.model.entity.Address;

public record PatientDTO(@NotBlank
                         String name,
                         @NotBlank
                         @Email
                         String email,
                         @NotBlank
                         String phone,
                         @NotBlank
                         String cpf,
                         @Valid
                         Address address) {
}
