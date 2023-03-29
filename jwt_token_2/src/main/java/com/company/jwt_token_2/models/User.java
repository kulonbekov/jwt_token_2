package com.company.jwt_token_2.models;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "tb_user")
public class User extends BaseEntity{

    @Column(name = "username")
    String username;
    @Column(name = "first_name")
    String firstName;
    @Column(name = "last_name")
    String lastName;
    @Column(name = "email")
    String email;
    @Column(name = "password")
    String password;
    @Column(name = "secret_key")
    String secretKey;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "tb_user_roles",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")})
    List<Role> roles;

}
