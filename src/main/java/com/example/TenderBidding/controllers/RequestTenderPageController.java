package com.example.TenderBidding.controllers;
import com.example.TenderBidding.models.ZayavkaNaProvedenieTendera;
import com.example.TenderBidding.repositories.ZayavkaNaProvedenieTenderaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class RequestTenderPageController {

    @Autowired
    private ZayavkaNaProvedenieTenderaRepository repository;
    @Autowired
    private ZayavkaNaProvedenieTenderaRepository zayavkaRepository;
    @GetMapping("/requestTender/{id}")
    public String showRequestPage(@PathVariable("id") Long id, Model model) {
        // Найти заявку по ID
        ZayavkaNaProvedenieTendera zayavka = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Заявка с ID " + id + " не найдена"));

        // Передать данные в модель
        model.addAttribute("zayavka", zayavka);

        // Вернуть шаблон
        return "requesttenderpage";
    }

    @RequestMapping(value = "/downloadFile", method = RequestMethod.POST)
    public ResponseEntity<byte[]> downloadFile(@RequestParam("idZayavki") Long idZayavki) {
        ZayavkaNaProvedenieTendera zayavka = zayavkaRepository.findById(idZayavki).orElseThrow(() -> new RuntimeException("Заявка не найдена"));
        byte[] fileData = zayavka.getUsloviyaPdf();

        if (fileData == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"document.pdf\"")
                .contentType(MediaType.APPLICATION_PDF)
                .body(fileData);
    }

    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    public String uploadFile(@RequestParam("idZayavki") Long idZayavki, @RequestParam("usloviyaPdf") MultipartFile file) throws IOException {
        ZayavkaNaProvedenieTendera zayavka = zayavkaRepository.findById(idZayavki).orElseThrow(() -> new RuntimeException("Заявка не найдена"));

        byte[] fileBytes = file.getBytes();
        zayavka.setUsloviyaPdf(fileBytes);

        zayavkaRepository.save(zayavka);

        return "redirect:/requestTender/" + idZayavki;

    }
}