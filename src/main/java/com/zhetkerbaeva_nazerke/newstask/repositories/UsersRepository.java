package com.zhetkerbaeva_nazerke.newstask.repositories;

import com.zhetkerbaeva_nazerke.newstask.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface UsersRepository extends JpaRepository<Users, Long> {
    Users findByUsername(String username);
}
