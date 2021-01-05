/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.springbootdemo.controller;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author nacer
 */
@Controller
public class MainController {
    String name = "John";
    int number = 42;
    
    @GetMapping("test")
    public String testPage(Model model) {

        model.addAttribute("number", number);
        model.addAttribute("firstName", name);

        return "test";
    }
    
    @PostMapping("testForm")
    public String testForm(HttpServletRequest request) {
        name = request.getParameter("formFirstName");
        number = Integer.parseInt(request.getParameter("formNumber"));
        
        return "redirect:/test";
    }
    
    @GetMapping("testList") 
    public String testList(Model model) {
        List<Integer> numbers = new ArrayList<>();
        
        numbers.add(0);
        numbers.add(10);
        numbers.add(6);
        numbers.add(35);
        
        model.addAttribute("numberList", numbers);
        
        return "testList";
    }
    
    @GetMapping("testConditional")
    public String testConditional(Model model) {
        
        model.addAttribute("truth", true);
        model.addAttribute("theNumber", 33);
        model.addAttribute("aString", "testing");
        
        return "testConditional";
    }
}
