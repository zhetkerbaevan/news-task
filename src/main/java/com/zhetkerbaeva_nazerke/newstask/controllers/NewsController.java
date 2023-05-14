package com.zhetkerbaeva_nazerke.newstask.controllers;

import com.zhetkerbaeva_nazerke.newstask.entities.News;
import com.zhetkerbaeva_nazerke.newstask.entities.NewsDTO;
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

    @GetMapping("/news/{pageNumber}/{recordCount}")
    public List<News> getAllNews(@PathVariable int pageNumber, @PathVariable int recordCount){
        return newsService.getAllNews(pageNumber, recordCount);
    }

    @GetMapping("/sources")
    public List<Sources> getAllSources(){
        return newsService.getAllSources();
    }

    @GetMapping("/topics")
    public List<Topics> getAllTopics(){
        return newsService.getAllTopics();
    }

    @GetMapping("/news-by-topic-id/{topicId}/{pageNumber}/{recordCount}")
    public List<News> getAllNewsByTopicId(@PathVariable("topicId") Long id, @PathVariable int pageNumber, @PathVariable int recordCount){
        return newsService.getNewsByTopicId(id, pageNumber, recordCount);
    }

    @GetMapping("/news-by-source-id/{sourceId}/{pageNumber}/{recordCount}")
    public List<News> getAllNewsBySourceId(@PathVariable("sourceId") Long id, @PathVariable int pageNumber, @PathVariable int recordCount){
        return newsService.getNewsBySourceId(id, pageNumber, recordCount);
    }
    @PostMapping("/post_topic")
    public Topics addTopic(@RequestBody Topics topic){
        return newsService.addTopics(topic);
    }
    @PostMapping("/post_source")
    public Sources addSource(@RequestBody Sources source){
        return newsService.addSource(source);
    }
    @PostMapping("/post_news")
    public News addNews(@RequestBody NewsDTO newsDTO){
        if(newsDTO.getNews().equals("") || newsDTO.getSource_id() == null || newsDTO.getTopic_id() == null){
            return null;
        }
        News news = new News();
        Sources source = newsService.getSource(newsDTO.getSource_id());
        Topics topic = newsService.getTopics(newsDTO.getTopic_id());
        news.setNews(newsDTO.getNews());
        news.setSources(source);
        news.setTopic(topic);
        return newsService.addNews(news);
    }
    @PutMapping("/put_topic/{topic_id}")
    public Topics updateTopic(@PathVariable Long topic_id, @RequestBody Topics topicsdto) {

        Topics topics = newsService.getTopics(topic_id);
        if(topicsdto.getTopic() != null){
            topics.setTopic(topicsdto.getTopic());
        }
        return newsService.updateTopics(topics);
    }
    @PutMapping("/put_source/{source_id}")
    public Sources updateSource(@PathVariable Long source_id, @RequestBody Sources sourcesdto) {

        Sources sources = newsService.getSource(source_id);
        if(sourcesdto.getSource() != null){
            sources.setSource(sourcesdto.getSource());
        }
        return newsService.updateSource(sources);
    }

    @PutMapping("/put_news/{news_id}")
    public News updateNews(@PathVariable Long news_id, @RequestBody NewsDTO newsdto) {
        System.out.println("updating");
        News news = newsService.getNews(news_id);
        if(newsdto.getNews() != null){
            news.setNews(newsdto.getNews());
        } else if(newsdto.getSource_id() != null){
            Sources source = newsService.getSource(newsdto.getSource_id());
            news.setSources(source);
        } else if(newsdto.getTopic_id() != null){
            Topics topic = newsService.getTopics(newsdto.getTopic_id());
            news.setTopic(topic);
        }
        return newsService.updateNews(news);
    }

    @DeleteMapping("delete_source/{source_id}")
    public String deleteSource(@PathVariable Long source_id){
        newsService.deleteSource(source_id);
        return "source deleted";
    }
    @DeleteMapping("delete_topic/{topic_id}")
    public String deleteTopic(@PathVariable Long topic_id){
        newsService.deleteTopics(topic_id);
        return "topic deleted";
    }

    @DeleteMapping("delete_news/{news_id}")
    public String deleteNews(@PathVariable Long news_id){
        newsService.deleteNews(news_id);
        return "news deleted";
    }
}
