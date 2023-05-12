package com.zhetkerbaeva_nazerke.newstask.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "sources")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sources {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long source_id;

    @Column(name="source")
    private String source;
}
