package com.example.game;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HeroController {
    
    @Autowired
    private HeroService heroService;
    
    @Autowired
    private QuestService questService;
    
    @GetMapping("/heroes")
    public String getHeroes(Model model) {
        ArrayList<Hero> heroes = heroService.getHeroes();
        model.addAttribute("heroes", heroes);
        return "heroes";
    }
    
    @PostMapping("/heroes")
    public String addHero(@RequestParam String heroName) {
        System.out.println("Saatiin: " + heroName);
        heroService.addHero(heroName);
        return "redirect:/heroes";
    }
    
    @GetMapping("heroes/{heroName}")
    public String getHeroInfo(@PathVariable String heroName, Model model) {
        Hero hero = heroService.findHeroByName(heroName);
        List<Quest> quests = questService.getQuests();
        model.addAttribute("hero", hero);
        model.addAttribute("quests", quests);
        return "hero";
    }
    
    @PostMapping("/tryquest")
    public String tryQuest(@RequestParam String heroName, String questName) {
        heroService.tryQuest(heroName, questName);
        return "redirect:/heroes/" + heroName;
    }
}
