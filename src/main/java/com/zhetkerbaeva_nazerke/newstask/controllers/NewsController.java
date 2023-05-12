package com.zhetkerbaeva_nazerke.newstask.controllers;

import com.zhetkerbaeva_nazerke.newstask.entities.News;
import com.zhetkerbaeva_nazerke.newstask.entities.Sources;
import com.zhetkerbaeva_nazerke.newstask.entities.Topics;
import com.zhetkerbaeva_nazerke.newstask.services.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class NewsController {

    @Autowired
    NewsService newsService;

    @GetMapping("/news")
    public List<News> getAllNews(){
        return newsService.getAllNews();
    }

    @GetMapping("/sources")
    public List<Sources> getAllSources(){
        return newsService.getAllSources();
    }

    @GetMapping("/topics")
    public List<Topics> getAllTopics(){
        return newsService.getAllTopics();
    }

    @GetMapping("/news-by-topic-id/{topicId}")
    public List<News> getAllNewsByTopicId(@PathVariable("topicId") Long id){
        return newsService.getNewsByTopicId(id);
    }

    @GetMapping("/news-by-source-id/{sourceId}")
    public List<News> getAllNewsBySourceId(@PathVariable("sourceId") Long id){
        return newsService.getNewsBySourceId(id);
    }
}
