package com.example.hellomvc.controller;

import com.example.hellomvc.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HomeController {
    static List<User> list ;
    static {
        list = new ArrayList<>();
        list.add(new User(1L, "moly", "09274734737" ));
        list.add(new User(2L, "poly", "09274343478" ));
        list.add(new User(3L, "yoly", "09274734343" ));

    }
    @GetMapping(value =  "/")
    public String home(){
        return "Hello mvc";

    }

    @GetMapping(value =  "/test")
    public String test(){
        return "Hello test";

    }
    @GetMapping(value = "/users")
    public List<User> getList(){

        return this.list;
    }
    @GetMapping(value = "/user")
    public User getUser(){
        return new User(1L, "joni", "0845844545");

    }
    @GetMapping(value = "/user/{id}")
    public  User getUserById(@PathVariable("id") Long userid){
        User user = null;
        for (User u: this.list){
            if(userid == u.getId()){
                user = new User();
                user = new User(u.getId(), u.getUserName(), u.getMobile() );
                break;
            }

        }
        return user;
    }


    @GetMapping(value = "/user/{id}/{mobile}")
    public  User getUserById(@PathVariable("id") Long userid, @PathVariable("mobile") String mb){
        User user = null;
        for (User u: this.list){
            if(userid == u.getId() && mb.equalsIgnoreCase(u.getMobile())){
                user = new User();
                user = new User(u.getId(), u.getUserName(), u.getMobile() );
                break;
            }
        }
        return user;
         }


         @GetMapping(value = "/addUser")
         public List<User> addUserList(){

        list.add(new User(4l, "mila", "234873874385"));
        return list;
         }

long id = list.size();
    @GetMapping(value = "/add/{userName}/{mobile}")
    public List<User> addUserToListDynamiclly(@PathVariable("userName") String userName,@PathVariable("mobile") String m){
        id++;
        list.add(new User(id, userName, m));
        return list;
    }


    @GetMapping(value = "/del/{id}")
    public List<User> rempveUserList(@PathVariable("id") Long id){

        list.remove(getUserByI(id));
        return list;
    }


    public  User getUserByI( Long userid){
        User user = null;
        for (User u: this.list){
            if(userid == u.getId()){
                user = new User();
                user = new User(u.getId(), u.getUserName(), u.getMobile() );
                break;
            }
        }
        return user;
    }
}
