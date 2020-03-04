package info.vziks.skeleton.entity;

import com.vladmihalcea.hibernate.type.array.IntArrayType;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.util.Date;


/**
 * Class BaseRecord
 * Project web-spring
 *
 * @author Anton Prokhorov <vziks@live.ru>
 */
@TypeDefs({
        @TypeDef(
                name = "int-array",
                typeClass = IntArrayType.class
        )
})
@MappedSuperclass
abstract public class BaseRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @GenericGenerator(name = "increment", strategy = "increment")
    private int id;

    @Basic
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Basic
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    public int getId() {
        return id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @PrePersist
    protected void prePersist() {
        if (this.createdAt == null) setCreatedAt(new Date());
        if (this.updatedAt == null) setUpdatedAt(new Date());
    }

    @PreUpdate
    protected void preUpdate() {
       setUpdatedAt(new Date());
    }

}
