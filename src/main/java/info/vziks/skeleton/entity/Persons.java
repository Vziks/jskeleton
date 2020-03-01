package info.vziks.skeleton.entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(indexes = {@Index(name = "persons_k_name", columnList = "name")})
public class Persons extends BaseRecord implements Serializable {

    @Column(length = 200)
    private String name;

    @Column(name = "name_original", length = 200)
    private String nameOriginal;

    @Column(name = "name_nominative", length = 200)
    private String nameNominative;

    @Column(name = "name_fenitive", length = 200)
    private String nameFenitive;

    @Column(name = "name_prepositional", length = 200)
    private String namePrepositional;

    @Lob
    private String info;

    @Lob
    @Column(name = "info_short")
    private String infoShort;

    @Column(length = 50)
    private String photo;

    @Column(name = "photo_source", length = 200)
    private String photoSource;

    @Basic
    @Temporal(TemporalType.DATE)
    @Column(name = "birthday")
    private Date birthDay;

    @Basic
    @Temporal(TemporalType.DATE)
    @Column(name = "deathday")
    private Date deathDay;

    @Column(columnDefinition = "SMALLINT")
    @Type(type = "org.hibernate.type.ShortType")
    private short sex;

    @Column(columnDefinition = "SMALLINT")
    @Type(type = "org.hibernate.type.ShortType")
    private short singer;

    @Column(length = 100)
    private short vk;

    @Column(length = 100)
    private short instagram;

    @Column(length = 100)
    private short twitter;

    @Column(length = 100)
    private short facebook;

}
