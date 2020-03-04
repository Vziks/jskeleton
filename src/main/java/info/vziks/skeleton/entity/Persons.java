package info.vziks.skeleton.entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


/**
 * Class Persons
 * Project web-spring
 *
 * @author Anton Prokhorov <vziks@live.ru>
 */
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameOriginal() {
        return nameOriginal;
    }

    public void setNameOriginal(String nameOriginal) {
        this.nameOriginal = nameOriginal;
    }

    public String getNameNominative() {
        return nameNominative;
    }

    public void setNameNominative(String nameNominative) {
        this.nameNominative = nameNominative;
    }

    public String getNameFenitive() {
        return nameFenitive;
    }

    public void setNameFenitive(String nameFenitive) {
        this.nameFenitive = nameFenitive;
    }

    public String getNamePrepositional() {
        return namePrepositional;
    }

    public void setNamePrepositional(String namePrepositional) {
        this.namePrepositional = namePrepositional;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getInfoShort() {
        return infoShort;
    }

    public void setInfoShort(String infoShort) {
        this.infoShort = infoShort;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getPhotoSource() {
        return photoSource;
    }

    public void setPhotoSource(String photoSource) {
        this.photoSource = photoSource;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public Date getDeathDay() {
        return deathDay;
    }

    public void setDeathDay(Date deathDay) {
        this.deathDay = deathDay;
    }

    public short getSex() {
        return sex;
    }

    public void setSex(short sex) {
        this.sex = sex;
    }

    public short getSinger() {
        return singer;
    }

    public void setSinger(short singer) {
        this.singer = singer;
    }

    public short getVk() {
        return vk;
    }

    public void setVk(short vk) {
        this.vk = vk;
    }

    public short getInstagram() {
        return instagram;
    }

    public void setInstagram(short instagram) {
        this.instagram = instagram;
    }

    public short getTwitter() {
        return twitter;
    }

    public void setTwitter(short twitter) {
        this.twitter = twitter;
    }

    public short getFacebook() {
        return facebook;
    }

    public void setFacebook(short facebook) {
        this.facebook = facebook;
    }
}
