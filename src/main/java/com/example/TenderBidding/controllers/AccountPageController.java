package com.example.TenderBidding.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccountPageController {
    @GetMapping("/account")
    public String showAccountPage() {
        return "accountpage";
    }
}
