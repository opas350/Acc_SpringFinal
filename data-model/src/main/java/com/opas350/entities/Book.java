package com.opas350.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by javier.reyes.valdez on 3/2/2017.
 */

@Entity
@Table(name = "books")
@NamedQueries({
        @NamedQuery(name= "Book.findByTitle",
        query = "SELECT b FROM Book b WHERE b.title = ?1"),
        @NamedQuery(name = "Book.findByIsbn",
        query="SELECT b FROM Book b WHERE b.isbn = ?1")
})
public class Book implements Serializable {

    @Id
    @Column(name = "isbn", unique = true, nullable = false, length = 14)
    private String isbn;

    @Column(name = "title", nullable = false)
    private String title;

    @Temporal(TemporalType.DATE)
    @Column(name="date_of_publication", length = 0)
    private Date dateOfPublication;
    @OneToOne(cascade = CascadeType.REFRESH)
    @JoinTable(
            name = "books_by_author",
            joinColumns = @JoinColumn(name = "isbn"),
            inverseJoinColumns = @JoinColumn(name = "idAuthor")
    )
    private Author author;

    @ManyToMany(fetch= FetchType.EAGER, mappedBy = "books", cascade = CascadeType.ALL)
    private Set<Author> authors = new HashSet<Author>();

    public Book() {}

    public Book(String isbn, String title, Date dateOfPublication){
        this.isbn = isbn;
        this.title = title;
        this.dateOfPublication = dateOfPublication;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDateOfPublication() {
        return dateOfPublication;
    }

    public void setDateOfPublication(Date dateOfPublication) {
        this.dateOfPublication = dateOfPublication;
    }


    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }



}
