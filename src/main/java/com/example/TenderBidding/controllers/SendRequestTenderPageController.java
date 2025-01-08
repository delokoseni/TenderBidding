package com.example.TenderBidding.controllers;

import com.example.TenderBidding.models.Tender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SendRequestTenderPageController {

    @Autowired
    private com.example.TenderBidding.repositories.TenderRepository TenderRepository;

    @GetMapping("/sendrequesttender")
    public String showSendRequestTenderPage(@RequestParam("id") Long tenderId, Model model) {

        model.addAttribute("tenderId", tenderId);
        List<Tender> tenders = TenderRepository.findTendersById(tenderId);
        Tender tender= tenders.getFirst();
        model.addAttribute("tender", tender);










        return "sendrequesttenderpage";
    }
}
