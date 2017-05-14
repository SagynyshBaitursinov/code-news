package models;

import play.db.jpa.GenericModel;

import javax.persistence.*;

/**
 * Created by sagynysh on 5/15/17.
 */
@Entity
@Table(name = "user_")
public class User extends GenericModel {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id_")
    public Long id;

    @Column(name="email_")
    public String email;

    @Column(name="password_")
    public String password;
}
