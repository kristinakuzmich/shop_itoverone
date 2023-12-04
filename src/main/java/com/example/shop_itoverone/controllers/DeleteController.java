package com.example.shop_itoverone.controllers;

import com.example.shop_itoverone.helpers.TimeHelper;
import com.example.shop_itoverone.models.ItemModel;
import com.example.shop_itoverone.repos.ItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@RequestMapping("/delete")
public class DeleteController {
    @Autowired
    ItemRepo itemRepo;

    @GetMapping("/{id}")
    public RedirectView delete(@PathVariable long id){
        itemRepo.deleteById(id);
        return new RedirectView("/admin/edit");
    }

}
