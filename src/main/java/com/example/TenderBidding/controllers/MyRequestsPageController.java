package com.example.TenderBidding.controllers;

import com.example.TenderBidding.repositories.ZayavkaNaProvedenieTenderaRepository;
import com.example.TenderBidding.repositories.ZayavkaNaUchastieVTendereRepository;
import com.example.TenderBidding.models.ZayavkaNaProvedenieTendera;
import com.example.TenderBidding.models.ZayavkaNaUchastieVTendere;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import com.example.TenderBidding.security.CustomUserDetails;
import java.util.List;

@Controller
public class MyRequestsPageController {

    @Autowired
    private ZayavkaNaProvedenieTenderaRepository zayavkaNaProvedenieTenderaRepository;

    @Autowired
    private ZayavkaNaUchastieVTendereRepository zayavkaNaUchastieVTendereRepository;

    @GetMapping("/myrequests")
    public String showMyRequestsPage(Model model) {
        Long currentOrganizationId = getCurrentUserOrganizationId();

        // Получение заявок, связанных с текущей организацией
        List<ZayavkaNaProvedenieTendera> zayavkiNaProvedenie =
                zayavkaNaProvedenieTenderaRepository.findByIdOrganizatsii(currentOrganizationId);
        List<ZayavkaNaUchastieVTendere> zayavkiNaUchastie =
                zayavkaNaUchastieVTendereRepository.findByIdOrganizatsiya(currentOrganizationId);

        // Добавление данных в модель для отображения на странице
        model.addAttribute("zayavkiNaProvedenie", zayavkiNaProvedenie);
        model.addAttribute("zayavkiNaUchastie", zayavkiNaUchastie);

        return "myrequestspage";
    }

    private Long getCurrentUserOrganizationId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof CustomUserDetails) {
            CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
            return userDetails.getOrganizationId(); // Предполагается, что у пользователя есть это поле.
        }
        throw new IllegalStateException("Не удалось определить организацию авторизованного пользователя");
    }
}
