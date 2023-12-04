package com.example.shop_itoverone.helpers;

import com.example.shop_itoverone.models.ItemModel;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class ItemModelWithCurrency {
    private Long id;
    private String name;

    double price;

    private String disc;

    private String url;

    Long time;

    private String type;

    private String timeFormat;

    private double usdPrice;
    private double eurPrice;

    public ItemModelWithCurrency() {
    }

    public ItemModelWithCurrency(ItemModel itemModel) {
        this.id = itemModel.getId();
        this.name = itemModel.getName();
        this.price = itemModel.getPrice();
        this.disc = itemModel.getDisc();
        this.url = itemModel.getUrl();
        this.time = itemModel.getTime();
        this.type = itemModel.getType();
        this.timeFormat = itemModel.getTimeFormat();
    }
}
