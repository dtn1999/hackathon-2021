package com.hackathon.amazoneclone.user;

import com.hackathon.amazoneclone.utils.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.validation.constraints.Size;
import java.util.Arrays;
import java.util.Collection;

/**
 * @author danyls ngongang
 * @Created 10/09/2021-11:33
 * @Project user-service
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class LoginDetail extends BaseEntity implements UserDetails {
    private AuthProvider authProvider;

    @Size(min = 8, message = "The password most have at least 8 characters")
    @Column(nullable = true)
    private String password;

    private String oauth2Id;

    /**
     *
     */
    @OneToOne( fetch = FetchType.LAZY)
    private User user;

    public boolean validate(){
        if(authProvider == AuthProvider.EMAIL){
            return password==null ? false : true;
        }
        return  oauth2Id==null? false: true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority( user.getRole().name() ));
    }

    @Override
    public String getUsername() {
        return user.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
