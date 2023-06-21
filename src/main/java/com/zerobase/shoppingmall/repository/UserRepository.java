package com.zerobase.shoppingmall.repository;

import com.zerobase.shoppingmall.domain.ShoppingUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;

@Repository
public interface UserRepository extends JpaRepository<ShoppingUser, Long> {
    ShoppingUser findAllById(Long id);
}
