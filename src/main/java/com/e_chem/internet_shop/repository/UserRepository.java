package com.e_chem.internet_shop.repository;

import com.e_chem.internet_shop.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {

    @Override
    @Query("select distinct u from User u left join fetch u.address left join fetch u.phoneNumberList")
    List<User> findAll();
}
