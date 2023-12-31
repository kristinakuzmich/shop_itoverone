package com.example.shop_itoverone.controllers;

import com.example.shop_itoverone.helpers.TimeHelper;
import com.example.shop_itoverone.models.ItemModel;
import com.example.shop_itoverone.repos.ItemRepo;
import com.example.shop_itoverone.services.FirebaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/")
public class MainController {

    private final ItemRepo itemRepo;

    @Autowired
    private FirebaseService firebaseService;

    public MainController(ItemRepo itemRepo) {
        this.itemRepo = itemRepo;
    }

    @GetMapping
    public String getMainPage(Model model){
        List<ItemModel> list = itemRepo.findAll();
        list = list.stream().limit(5).collect(Collectors.toList());
        list = TimeHelper.getTime(list);
        model.addAttribute("items", list);
        System.out.println(list);
        return "index";
    }
}
