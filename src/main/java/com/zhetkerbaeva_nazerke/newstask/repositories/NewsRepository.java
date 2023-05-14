package com.zhetkerbaeva_nazerke.newstask.repositories;

import com.zhetkerbaeva_nazerke.newstask.entities.News;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface NewsRepository extends JpaRepository<News, Long> {

    List<News> findByTopicId(Long id, Pageable pageable);

    List<News> findBySourcesId(Long id, Pageable pageable);
}
