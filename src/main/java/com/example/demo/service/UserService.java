package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.persistence.IRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final IRepository iRepository;


    @Autowired
    public UserService(IRepository users) {
        this.iRepository = users;
    }

    public User saveUser(User user){
        if (    user.getName() == null ||
                user.getLastname1() == null ||
                user.getLastname2() ==null||
                user.getEmail() == null ||
                user.getPassword() == null
        ){
            return null;
        }else if (
                user.getName().isEmpty() ||
                        user.getLastname1().isEmpty() ||
                        user.getLastname2().isEmpty()||
                        user.getEmail().isEmpty() ||
                        user.getPassword().isEmpty()){
            return null;
        }else{
            return iRepository.save(user);
        }
    }

    public List<User> getAllUsers(){
        if(iRepository.count()>0){
            return iRepository.findAll();
        }else{
            return null;
        }
    }

    public User getById(Integer idUser){
        Optional<User> optionalUser = iRepository.findById(idUser);
        if (optionalUser.isPresent()){
            return optionalUser.get();
        }else{
            return  null;
        }
    }

    public User updateUser(User user){
        if (    user.getName()==null ||
                user.getLastname1()== null ||
                user.getLastname2()==null||
                user.getEmail()==null ||
                user.getPassword()==null
        ){
            return null;
        }else if (
                user.getName().isEmpty() ||
                        user.getLastname1().isEmpty() ||
                        user.getLastname2().isEmpty()||
                        user.getEmail().isEmpty() ||
                        user.getPassword().isEmpty()){
            return null;
        }else{
            return iRepository.save(user);
        }
    }

    public void deleteUser(User user){
        iRepository.delete(user);
    }

}
