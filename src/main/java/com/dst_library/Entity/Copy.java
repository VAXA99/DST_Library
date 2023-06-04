package com.dst_library.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Copy {

    @SequenceGenerator(name = "notes_SEQ", sequenceName = "notes_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "SERIAL", name = "id_copy")
    @Id
    private Long idCopy;

    @Column(name = "shelf_coordinate")
    private Integer shelfCoordinate;

    @Column(name = "year_of_release")
    private Integer yearOfRelease;

    @Column(name = "storage_room_number")
    private  Integer storageRoomNumber;

    @Column(columnDefinition = "TEXT", name = "quality_state")
    private String qualityState;

    @ManyToOne
    @JoinColumn(name = "id_book", referencedColumnName = "id_book", foreignKey = @ForeignKey(name = "id_book"))
    private Book book;

    @ManyToOne
    @JoinColumn(name = "id_branch", referencedColumnName = "id_branch", foreignKey = @ForeignKey(name = "id_branch"))
    private Branch branch;

    public Copy() {
    }

    public Copy(Integer shelfCoordinate, Integer yearOfRelease, Integer storageRoomNumber, String qualityState, Book book, Branch branch) {
        this.shelfCoordinate = shelfCoordinate;
        this.yearOfRelease = yearOfRelease;
        this.storageRoomNumber = storageRoomNumber;
        this.qualityState = qualityState;
        this.book = book;
        this.branch = branch;
    }

    public Copy(Long idCopy, Integer shelfCoordinate, Integer yearOfRelease, Integer storageRoomNumber, String qualityState, Book book, Branch branch) {
        this.idCopy = idCopy;
        this.shelfCoordinate = shelfCoordinate;
        this.yearOfRelease = yearOfRelease;
        this.storageRoomNumber = storageRoomNumber;
        this.qualityState = qualityState;
        this.book = book;
        this.branch = branch;
    }
}

