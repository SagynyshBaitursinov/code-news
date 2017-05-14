package models;

import play.db.jpa.GenericModel;

import javax.persistence.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by sagynysh on 5/15/17.
 */
@Entity
@Table(name = "news_")
public class News extends GenericModel {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    public Long id;

    @Column(name="create_date")
    public Date createdDate;

    @Column(name="title")
    public String title;

    @Column(name="text", columnDefinition = "TEXT")
    public String text;

    @Column(name="image_url")
    public String imageUrl;

    @Transient
    public String getDate() {
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm");
        return df.format(createdDate);
    }
}
