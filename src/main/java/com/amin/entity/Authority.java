package com.amin.entity;

import com.amin.entity.base.AbstractBaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "aum_authority")
@Getter
@Setter
public class Authority extends AbstractBaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_uam_authority")
    @SequenceGenerator(name = "seq_uam_authority", sequenceName = "seq_uam_authority", initialValue = 0, allocationSize = 10)
    @Column(name = "authority_id", nullable = false)
    private Long id;

    @Column(name = "authority_name")
    private String authorityName;

    @Column(name = "authority_code")
    private String authorityCode;

}