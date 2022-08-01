package com.example.demo.controller.view.admin;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

@RequestMapping("")
public class AdminController {

    @GetMapping("/user/student")
    public String showListUser(Model model){
        //       List<dtoStudent> students = studentServicesImplements.getAllStudent();
        //       model.addAttribute("studentslist",students);
        return "student/student";
    }


    @GetMapping("/user/insertstudent")
    //@ModelAttribute("studentForm") Student newStudent,Model model
    public String insertStudent(){
//        Object result =  studentServicesImplements.insertStudent(newStudent);
//        model.addAttribute("result",result);
        return "/user/insertstudent";
    }

    @GetMapping("/user/updateStudent")
    public String updateStudent(){
        return "/student/updateStudent";

    }


    @GetMapping("/admin/index")
    public String showHomeAdmin(){
        return "admin/index";
    }


    @GetMapping("/")
    public String showLogin(){
        return "/admin/login";
    }


    @GetMapping("/login")
    public String showForm(Model model){
        return "/admin/login";
    }


    @GetMapping("/logout")
    public String showLogout(Model model){
        model.addAttribute("title", "Logout");
        return "/admin/login";
    }


    @GetMapping("/403")
    public String showPermi(){
        return "/403";
    }

}
