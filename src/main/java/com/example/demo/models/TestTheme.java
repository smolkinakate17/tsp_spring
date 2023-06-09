package com.example.demo.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "test_theme")
@Embeddable
public class TestTheme {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name")
    private String name;


    @Column(name="description",columnDefinition = "text")
    private String description;
    @OneToMany(mappedBy = "theme",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<TestMesseges> messeges;


    public TestTheme(String name){
        this.name=name;
    }
}

