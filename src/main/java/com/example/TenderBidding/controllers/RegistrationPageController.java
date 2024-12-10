package com.example.TenderBidding.controllers;

import com.example.TenderBidding.models.OwnershipType;
import com.example.TenderBidding.repositories.OwnershipTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class RegistrationPageController {

    @Autowired
    private OwnershipTypeRepository ownershipTypeRepository;

    @GetMapping("/registration")
    public String showRegistrationForm(Model model) {
        List<OwnershipType> ownershipTypes = ownershipTypeRepository.findAll();
        System.out.println("Ownership Types: " + ownershipTypes); // Для отладки
        model.addAttribute("ownershipTypes", ownershipTypes);
        return "registrationpage"; // имя вашего файла шаблона
    }

}
