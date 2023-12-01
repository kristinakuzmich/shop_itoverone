package com.example.shop_itoverone.repos;

import com.example.shop_itoverone.models.ItemModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepo extends JpaRepository<ItemModel, Long> {
}
