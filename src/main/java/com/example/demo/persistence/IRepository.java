package com.example.demo.persistence;

import com.example.demo.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRepository extends CrudRepository<User, Integer> {
    List<User> findAll();
}
