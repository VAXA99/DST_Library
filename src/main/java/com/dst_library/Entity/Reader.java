package com.dst_library.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Getter
@Setter
@Entity
@Table(name = "reader")
public class Reader {

    @SequenceGenerator(name = "notes_SEQ", sequenceName = "notes_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "SERIAL", name = "id_reader")
    @Id
    private Long idReader;

    @Column(columnDefinition = "TEXT", name = "full_name")
    private String fullName;

    @Column(name = "passport_data")
    private Integer passportData;

    @Column(name = "check_in_date")
    private Date checkInDate;

    @Column(name = "check_out_date")
    private Date checkOutDate;

    @Column(name = "gender")
    private Character gender;

    @Column(name = "year_of_birth")
    private Integer yearOfBirth;

    @Column(columnDefinition = "TEXT", name = "profession")
    private String profession;

    @Column(name = "card_number")
    private Integer cardNumber;

    public Reader() {
    }

    public Reader(String fullName, Integer passportData, Date checkInDate, Date checkOutDate, Character gender, Integer yearOfBirth, String profession, Integer cardNumber) {
        this.fullName = fullName;
        this.passportData = passportData;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.gender = gender;
        this.yearOfBirth = yearOfBirth;
        this.profession = profession;
        this.cardNumber = cardNumber;
    }

    public Reader(Long idReader, String fullName, Integer passportData, Date checkInDate, Date checkOutDate, Character gender, Integer yearOfBirth, String profession, Integer cardNumber) {
        this.idReader = idReader;
        this.fullName = fullName;
        this.passportData = passportData;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.gender = gender;
        this.yearOfBirth = yearOfBirth;
        this.profession = profession;
        this.cardNumber = cardNumber;
    }
}
