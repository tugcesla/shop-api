package com.example.shop.shopapi.repo;

import com.example.shop.shopapi.domain.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {}
