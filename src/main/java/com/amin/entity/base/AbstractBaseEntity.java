package com.amin.entity.base;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AbstractBaseEntity<ID> extends MasterAbstractEntity<ID> implements Serializable, Cloneable {

    private static final long serialVersionUID = 1L;

    @CreatedBy
    @Column(name = "creation_user_id", nullable = false, updatable = false)
    private String creationUserId;

    @CreatedDate
    @Column(name = "creation_date_time", nullable = false, updatable = false, columnDefinition = "DATE")
    private LocalDateTime creationDateTime;

    @LastModifiedBy
    @Column(name = "update_user_id", insertable = false)
    private String updateUserId;

    @LastModifiedDate
    @Column(name = "update_date_time", insertable = false, columnDefinition = "DATE")
    private LocalDateTime updateDateTime;

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (obj == null || !(obj instanceof AbstractBaseEntity))
            return false;


        AbstractBaseEntity<?> other = (AbstractBaseEntity<?>) obj;
        return !Objects.equals(getId(), other.getId());

    }
}
