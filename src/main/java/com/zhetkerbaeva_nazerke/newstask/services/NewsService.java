package com.zhetkerbaeva_nazerke.newstask.services;

import com.zhetkerbaeva_nazerke.newstask.entities.News;
import com.zhetkerbaeva_nazerke.newstask.entities.Sources;
import com.zhetkerbaeva_nazerke.newstask.entities.Topics;

import java.util.List;

public interface NewsService {
    List<Sources> getAllSources();

    Sources getSource(Long id);
    Sources addSource(Sources source);
    Sources updateSource(Sources source);
    void deleteSource(Sources source);
    List<Topics> getAllTopics();

    Topics getTopics(Long id);
    Topics addTopics(Topics topic);
    Topics updateTopics(Topics topic);
    void deleteTopics(Topics topic);
    List<News> getAllNews();

    News getNews(Long id);
    News addNews(News news);
    News updateNews(News news);
    void deleteNews(News news);

    List<News> getNewsByTopicId(Long id);
    List<News> getNewsBySourceId(Long id);

}
