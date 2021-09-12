package com.hackathon.blablacar.userservice.user;

import com.hackathon.blablacar.userservice.utils.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.validation.constraints.Min;

/**
 * @author danyls ngongang
 * @Created 10/09/2021-11:33
 * @Project user-service
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginDetail extends BaseEntity {
    private AuthProvider authProvider;

    @Min(value = 8)
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
}
