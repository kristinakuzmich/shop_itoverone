package com.example.shop_itoverone.controllers;

import com.example.shop_itoverone.helpers.TimeHelper;
import com.example.shop_itoverone.models.ItemModel;
import com.example.shop_itoverone.repos.ItemRepo;
import com.example.shop_itoverone.services.FirebaseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {

    private final ItemRepo itemRepo;
    private final FirebaseService firebaseService;

    public CategoryController(ItemRepo itemRepo, FirebaseService firebaseService) {
        this.itemRepo = itemRepo;
        this.firebaseService = firebaseService;
    }

    @GetMapping("/toys")
    public String getToys(Model model){
        List<ItemModel> list = itemRepo.findAllByType("Игрушки");
        model.addAttribute("items", list);
        list.stream().forEach(i -> i.setUrl(firebaseService.getUrl(i.getUrl())));
        list = TimeHelper.getTime(list);
        return "allItems";
    }

    @GetMapping("/keyboards")
    public String getKeyboards(Model model){
        List<ItemModel> list = itemRepo.findAllByType("Клавиатуры");
        model.addAttribute("items", list);
        list.stream().forEach(i -> i.setUrl(firebaseService.getUrl(i.getUrl())));
        list = TimeHelper.getTime(list);
        return "allItems";
    }

    @GetMapping("/computers")
    public String getComputers(Model model){
        List<ItemModel> list = itemRepo.findAllByType("Компьютеры");
        model.addAttribute("items", list);
        list.stream().forEach(i -> i.setUrl(firebaseService.getUrl(i.getUrl())));
        list = TimeHelper.getTime(list);
        return "allItems";
    }
}
