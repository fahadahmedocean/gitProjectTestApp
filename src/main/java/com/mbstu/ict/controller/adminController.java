package com.mbstu.ict.controller;

import com.mbstu.ict.dao.StudentRepository;
import com.mbstu.ict.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;


@Controller
public class adminController {


    @Autowired
    private StudentRepository studentRepository;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
        System.out.println("-----------index-------------");
        List<Student> studentList = studentRepository.findAll();
        model.addAttribute("studentList", studentList);
        model.addAttribute("myMessage","Hey we have run it successfully.....");


        return "index";
    }

    @RequestMapping(value = "/upsertStudent", method = RequestMethod.GET)
    public String studentView(Model model, @RequestParam(value="studentId", required=false) Integer studentId) {
        System.out.println("-----------index-------------studentId:"+studentId);
        Student student = studentRepository.getStudentById(studentId);
        model.addAttribute("student", student);
        return "student";
    }

    @RequestMapping(value = "/upsertStudent", method = RequestMethod.POST)
    public String studentPost(Model model, @ModelAttribute("student") Student student, HttpServletRequest request) {
        System.out.println("-----------studentPost-------------");
        System.out.println(student);

        try{
            studentRepository.save(student);
            request.setAttribute("message", "Student saved successfully");
        }catch(Exception e){
            request.setAttribute("message", "Faild to save Student");
        }
        return "redirect:./";
    }

    @RequestMapping(value = "/deleteStudent", method = RequestMethod.GET)
    public String deleteStudent(Model model, @RequestParam(value="studentId", required=false) Integer studentId) {
        System.out.println("TES TLOG ADDED :"+studentId);
        Student student = studentRepository.getStudentById(studentId);
        studentRepository.delete(student);
        return "redirect:./";
    }
}


