package com.zhetkerbaeva_nazerke.newstask.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewsDTO {
    private Long newsdto_id;
    private String news;

    private Long source_id;

    private Long topic_id;
}
