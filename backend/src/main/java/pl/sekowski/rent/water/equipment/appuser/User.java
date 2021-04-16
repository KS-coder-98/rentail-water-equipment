package pl.sekowski.rent.water.equipment.appuser;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import pl.sekowski.rent.water.equipment.item.Item;
import pl.sekowski.rent.water.equipment.rental.ItemLeased;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firsName;
    private String lastName;
    private String email;
    private String password;


    @OneToMany(mappedBy = "user")
    Set<ItemLeased> itemLeasedSet;

    @Enumerated(EnumType.STRING)
    private UserRole userRole;
    private Boolean isAccountNonExpired;
    private Boolean isAccountNonLocked;
    private Boolean isCredentialsNonExpired;
    private Boolean isEnabled;

    public User(String firsName, String lastName, String email, String password) {
        this.firsName = firsName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        userRole = UserRole.USER;
        isAccountNonExpired = true;
        isAccountNonLocked = true;
        isCredentialsNonExpired = true;
        isEnabled = true;
        itemLeasedSet = new HashSet<>();

    }

    public User(String firsName, String lastName, String email, String password, UserRole userRole) {
        this.firsName = firsName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.userRole = userRole;
        isAccountNonExpired = true;
        isAccountNonLocked = true;
        isCredentialsNonExpired = true;
        isEnabled = true;
        itemLeasedSet = new HashSet<>();

    }

    public User(String firsName, String lastName, String email, String password, UserRole userRole, Boolean isAccountNonExpired, Boolean isAccountNonLocked, Boolean isCredentialsNonExpired, Boolean isEnabled) {
        this.firsName = firsName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.userRole = userRole;
        this.isAccountNonExpired = isAccountNonExpired;
        this.isAccountNonLocked = isAccountNonLocked;
        this.isCredentialsNonExpired = isCredentialsNonExpired;
        this.isEnabled = isEnabled;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(userRole.name());
        return Collections.singletonList(authority);
    }

    @Override
    public String getUsername() {
        return firsName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return isAccountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isAccountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isCredentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }


}
