package com.amin.entity;

import com.amin.entity.base.AbstractBaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "uam_group", uniqueConstraints = {})
@Getter
@Setter
public class Group extends AbstractBaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_uam_group")
    @SequenceGenerator(name = "seq_uam_group", sequenceName = "seq_uam_group", initialValue = 0, allocationSize = 10)
    @Column(name = "group_id", nullable = false)
    private Long id;

    @Column(name = "group_name", nullable = false)
    private String GroupName;

    @ManyToMany
    @JoinTable(name = "group_user",
            joinColumns = @JoinColumn(name = "group_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<Users> users;

    @ManyToMany(mappedBy = "groups")
    private Set<Authority> authorities;

}
