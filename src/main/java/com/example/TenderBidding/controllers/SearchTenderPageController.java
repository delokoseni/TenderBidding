package com.example.TenderBidding.controllers;

import com.example.TenderBidding.models.Organizatsiya;
import com.example.TenderBidding.models.Tender;
import com.example.TenderBidding.repositories.TenderRepository;
import com.example.TenderBidding.repositories.StatusTenderaRepository;

import com.example.TenderBidding.repositories.OrganizatsiyaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SearchTenderPageController {

    @Autowired
    private TenderRepository TenderRepository;
    @Autowired
    private StatusTenderaRepository StatusTenderaRepository;
    @Autowired
    private OrganizatsiyaRepository OrganizatsiyaRepository;

    @GetMapping("/searchtender")
    public String showSearchTenderPage(Model model) {
        List<Tender> tenders = TenderRepository.findAll(); // Получаем все тендеры
        model.addAttribute("tenders", tenders); // Добавляем тендеры в модель

        List<Organizatsiya> organizations = OrganizatsiyaRepository.findAll(); // Получаем все тендеры
        model.addAttribute("organizations", organizations); // Добавляем тендеры в модель

        String status1, status2, status3 ,status4;
        //Чтобы не искать постоянно запросом статусы, заранее делаем запрос и выбираем их
        status1 = StatusTenderaRepository.findById(1L).get(0).getStatus();
        status2 = StatusTenderaRepository.findById(2L).get(0).getStatus();
        status3 = StatusTenderaRepository.findById(3L).get(0).getStatus();
        status4 = StatusTenderaRepository.findById(4L).get(0).getStatus();

        model.addAttribute("status1", status1);
        model.addAttribute("status2", status2);
        model.addAttribute("status3", status3);
        model.addAttribute("status4", status4);

        return "searchtenderpage"; // Возвращаем имя шаблона
    }

    @GetMapping("/search")
    public String searchTenders(@RequestParam("searchTerm") String searchTerm, Model model) {
        List<Tender> tenders = TenderRepository.findByName(searchTerm);
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


