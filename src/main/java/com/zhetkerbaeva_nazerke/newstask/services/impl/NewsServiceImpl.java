package com.zhetkerbaeva_nazerke.newstask.services.impl;

import com.zhetkerbaeva_nazerke.newstask.entities.News;
import com.zhetkerbaeva_nazerke.newstask.entities.Sources;
import com.zhetkerbaeva_nazerke.newstask.entities.Topics;
import com.zhetkerbaeva_nazerke.newstask.repositories.NewsRepository;
import com.zhetkerbaeva_nazerke.newstask.repositories.SourcesRepository;
import com.zhetkerbaeva_nazerke.newstask.repositories.TopicsRepository;
import com.zhetkerbaeva_nazerke.newstask.services.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    public List<News> getAllNews(int pageNumber, int recordCount) {
        Pageable pageable = PageRequest.of(pageNumber, recordCount);
        return newsRepository.findAll(pageable).get().toList();
    }

    @Override
    public Sources getSource(Long id) {
        return sourcesRepository.findById(id).get();
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
    public void deleteSource(Long id) {
        sourcesRepository.deleteById(id);
    }

    @Override
    public Topics getTopics(Long id) {
        return topicsRepository.findById(id).get();
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
    public void deleteTopics(Long id) {
        topicsRepository.deleteById(id);
    }

    @Override
    public News getNews(Long id) {
        return newsRepository.findById(id).get();
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
    public void deleteNews(Long id) {
        newsRepository.deleteById(id);
    }

    @Override
    public List<News> getNewsByTopicId(Long id, int pageNumber, int recordCount) {
        Pageable pageable = PageRequest.of(pageNumber, recordCount);
        return newsRepository.findByTopicId(id, pageable);
    }

    @Override
    public List<News> getNewsBySourceId(Long id, int pageNumber, int recordCount) {
        Pageable pageable = PageRequest.of(pageNumber, recordCount);
        return newsRepository.findBySourcesId(id, pageable);
    }
}
