package pl.sekowski.rent.water.equipment.registration;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class RegistrationRequest {

    private String firsName;
    private String lastName;
    private String email;
    private String password;
}
