package com.example.shop_itoverone.repos;

import com.example.shop_itoverone.models.RequestModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestRepo extends JpaRepository<RequestModel, Long> {
}
