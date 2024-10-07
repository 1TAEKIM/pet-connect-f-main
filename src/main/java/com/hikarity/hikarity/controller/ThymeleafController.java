package com.hikarity.hikarity.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.hikarity.hikarity.DTO.SearchDto;
import com.hikarity.hikarity.service.UserService;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;



@Slf4j
@Controller
public class ThymeleafController {
    
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String getMainPage(Model model) {
        List<Map<String, Object>> allAnimals = userService.getAll();
        

        model.addAttribute("animals", allAnimals);

        return "main";
    }

    @GetMapping("/animal/{Idx}")
    public String getDetailedAnimal(@PathVariable("Idx") String Idx, Model model) {
        Map<String, Object> animal = userService.getDetailedAnimal(Idx);  // Fetch the details of the animal by ID
        
        model.addAttribute("animal", animal);
        System.out.println(animal);
        return "detail";
}

    // @GetMapping("path")
    // public String getDetailed(@RequestParam String param, Model model) {

    //     Map<String, Object> detailedAnimals = userservice.

    //     return new String();
    // }
    
    // model.addAttribute("username", users.get("SPECIES_NM"));

    // @GetMapping("/login")
    // public String getLoginPage () {
    //     return "login";
    // }


    // @GetMapping("/kth")
    // public String kth(Model model, Principal principal) {
    //     Map<String,Object> users = userService.secMatch("kth");
    //     model.addAttribute("users", users);
    //     model.addAttribute("username", principal.getName());
    //     log.info(users.get("UserId").toString());

    //     return "kth";
    // }
    
    // @GetMapping("/cmh")
    // public String cmh(Model model, Principal principal) {
    //     Map<String,Object> users = userService.secMatch("cmh");
    //     model.addAttribute("users", users);
    //     model.addAttribute("username", principal.getName());
    //     return "cmh";
    // }
    
}
