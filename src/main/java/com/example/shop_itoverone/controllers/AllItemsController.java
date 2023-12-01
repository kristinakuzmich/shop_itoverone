package com.example.shop_itoverone.controllers;

import com.example.shop_itoverone.models.ItemModel;
import com.example.shop_itoverone.repos.ItemRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/allItems")
public class AllItemsController {

    private final ItemRepo itemRepo;

    public AllItemsController(ItemRepo itemRepo) {
        this.itemRepo = itemRepo;
    }

    @GetMapping
    public String getAllItems(Model model){
        List<ItemModel> list = itemRepo.findAll();
        model.addAttribute("items", list);
        System.out.println(list);
        return "allItems";
    }
}
