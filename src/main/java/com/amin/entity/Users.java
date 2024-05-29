package com.amin.entity;


import com.amin.entity.base.AbstractBaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "uam_user")
@Getter
@Setter
public class Users extends AbstractBaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_uam_group")
    @SequenceGenerator(name = "seq_uam_group", sequenceName = "seq_uam_group", initialValue = 0, allocationSize = 10)
    @Column(name = "group_id", nullable = false)
    private Long id;

    @Column(name = "Activated", nullable = false)
    private Boolean isActive;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "mobile", nullable = false, length = 11)
    private String mobile;

    @Column(name = "hash_password", nullable = false)
    private String hashedPassword;

    @Column(name = "usernem", nullable = false, length = 15, unique = true)
    private String username;

    @Column(name = "national_code")
    private String nationalCode;

    @ManyToMany(mappedBy = "users")
    private Set<Group> groups;

}
