package com.zhetkerbaeva_nazerke.newstask.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "news")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class News {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long news_id;

    @Column(name="news")
    private String news;

    @ManyToOne(fetch = FetchType.EAGER)
    private Sources sources;

    @ManyToOne(fetch = FetchType.EAGER)
    private Topics topic;

}
