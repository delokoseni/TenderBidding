package com.example.TenderBidding.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SearchTenderPageController {
    @GetMapping("/searchtender")
    public String showSearchTenderPage() {
        return "searchtenderpage";
    }
}