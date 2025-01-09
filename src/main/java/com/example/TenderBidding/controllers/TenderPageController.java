package com.example.TenderBidding.controllers;

import com.example.TenderBidding.models.Tender;
import com.example.TenderBidding.models.ZayavkaNaUchastieVTendere;
import com.example.TenderBidding.repositories.StatusZayavkiNaUchastieRepository;
import com.example.TenderBidding.repositories.TenderRepository;
import com.example.TenderBidding.security.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
public class TenderPageController {

    @Autowired
    private com.example.TenderBidding.repositories.TenderRepository TenderRepository;
    @Autowired
    private com.example.TenderBidding.repositories.StatusZayavkiNaUchastieRepository StatusZayavkiNaUchastieRepository;
    @Autowired
    private com.example.TenderBidding.repositories.ZayavkaNaUchastieVTendereRepository ZayavkaNaUchastieVTendereRepository;

    @GetMapping("/tender")
    public String showTenderPage(@RequestParam("id") Long id, Model model) {

        //получение id организации
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();

        Long currentId = userDetails.getOrganizationId();

        model.addAttribute("tenderId", id);
        model.addAttribute("userId", currentId);

        List<Tender> tenders = TenderRepository.findTendersById(id);
        Tender tender= tenders.getFirst();
        model.addAttribute("tender", tender);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String formattedStartDate = tender.getData_nachala().format(formatter);
        String formattedEndDate = tender.getData_okonchaniya().format(formatter);

        // Добавление отформатированных дат в модель
        model.addAttribute("startDate", formattedStartDate);
        model.addAttribute("endDate", formattedEndDate);

        List<ZayavkaNaUchastieVTendere> zayavki = ZayavkaNaUchastieVTendereRepository.findByIdTendera(id);
        model.addAttribute("zayavki", zayavki);

        String status1, status2, status3;
        //Чтобы не искать постоянно запросом статусы, заранее делаем запрос и выбираем их
        status1 = StatusZayavkiNaUchastieRepository.findById(1L).get(0).getStatus();
        status2 = StatusZayavkiNaUchastieRepository.findById(2L).get(0).getStatus();
        status3 = StatusZayavkiNaUchastieRepository.findById(3L).get(0).getStatus();

        model.addAttribute("status1", status1);
        model.addAttribute("status2", status2);
        model.addAttribute("status3", status3);

        return "tenderpage"; // имя вашего шаблона
    }
}