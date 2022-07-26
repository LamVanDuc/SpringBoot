package com.example.demo.controller.view.admin;


import com.example.demo.dto.dtoStudent;
import com.example.demo.entities.Student;
import com.example.demo.services.StudentServicesImplements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin/")
public class UserController {

    @Autowired
    private StudentServicesImplements studentServicesImplements;

    @GetMapping("student")
    public String showListUser(Model model){
 //       List<dtoStudent> students = studentServicesImplements.getAllStudent();
 //       model.addAttribute("studentslist",students);
        return "student";
    }


    @GetMapping("insertstudent")
    //@ModelAttribute("studentForm") Student newStudent,Model model
    public String insertStudent(){
//        Object result =  studentServicesImplements.insertStudent(newStudent);
//        model.addAttribute("result",result);
        return "insertstudent";
    }

    @GetMapping("index")
    public String showIndex(){
        return "index";
    }

    @GetMapping("login")
    public String showLogin(){
        return "login";
    }


}
