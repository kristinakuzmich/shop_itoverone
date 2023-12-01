package com.example.shop_itoverone.controllers;

import com.example.shop_itoverone.models.ItemModel;
import com.example.shop_itoverone.repos.ItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/addItem")
public class AddItemController {
    @Autowired
    ItemRepo itemRepo;

    @GetMapping
    public String addItemPage() {
        return "addItem";
    }

    @PostMapping
    public RedirectView addData(@RequestParam String name,
                                @RequestParam String price,
                                @RequestParam String disc,
                                @RequestParam String url,
                                @RequestParam String type) {
        ItemModel itemModel = new ItemModel();
        itemModel.setDisc(disc);
        itemModel.setName(name);
        try {
            itemModel.setPrice(Integer.parseInt(price));
        } catch (Exception e) {
            itemModel.setPrice(-10);
        }
        itemModel.setUrl(url);
        itemModel.setTime(System.currentTimeMillis());
        itemModel.setType(type);
        itemRepo.save(itemModel);
        return new RedirectView("/");
    }
}