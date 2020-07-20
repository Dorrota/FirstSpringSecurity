package com.ailleron.security.repository;

import com.ailleron.security.domain.Ankieta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnkietaRepository extends JpaRepository<Ankieta, Long> {
}
