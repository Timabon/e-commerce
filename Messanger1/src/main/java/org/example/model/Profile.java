package org.example.model;


import jakarta.persistence.*;

import java.sql.Date;
@Entity
@Table(name = "Profiles")

public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "profileName")
    private String profileName;
    @Column(name = "lastName")
    private String lastName;
    private Date created;

    public Profile(){

    }

    public Profile(String profileName,String lastName) {
        this.profileName = profileName;
        this.lastName = lastName;
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
