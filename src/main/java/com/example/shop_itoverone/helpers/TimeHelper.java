package com.example.shop_itoverone.helpers;

import com.example.shop_itoverone.models.ItemModel;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class TimeHelper {
    public static List<ItemModel> getTime(List<ItemModel> list) {
        for (ItemModel i : list){
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm dd.MM");
            i.setTimeFormat(simpleDateFormat.format(new Date(i.getTime())));
        }
        return list;
    }
}
