package com.example.TenderBidding.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CreateTenderPageController {
    @GetMapping("/createtender")
    public String showCreateTenderPage() {
        return "createtenderpage";
    }
}
