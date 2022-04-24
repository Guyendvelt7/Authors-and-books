package com.jb.Authors_And_Books.beans;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class Author {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    @Column (nullable = false, length = 40)
    private String name;
    private float weight;
    @OneToMany (cascade = CascadeType.ALL)
    private List<Book> books;
}
