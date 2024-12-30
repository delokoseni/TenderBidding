package com.example.TenderBidding.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyTendersPageController {

    @GetMapping("/mytenders")
    public String showMyTendersPage() {
        return "mytenderspage";
    }
}