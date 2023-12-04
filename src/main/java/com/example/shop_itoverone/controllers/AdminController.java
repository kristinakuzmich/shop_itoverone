package com.example.shop_itoverone.controllers;

import com.example.shop_itoverone.helpers.TimeHelper;
import com.example.shop_itoverone.models.ItemModel;
import com.example.shop_itoverone.models.RequestModel;
import com.example.shop_itoverone.repos.ItemRepo;
import com.example.shop_itoverone.repos.RequestRepo;
import com.example.shop_itoverone.services.FirebaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    RequestRepo requestRepo;

    @Autowired
    ItemRepo itemRepo;

    @Autowired
    FirebaseService firebaseService;

    @GetMapping
    public String getAdmin() {
        return "admin";
    }

    @GetMapping("/edit")
    public String getAll(Model model) {
        List<ItemModel> list = itemRepo.findAll();
        model.addAttribute("items", list);
        list.stream().forEach(i -> i.setUrl(firebaseService.getUrl(i.getUrl())));
        list = TimeHelper.getTime(list);
        return "editItems";
    }

    @GetMapping("/req")
    public String getPage(Model model) {
        List<RequestModel> list = requestRepo.findAll();
        model.addAttribute("req", list);
        return "requests";
    }
}
