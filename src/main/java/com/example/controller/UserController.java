package com.example.controller;

import com.example.po.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    //获取列表数据,跳转到模板页面
    @GetMapping("/")
    public String getList(Model m){
        List<User> list = userService.findAll();
        m.addAttribute("list",list);
        return "list";
    }

    //点击add,跳转至添加用户界面
    @RequestMapping("/toAdd")
    public String toAdd(){
        return "add";
    }

    @PostMapping("/add")
    public String save(User user){
        userService.add(user);
        return "redirect:/";
    }


    //编辑
    @GetMapping("/toEdit/{id}")
    public String toEdit(@PathVariable("id") Long id, Model m){
        User user = userService.findOne(id);
        m.addAttribute("user",user);
        return "edit";
    }

    @PostMapping("/update")
    public String update(User user){
        userService.update(user);
        return "redirect:/";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id){
        userService.delete(id);
        return "redirect:/";
    }

}
