package com.example.demo.models;


import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "test_messeges")
public class TestMesseges {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "text",columnDefinition = "text")
    private String text;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "user", referencedColumnName = "id")
    private TestUsers user;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.REFRESH)
    @JoinColumn(name = "theme", referencedColumnName = "id")
    private TestTheme theme;

}
