package com.dst_library.Entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "branch")
public class Branch {

    @SequenceGenerator(name = "notes_SEQ", sequenceName = "notes_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "SERIAL", name = "id_branch")
    @Id
    private Long idBranch;

    @Column(columnDefinition = "TEXT", name = "address")
    private String address;

    @Column(name = "nominal_book_number")
    private Integer nominalBookNumber;

    @Column(name = "actual_book_number")
    private Integer actualBookNumber;

    public Branch() {
    }

    public Branch(String address, Integer nominalBookNumber, Integer actualBookNumber) {
        this.address = address;
        this.nominalBookNumber = nominalBookNumber;
        this.actualBookNumber = actualBookNumber;
    }

    public Branch(Long idBranch, String address, Integer nominalBookNumber, Integer actualBookNumber) {
        this.idBranch = idBranch;
        this.address = address;
        this.nominalBookNumber = nominalBookNumber;
        this.actualBookNumber = actualBookNumber;
    }
}
