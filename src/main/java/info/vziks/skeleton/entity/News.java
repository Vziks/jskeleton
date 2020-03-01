package info.vziks.skeleton.entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(indexes = {
        @Index(name = "news_k_name", columnList = "name"),
        @Index(name = "news_k_id_url", columnList = "id,url")
})
public class News extends BaseRecord implements Serializable {

    @Column(length = 500)
    private String url;

    @Column(length = 500)
    private String name;

    @Basic
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @Lob
    private String description;

    @Lob
    private String text;

    @Column(length = 100)
    private String image;

    @Column(length = 200)
    private String image_source;

    @Column(length = 100)
    private String author;

    @Type(type = "int-array")
    @Column(columnDefinition = "integer[]")
    private Integer[] person_ids;

    @Type(type = "int-array")
    @Column(columnDefinition = "integer[]")
    private Integer[] category_ids;

    @Type(type = "int-array")
    @Column(columnDefinition = "integer[]")
    private Integer[] tag_ids;

    @Column(columnDefinition = "SMALLINT default '0'::SMALLINT")
    @Type(type = "org.hibernate.type.ShortType")
    private short own;

    @Column(columnDefinition = "SMALLINT default '0'::SMALLINT")
    @Type(type = "org.hibernate.type.ShortType")
    private short top;

    @Column(columnDefinition = "SMALLINT default '0'::SMALLINT")
    @Type(type="org.hibernate.type.ShortType")
    private short bad;


    @Column(columnDefinition = "SMALLINT default '0'::SMALLINT")
    @Type(type = "org.hibernate.type.ShortType")
    private short comments_off;

    @Column(columnDefinition = "SMALLINT default '0'::SMALLINT")
    @Type(type = "org.hibernate.type.ShortType")
    private short isnot;


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImage_source() {
        return image_source;
    }

    public void setImage_source(String image_source) {
        this.image_source = image_source;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer[] getPerson_ids() {
        return person_ids;
    }

    public void setPerson_ids(Integer[] person_ids) {
        this.person_ids = person_ids;
    }

    public Integer[] getCategory_ids() {
        return category_ids;
    }

    public void setCategory_ids(Integer[] category_ids) {
        this.category_ids = category_ids;
    }

    public Integer[] getTag_ids() {
        return tag_ids;
    }

    public void setTag_ids(Integer[] tag_ids) {
        this.tag_ids = tag_ids;
    }

    public short getOwn() {
        return own;
    }

    public void setOwn(short own) {
        this.own = own;
    }

    public short getTop() {
        return top;
    }

    public void setTop(short top) {
        this.top = top;
    }

    public short getBad() {
        return bad;
    }

    public void setBad(short bad) {
        this.bad = bad;
    }

    public short getComments_off() {
        return comments_off;
    }

    public void setComments_off(short comments_off) {
        this.comments_off = comments_off;
    }

    public short getIsnot() {
        return isnot;
    }

    public void setIsnot(short isnot) {
        this.isnot = isnot;
    }
}
