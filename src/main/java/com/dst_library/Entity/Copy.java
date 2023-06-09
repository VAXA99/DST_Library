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
@Table(name = "copy")
public class Copy {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "BIGSERIAL", name = "id_copy")
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

    public Copy(Integer shelfCoordinate, Integer yearOfRelease, Integer storageRoomNumber, String qualityState, Book book, Branch branch) {
        this.shelfCoordinate = shelfCoordinate;
        this.yearOfRelease = yearOfRelease;
        this.storageRoomNumber = storageRoomNumber;
        this.qualityState = qualityState;
        this.book = book;
        this.branch = branch;
    }
}

