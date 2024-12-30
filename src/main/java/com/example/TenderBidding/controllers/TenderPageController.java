package com.example.TenderBidding.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TenderPageController {

    @GetMapping("/tender")
    public String showTenderPage() {
        return "tenderpage";
    }
}