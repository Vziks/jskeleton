package info.vziks.skeleton.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Proxy;
import org.hibernate.annotations.Type;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users", indexes = {@Index(name = "users_k_nick", columnList = "nick")})
@Proxy(lazy = false)
public class User extends BaseRecord implements UserDetails {

    @Column(length = 100)
    private String nick;

    @Column(length = 100)
    private String name;

    @Lob
    private String credo;

    @Size(min = 2, message = "Минимум 3 символа")
    @Column(unique=true)
    private String username;

    @JsonIgnore
    @Size(min = 3, message = "Минимум 3 символа")
    private String password;

    @Transient
    private String passwordConfirm;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles = new HashSet<>();

    @Column(columnDefinition = "SMALLINT")
    @Type(type = "org.hibernate.type.ShortType")
    private short sex;

    @Basic
    @Temporal(TemporalType.DATE)
    private Date birthdate;

    @Column(length = 100)
    private String country;

    @Column(length = 100)
    private String city;

    private int country_id;

    private int city_id;

    @Column(length = 100)
    private String family;

    @Column(length = 100)
    private String avatar;

    @Column(columnDefinition = "SMALLINT default '0'::SMALLINT")
    @Type(type = "org.hibernate.type.ShortType")
    private short show_db;

    @Column(columnDefinition = "SMALLINT")
    @Type(type = "org.hibernate.type.ShortType")
    private short activist;

    @Basic
    @Temporal(TemporalType.DATE)
    private Date banned_date;

    @Column(columnDefinition = "SMALLINT")
    @Type(type = "org.hibernate.type.ShortType")
    private short active;

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCredo() {
        return credo;
    }

    public void setCredo(String credo) {
        this.credo = credo;
    }

    public short getSex() {
        return sex;
    }

    public void setSex(short sex) {
        this.sex = sex;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getCountry_id() {
        return country_id;
    }

    public void setCountry_id(int country_id) {
        this.country_id = country_id;
    }

    public int getCity_id() {
        return city_id;
    }

    public void setCity_id(int city_id) {
        this.city_id = city_id;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public short getShow_db() {
        return show_db;
    }

    public void setShow_db(short show_db) {
        this.show_db = show_db;
    }


    public short getActivist() {
        return activist;
    }

    public void setActivist(short activist) {
        this.activist = activist;
    }

    public Date getBanned_date() {
        return banned_date;
    }

    public void setBanned_date(Date banned_date) {
        this.banned_date = banned_date;
    }

    public short getActive() {
        return active;
    }

    public void setActive(short active) {
        this.active = active;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
