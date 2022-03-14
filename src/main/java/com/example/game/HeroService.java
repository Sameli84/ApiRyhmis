package com.example.game;


import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HeroService {
    //private ArrayList<Hero> heroes;
    
    @Autowired
    private QuestService questService;
    
    @Autowired
    private HeroRepository heroRepository;
    
    /*public HeroService() {
        System.out.println("Luodaan heroService");
        this.heroes = new ArrayList<>();
        Hero h1 = new Hero("Aragorn", "Watering the White Tree...", 10, 5, 2000);
        heroes.add(h1);
        heroes.add(new Hero("Galadriel", "Hanging out in Lothlorien...", 15, 3, 6000));
        heroes.add(new Hero("Sir Lothar", "Being a knight", 2, 2, 1000));
    }*/

    public ArrayList<Hero> getHeroes() {
        return this.heroRepository.findAll();
        //return heroes;
    }
    
    public void addHero(String name) {
        this.heroRepository.save(new Hero(name));
        //this.heroes.add(new Hero(name));
    }
    
    public Hero findHeroByName(String heroName) {
        return this.heroRepository.findByName(heroName).get(0);
        
        /*for (Hero hero : heroes) {
            if (hero.getName().equals(heroName)) {
                return hero;
            }
        }
        
        return null;*/
    }
    
    public void tryQuest(String heroName, String questName) {
        Hero hero = this.findHeroByName(heroName);
        Quest quest = questService.findQuestByName(questName);
        
        for (int i = 0; i < hero.getLevel(); i++) {
            int x = (int) (Math.random() * 20) + 1;
            
            if (x > quest.getDifficulty()) {
                hero.completeQuest();
                this.heroRepository.save(hero);
                return;
            }
        }
        
        hero.failQuest();
        this.heroRepository.save(hero);
    }
    
}
