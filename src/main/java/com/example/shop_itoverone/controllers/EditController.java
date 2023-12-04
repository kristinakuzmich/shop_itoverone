package com.example.shop_itoverone.controllers;

import com.example.shop_itoverone.models.ItemModel;
import com.example.shop_itoverone.models.RequestModel;
import com.example.shop_itoverone.repos.ItemRepo;
import com.example.shop_itoverone.services.FirebaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/edit")
public class EditController {
    @Autowired
    ItemRepo itemRepo;

    @Autowired
    FirebaseService firebaseService;

    @GetMapping("/{id}")
    public String edit(@PathVariable long id,
                       Model model) {
        ItemModel itemModel = itemRepo.findById(id);
        itemModel.setUrl(firebaseService.getUrl(itemModel.getUrl()));
        model.addAttribute("item", itemModel);
        return "edit";
    }

    @PostMapping("/{id}")
    public RedirectView setChanges(@PathVariable long id,
                             @RequestParam String name,
                             @RequestParam double price,
                             @RequestParam String disc,
                             @RequestParam String url) {
        ItemModel itemModel = itemRepo.findById(id);
        itemModel.setName(name);
        itemModel.setDisc(disc);
        itemModel.setPrice(price);
        itemModel.setUrl(url);
        itemRepo.save(itemModel);
        return new RedirectView("/");
    }
}
