package com.dst_library.Entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "branch")
public class Branch {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "BIGSERIAL", name = "id_branch")
    @Id
    private Long idBranch;

    @Column(columnDefinition = "TEXT", name = "address")
    private String address;

    @Column(name = "nominal_book_number")
    private Integer nominalBookNumber;

    @Column(name = "actual_book_number")
    private Integer actualBookNumber;

    public Branch(String address, Integer nominalBookNumber, Integer actualBookNumber) {
        this.address = address;
        this.nominalBookNumber = nominalBookNumber;
        this.actualBookNumber = actualBookNumber;
    }
}
