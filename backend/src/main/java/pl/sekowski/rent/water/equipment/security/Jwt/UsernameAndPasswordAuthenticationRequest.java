package pl.sekowski.rent.water.equipment.security.Jwt;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UsernameAndPasswordAuthenticationRequest {

    private String username;
    private String password;
}
