package com.example.TenderBidding.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RequestPageController {

    @GetMapping("/request")
    public String showRequestPage() {
        return "requestpage";
    }
}