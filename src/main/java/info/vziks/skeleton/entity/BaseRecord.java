package info.vziks.skeleton.entity;

import com.vladmihalcea.hibernate.type.array.IntArrayType;
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

    @Column(columnDefinition = "serial")
    private Long id;

    @Basic
    @Temporal(TemporalType.TIMESTAMP)
    private Date regdate;

    public Long getId() {
        return id;
    }

    public Date getRegdate() {
        return regdate;
    }

    public void setRegdate(Date regdate) {
        this.regdate = regdate;
    }
}
