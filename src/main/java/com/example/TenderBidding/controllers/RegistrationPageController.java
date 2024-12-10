package com.example.TenderBidding.controllers;

import com.example.TenderBidding.models.OwnershipType;
import com.example.TenderBidding.models.Okved;
import com.example.TenderBidding.repositories.OwnershipTypeRepository;
import com.example.TenderBidding.repositories.OkvedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class RegistrationPageController {

    @Autowired
    private OkvedRepository okvedRepository;

    @Autowired
    private OwnershipTypeRepository ownershipTypeRepository;

    @GetMapping("/registration")
    public String showRegistrationForm(Model model) {
        List<OwnershipType> ownershipTypes = ownershipTypeRepository.findAll();
        model.addAttribute("ownershipTypes", ownershipTypes);

        List<Okved> okvedList = okvedRepository.findAll();
        model.addAttribute("okvedList", okvedList);

        return "registrationpage"; // Шаблон, который вы используете
    }

}
