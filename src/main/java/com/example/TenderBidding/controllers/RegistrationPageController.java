package com.example.TenderBidding.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegistrationPageController {

    @GetMapping("/registration")
    public String showRegistrationPage() {
        return "registrationpage"; // Название HTML-шаблона
    }
}
