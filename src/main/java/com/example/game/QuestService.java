package com.example.game;


import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestService {
    //private ArrayList<Quest> quests;
    
    //@Autowired
    //private HeroService heroService;
    
    @Autowired
    private QuestRepository questRepository;
    
    /*public QuestService() {
        System.out.println("Luodaan questit...");
        this.quests = new ArrayList<>();
        this.quests.add(new Quest("Steal Sauron's monocle", 15));
        this.quests.add(new Quest("Conquer Dragon Mountain", 10));
        this.quests.add(new Quest("Bake magic cookies", 3));
    }*/
    
    public List<Quest> getQuests() {
        return this.questRepository.findAll();
        //return this.quests;
    }
    
    public void addQuest(String name, int difficulty) {
        this.questRepository.save(new Quest(name, difficulty));
        //this.quests.add(new Quest(name, difficulty));
    }
    
    public Quest findQuestByName(String questName) {
        return this.questRepository.findByName(questName).get(0);
        
        /*for (Quest quest : quests) {
            if (quest.getName().equals(questName)) {
                return quest;
            }
        }
        
        return null;*/
    }
    
    @Transactional
    public void deleteQuestByName(String name) {
        this.questRepository.deleteByName(name);
        //Quest quest = findQuestByName(name);
        //this.quests.remove(quest);
    }
    
    
}
