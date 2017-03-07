package com.opas350.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by javier.reyes.valdez on 3/6/2017.
 */
@Data
@Entity
@Table(name="author")
@NamedQueries({
        @NamedQuery(name = "Author.findByLasName",
        query = "SELECT a FROM Author a WHERE a.lastName = ?1")
})

public class Author implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "idAuthor", unique = true, nullable = false)
    private Integer idAuthor;

    @Column(name = "firstName", nullable = false, length = 100)
    private String firstName;

    @Column(name = "lastName", nullable = false, length = 100)
    private String lastName;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "books_by_author", joinColumns = {
            @JoinColumn(name = "idAuthor", nullable = false, updatable = false) }, inverseJoinColumns = {
            @JoinColumn(name = "isbn", nullable = false, updatable = false) })
    private Set<Book> books = new HashSet<Book>();

    public Author() {}
}
