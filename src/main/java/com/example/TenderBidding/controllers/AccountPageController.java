package com.example.TenderBidding.controllers;

import com.example.TenderBidding.models.Organizatsiya;
import com.example.TenderBidding.models.OwnershipType;
import com.example.TenderBidding.repositories.OrganizatsiyaRepository;
import com.example.TenderBidding.repositories.OwnershipTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@Controller
public class AccountPageController {

    @Autowired
    private OrganizatsiyaRepository organizatsiyaRepository;
    @Autowired
    private OwnershipTypeRepository ownershipTypeRepository;

    @GetMapping("/account")
    public String showAccountPage(Model model) {
        // Получаем текущего аутентифицированного пользователя
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserEmail = authentication.getName();

        // Получаем информацию о пользователе из базы данных
        Organizatsiya organizatsiya = organizatsiyaRepository.findByEmail(currentUserEmail)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Добавляем данные пользователя в модель
        model.addAttribute("organizationName", organizatsiya.getImya());
        model.addAttribute("inn", organizatsiya.getInn());
        model.addAttribute("ogrn", organizatsiya.getOgrn_ogrnip());
        if (organizatsiya.getId_forma_sobstvennosti() != null) {
            Optional<OwnershipType> ownershipTypeOpt = ownershipTypeRepository.findById_forma_sobstvennnosti(organizatsiya.getId_forma_sobstvennosti());
            model.addAttribute("ownershipType", ownershipTypeOpt.map(OwnershipType::getForma).orElse("отсутствует"));
        } else {
            model.addAttribute("ownershipType", "отсутствует");
        }
        model.addAttribute("establishmentDate", organizatsiya.getData_osnovaniya());
        model.addAttribute("email", organizatsiya.getEmail());

        // Возврат имени шаблона
        return "accountpage";
    }
}
