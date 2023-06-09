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
@Table(name = "roles")
@EnableJpaAuditing
public class Role extends BaseEntity{

    @Column(name = "name")
    String name;
    @ManyToMany(mappedBy = "roles" , fetch = FetchType.LAZY)
    List<User> users;


}
