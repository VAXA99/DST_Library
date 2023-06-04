package com.dst_library.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Getter
@Setter
@Table(name = "form")
public class Form {

    @SequenceGenerator(name = "notes_SEQ", sequenceName = "notes_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "SERIAL", name = "id_form")
    @Id
    private Long idForm;

    @ManyToOne
    @JoinColumn(name = "id_reader", referencedColumnName = "id_reader", foreignKey = @ForeignKey(name = "id_reader"))
    private Reader reader;

    @ManyToOne
    @JoinColumn(name = "id_copy", referencedColumnName = "id_copy", foreignKey = @ForeignKey(name = "id_copy"))
    private Copy copy;

    @Column(name = "date_of_issue")
    private Date dateOfIssue;

    @Column(name = "date_of_return")
    private Date dateOfReturn;

    public Form() {
    }

    public Form(Reader reader, Copy copy, Date dateOfIssue, Date dateOfReturn) {
        this.reader = reader;
        this.copy = copy;
        this.dateOfIssue = dateOfIssue;
        this.dateOfReturn = dateOfReturn;
    }

    public Form(Long idForm, Reader reader, Copy copy, Date dateOfIssue, Date dateOfReturn) {
        this.idForm = idForm;
        this.reader = reader;
        this.copy = copy;
        this.dateOfIssue = dateOfIssue;
        this.dateOfReturn = dateOfReturn;
    }
}
