package com.example.demo.controller;

public interface IUserController<T> {
    Object getAll();
    T getById(Integer id);
    T save(T t);
}
