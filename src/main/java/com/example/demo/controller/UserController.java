package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(value = "/api/user")
public class UserController implements IUserController<User>{

    UserService userService;

    @Autowired
    UserController(UserService userService){
        this.userService = userService;
    }

    @Override
    @GetMapping("/get-all-users")
    public Object getAll() {
        return userService.getAllUsers();
    }

    @Override
    @GetMapping("/get-user/{id}")
    public User getById(@PathVariable("id") Integer id) {
        return userService.getById(id);
    }

    @Override
    @PostMapping("/create-user")
    public User save(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @DeleteMapping("/delete-user/{id}")
    public ResponseEntity<User> delete(@PathVariable("id") Integer id) {
        User user = userService.getById(id);
        if (user==null){
            return null;
        }else{
            userService.deleteUser(user);
            return ResponseEntity.ok(user);
        }
    }

    @PutMapping("/update-user/{id}")
    public ResponseEntity<User> update(@PathVariable("id") Integer id, @RequestBody User userupdate) {
        User user =userService.getById(id);

        user.setName(userupdate.getName());
        user.setLastname1(userupdate.getLastname1());
        user.setLastname2(userupdate.getLastname2());
        user.setEmail(userupdate.getEmail());
        user.setPassword(userupdate.getPassword());

        User updatedUser = userService.updateUser(user);

        return ResponseEntity.ok(updatedUser);
    }


}
