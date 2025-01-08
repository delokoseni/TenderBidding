package com.example.TenderBidding.controllers;

import com.example.TenderBidding.models.Organizatsiya;
import com.example.TenderBidding.models.Tender;
import com.example.TenderBidding.repositories.TenderRepository;
import com.example.TenderBidding.repositories.StatusTenderaRepository;

import com.example.TenderBidding.repositories.OrganizatsiyaRepository;
import com.example.TenderBidding.security.CustomUserDetails;
import com.example.TenderBidding.services.CustomUserDetailsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.security.core.Authentication;

import java.util.List;

@Controller
public class SearchTenderPageController {

    @Autowired
    private TenderRepository TenderRepository;
    @Autowired
    private StatusTenderaRepository StatusTenderaRepository;
    @Autowired
    private OrganizatsiyaRepository OrganizatsiyaRepository;
    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @GetMapping("/searchtender")
    public String showSearchTenderPage(Model model) {
        //получение id организации
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();

        Long currentId = userDetails.getOrganizationId();

        List<Tender> tenders = TenderRepository.findNotMyTenders(currentId); // Получаем все тендеры
        model.addAttribute("tenders", tenders); // Добавляем тендеры в модель

        List<Organizatsiya> organizations = OrganizatsiyaRepository.findAll(); // Получаем все тендеры
        model.addAttribute("organizations", organizations); // Добавляем тендеры в модель

        String status1, status2, status3 ,status4, status5 ;
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

        return "searchtenderpage"; // Возвращаем имя шаблона
    }

    @GetMapping("/search")
    public String searchTenders(@RequestParam("searchTerm") String searchTerm, Model model) {

        //получение id
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();

        Long currentId = userDetails.getOrganizationId();

        List<Tender> tenders = TenderRepository.findByName(searchTerm, currentId);
        model.addAttribute("tenders", tenders);

        List<Organizatsiya> organizations = OrganizatsiyaRepository.findAll(); // Получаем все тендеры
        model.addAttribute("organizations", organizations); // Добавляем тендеры в модель

        if(!tenders.isEmpty()) {
            String status1, status2, status3, status4;
            //Чтобы не искать постоянно запросом статусы, заранее делаем запрос и выбираем их
            status1 = StatusTenderaRepository.findById(1L).get(0).getStatus();
            status2 = StatusTenderaRepository.findById(2L).get(0).getStatus();
            status3 = StatusTenderaRepository.findById(3L).get(0).getStatus();
            status4 = StatusTenderaRepository.findById(4L).get(0).getStatus();

            model.addAttribute("status1", status1);
            model.addAttribute("status2", status2);
            model.addAttribute("status3", status3);
            model.addAttribute("status4", status4);
        }

        return "searchtenderpage"; // Возвращаем тот же шаблон
    }
}


