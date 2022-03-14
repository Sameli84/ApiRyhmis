package com.example.game;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;


public interface QuestRepository extends JpaRepository<Quest, Long> {
    ArrayList<Quest> findByName(String name);
    Long deleteByName(String name);
}
