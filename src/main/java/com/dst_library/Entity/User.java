package com.dst_library.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class User {

    @SequenceGenerator(name = "notes_SEQ", sequenceName = "notes_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "SERIAL", name = "id_user")
    @Id
    private Long idUser;

    @Column(columnDefinition = "TEXT", name = "login")
    private String login;

    @Column(columnDefinition = "TEXT", name = "password")
    private String password;

    @Column(columnDefinition = "TEXT", name = "role")
    private  String role;

    public User() {
    }

    public User(String login, String password, String role) {
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public User(Long idUser, String login, String password, String role) {
        this.idUser = idUser;
        this.login = login;
        this.password = password;
        this.role = role;
    }
}
