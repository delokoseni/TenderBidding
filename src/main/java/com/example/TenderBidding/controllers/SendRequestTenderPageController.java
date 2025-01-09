package com.example.TenderBidding.controllers;

import com.example.TenderBidding.models.Tender;
import com.example.TenderBidding.models.ZayavkaNaUchastieVTendere;
import com.example.TenderBidding.repositories.ZayavkaNaUchastieVTendereRepository;
import com.example.TenderBidding.security.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class SendRequestTenderPageController {

    @Autowired
    private com.example.TenderBidding.repositories.TenderRepository TenderRepository;

    @Autowired
    private com.example.TenderBidding.repositories.ZayavkaNaUchastieVTendereRepository ZayavkaNaUchastieVTendereRepository;

    @GetMapping("/sendrequesttender")
    public String showSendRequestTenderPage(@RequestParam("id") Long tenderId, Model model) {

        model.addAttribute("tenderId", tenderId);
        List<Tender> tenders = TenderRepository.findTendersById(tenderId);
        Tender tender= tenders.getFirst();
        model.addAttribute("tender", tender);

        return "sendrequesttenderpage";
    }

    @PostMapping("/sendrequesttender")
    public String createZayavkaNaUchastie(
            @RequestParam("startPrice") Double startPrice,
            @RequestParam("idTendera") Long tenderId,
            RedirectAttributes redirectAttributes // Измените model на RedirectAttributes
    ) {

        // Получение id организации
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();

        Long currentId = userDetails.getOrganizationId();

        // Создание заявки
        ZayavkaNaUchastieVTendere zayavka = new ZayavkaNaUchastieVTendere();
        zayavka.setIdTendera(tenderId);
        zayavka.setIdOrganizatsiya(currentId);
        zayavka.setTsenaUchastnika(startPrice);
        // Сохранение заявки в БД
        ZayavkaNaUchastieVTendereRepository.save(zayavka);

        // Добавление сообщения в RedirectAttributes
        redirectAttributes.addFlashAttribute("message", "Заявка успешно отправлена.");

        // Формирование строки перенаправления
        return "redirect:/sendrequesttender?id=" + tenderId; // Потеряно .toString() - не нужно
    }

}
