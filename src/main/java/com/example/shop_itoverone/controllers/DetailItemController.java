package com.example.shop_itoverone.controllers;

import com.example.shop_itoverone.helpers.ItemModelWithCurrency;
import com.example.shop_itoverone.helpers.TimeHelper;
import com.example.shop_itoverone.models.ItemModel;
import com.example.shop_itoverone.models.RequestModel;
import com.example.shop_itoverone.repos.ItemRepo;
import com.example.shop_itoverone.repos.RequestRepo;
import com.example.shop_itoverone.services.CurrencyService;
import com.example.shop_itoverone.services.FirebaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@RequestMapping("/item")
public class DetailItemController {
    @Autowired
    ItemRepo itemRepo;
    @Autowired
    CurrencyService currencyService;
    @Autowired
    RequestRepo requestRepo;
    @Autowired
    FirebaseService firebaseService;


    @GetMapping("/{id}")
    public String getDetailPage(@PathVariable long id,
                                Model model){
        ItemModel itemModel = itemRepo.findById(id);
        ItemModelWithCurrency itemModelWithCurrency = new ItemModelWithCurrency(itemModel);
        itemModelWithCurrency.setEurPrice(currencyService.getEurPrice(itemModel.getPrice()));
        itemModelWithCurrency.setUsdPrice(currencyService.getUsdPrice(itemModel.getPrice()));
        itemModelWithCurrency.setUrl(firebaseService.getUrl(itemModelWithCurrency.getUrl()));
        model.addAttribute("item", itemModelWithCurrency);
        return "detailitem";
    }

    @PostMapping("/{id}")
    public RedirectView saveData(@PathVariable long id,
                                @RequestParam String name,
                                @RequestParam String phoneNumber) {
        RequestModel requestModel = new RequestModel();
        requestModel.setName(name);
        requestModel.setItemId(id);
        requestModel.setPhoneNumber(phoneNumber);
        requestRepo.save(requestModel);
        return new RedirectView("/");
    }
}
