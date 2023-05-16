package com.zhetkerbaeva_nazerke.newstask.extratask;

import com.zhetkerbaeva_nazerke.newstask.entities.Sources;
import com.zhetkerbaeva_nazerke.newstask.repositories.NewsRepository;
import com.zhetkerbaeva_nazerke.newstask.repositories.SourcesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootApplication
@EnableScheduling
@ComponentScan("com.zhetkerbaeva_nazerke.newstask")
public class DailyNewsTask {

    @Autowired
    private SourcesRepository sourcesRepository;

    @Autowired
    private NewsRepository newsRepository;

    private static final String FILE_PATH = "news_count.txt";

    public static void main(String[] args) {
        SpringApplication.run(DailyNewsTask.class, args);
    }

    @Scheduled(cron = "0 0 0 * * *")
    public void executeDailyTask() {
        List<Sources> newsSources = sourcesRepository.findAll();
        ExecutorService executor = Executors.newFixedThreadPool(newsSources.size());
        Map<String, Integer> newsCountMap = new HashMap<>();
        for (Sources source : newsSources) {
            newsCountMap.put(source.getSource(), 0);
        }

        for (Sources source : newsSources) {
            executor.execute(() -> {
                int newsCount = newsRepository.countBySourcesSource(source.getSource());
                synchronized (newsCountMap) {
                    newsCountMap.put(source.getSource(), newsCount);
                    System.out.println(newsCountMap);
                }
            });
        }

        executor.shutdown();
        while (!executor.isTerminated()) {
        }

        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_PATH))) {
            for (Sources source : newsSources) {
                int newsCount = newsCountMap.get(source.getSource());
                writer.println(source.getSource() + ": " + newsCount);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
