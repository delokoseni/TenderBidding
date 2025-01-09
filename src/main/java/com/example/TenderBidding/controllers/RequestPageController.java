package com.example.TenderBidding.controllers;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.example.TenderBidding.models.ZayavkaNaProvedenieTendera;
import com.example.TenderBidding.models.ZayavkaNaUchastieVTendere;
import com.example.TenderBidding.repositories.ZayavkaNaUchastieVTendereRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.example.TenderBidding.repositories.ZayavkaNaProvedenieTenderaRepository;
@Controller
public class RequestPageController {

    @Autowired
    private ZayavkaNaUchastieVTendereRepository repository;
    @GetMapping("/request/{id}")
    public String showRequestPage(@PathVariable("id") Long id, Model model) {
        // Найти заявку по ID
        ZayavkaNaUchastieVTendere zayavka = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Заявка с ID " + id + " не найдена"));

        // Передать данные в модель
        model.addAttribute("zayavka", zayavka);

        // Вернуть шаблон
        return "requestpage";
    }

}
