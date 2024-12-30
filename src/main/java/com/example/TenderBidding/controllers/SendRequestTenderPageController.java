package com.example.TenderBidding.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SendRequestTenderPageController {
    @GetMapping("/sendrequesttender")
    public String showSendRequestTenderPage() {
        return "sendrequesttenderpage";
    }
}
