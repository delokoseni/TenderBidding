package com.example.TenderBidding.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyRequestsPageController {

    @GetMapping("/myrequests")
    public String showMyRequestsPage() {
        return "myrequestspage";
    }
}