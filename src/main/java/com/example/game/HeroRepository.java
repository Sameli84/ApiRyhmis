package com.example.game;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HeroRepository extends JpaRepository<Hero, Long> {
    @Override
    ArrayList<Hero> findAll();
    ArrayList<Hero> findByName(String name);
}
