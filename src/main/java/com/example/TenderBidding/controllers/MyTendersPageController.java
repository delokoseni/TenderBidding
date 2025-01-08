package com.example.TenderBidding.controllers;

import com.example.TenderBidding.models.Tender;
import com.example.TenderBidding.repositories.OrganizatsiyaRepository;
import com.example.TenderBidding.repositories.StatusTenderaRepository;
import com.example.TenderBidding.repositories.TenderRepository;
import com.example.TenderBidding.security.CustomUserDetails;
import com.example.TenderBidding.services.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
public class MyTendersPageController {

    @Autowired
    private com.example.TenderBidding.repositories.TenderRepository TenderRepository;
    @Autowired
    private com.example.TenderBidding.repositories.StatusTenderaRepository StatusTenderaRepository;
    @Autowired
    private com.example.TenderBidding.repositories.OrganizatsiyaRepository OrganizatsiyaRepository;
    @Autowired
    private CustomUserDetailsService customUserDetailsService;


    @GetMapping("/mytenders")
    public String showMyTendersPage(Model model) {
        //получение id
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();

        Long currentId = userDetails.getOrganizationId();

        List<Tender> tenders = TenderRepository.findMyTenders(currentId); // Получаем все тендеры
        model.addAttribute("tenders", tenders); // Добавляем тендеры в модель

        String status1, status2, status3 ,status4, status5;
        //Чтобы не искать постоянно запросом статусы, заранее делаем запрос и выбираем их
        status1 = StatusTenderaRepository.findById(1L).get(0).getStatus();
        status2 = StatusTenderaRepository.findById(2L).get(0).getStatus();
        status3 = StatusTenderaRepository.findById(3L).get(0).getStatus();
        status4 = StatusTenderaRepository.findById(4L).get(0).getStatus();
        status5 = StatusTenderaRepository.findById(5L).get(0).getStatus();

        model.addAttribute("status1", status1);
        model.addAttribute("status2", status2);
        model.addAttribute("status3", status3);
        model.addAttribute("status4", status4);
        model.addAttribute("status5", status5);

        return "mytenderspage";
    }

    @PostMapping("/UpdateIdTender")
    public String  withdrawTender(@RequestParam("tenderId") Long tenderId, RedirectAttributes redirectAttributes) {
        List<Tender> tenders = TenderRepository.findTendersById(tenderId);
        Tender tender = tenders.getFirst();

        if (tender != null) {
            tender.setId_statusa_tendera(5L); // Меняем статус на 5
            TenderRepository.save(tender); // Сохраняем изменения в базе данных
            redirectAttributes.addFlashAttribute("successMessage", "Тендер успешно отозван."); // Успешное сообщение (если необходимо)
        }

        // Вернуть на страницу с тендерами
        return "redirect:/mytenders"; // Перенаправляем на страницу с тендерами
    }

}