package com.zhetkerbaeva_nazerke.newstask.services.impl;

import com.zhetkerbaeva_nazerke.newstask.entities.News;
import com.zhetkerbaeva_nazerke.newstask.entities.Sources;
import com.zhetkerbaeva_nazerke.newstask.entities.Topics;
import com.zhetkerbaeva_nazerke.newstask.repositories.NewsRepository;
import com.zhetkerbaeva_nazerke.newstask.repositories.SourcesRepository;
import com.zhetkerbaeva_nazerke.newstask.repositories.TopicsRepository;
import com.zhetkerbaeva_nazerke.newstask.services.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    NewsRepository newsRepository;

    @Autowired
    SourcesRepository sourcesRepository;

    @Autowired
    TopicsRepository topicsRepository;

    @Override
    public List<Sources> getAllSources() {
        return sourcesRepository.findAll();
    }

    @Override
    public List<Topics> getAllTopics() {
        return topicsRepository.findAll();
    }

    @Override
    public List<News> getAllNews() {
        return newsRepository.findAll();
    }

    @Override
    public Sources getSource(Long id) {
        return sourcesRepository.getOne(id);
    }

    @Override
    public Sources addSource(Sources source) {
        return sourcesRepository.save(source);
    }

    @Override
    public Sources updateSource(Sources source) {
        return sourcesRepository.save(source);
    }

    @Override
    public void deleteSource(Sources source) {
        sourcesRepository.delete(source);
    }

    @Override
    public Topics getTopics(Long id) {
        return topicsRepository.getOne(id);
    }

    @Override
    public Topics addTopics(Topics topic) {
        return topicsRepository.save(topic);
    }

    @Override
    public Topics updateTopics(Topics topic) {
        return topicsRepository.save(topic);
    }

    @Override
    public void deleteTopics(Topics topic) {
        topicsRepository.delete(topic);
    }

    @Override
    public News getNews(Long id) {
        return newsRepository.getOne(id);
    }

    @Override
    public News addNews(News news) {
        return newsRepository.save(news);
    }

    @Override
    public News updateNews(News news) {
        return newsRepository.save(news);
    }

    @Override
    public void deleteNews(News news) {
        newsRepository.delete(news);
    }

    @Override
    public List<News> getNewsByTopicId(Long id) {
        return newsRepository.findByTopicId(id);
    }

    @Override
    public List<News> getNewsBySourceId(Long id) {
        return newsRepository.findBySourcesId(id);
    }
}
