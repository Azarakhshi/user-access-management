package com.amin.entity;

import com.amin.entity.base.AbstractBaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "uam_group")
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

}
