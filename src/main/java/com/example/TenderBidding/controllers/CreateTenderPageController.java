package com.example.TenderBidding.controllers;

import com.example.TenderBidding.models.Tender;
import com.example.TenderBidding.models.ZayavkaNaProvedenieTendera;
import com.example.TenderBidding.repositories.TenderRepository; // Импортируйте ваш репозиторий
import com.example.TenderBidding.repositories.ZayavkaNaProvedenieTenderaRepository;
import com.example.TenderBidding.security.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
public class CreateTenderPageController {

    @Autowired
    private TenderRepository tenderRepository; // Инициализируйте ваш репозиторий
    @Autowired
    private ZayavkaNaProvedenieTenderaRepository zayavkaNaProvedenieTenderaRepository; // Инициализируйте ваш репозиторий

    @GetMapping("/createtender")
    public String showCreateTenderPage() {
        return "createtenderpage";
    }

    @PostMapping("/createZayavka")
    public String createZayavka(@RequestParam(name = "tenderName", required = false) String tenderName,
                                @RequestParam(name = "description", required = false) String description,
                                @RequestParam(name = "startDate", required = false) LocalDate startDate,
                                @RequestParam(name = "endDate", required = false) LocalDate endDate,
                                @RequestParam(name = "startPrice", required = false) String startPrice,
                                Model model) {
        String error = null;

        // Проверка на наличие обязательных полей
        if (tenderName == null || tenderName.trim().isEmpty() ||
                description == null || description.trim().isEmpty() ||
                startDate == null ||
                endDate == null ||
                startPrice == null || startPrice.trim().isEmpty()) {
            model.addAttribute("error", "Пожалуйста, заполните все обязательные поля.");
            return "createtenderpage"; // Отправить обратно на страницу создания тендера
        }

        // Валидация даты начала и даты окончания
        LocalDate today = LocalDate.now();

        if (!startDate.isAfter(today) && startDate != today) {
            error = "Дата начала должна быть сегодняшней или в будущем.";
        } else if (!endDate.isAfter(startDate)) {
            error = "Дата окончания должна быть позже даты начала.";
        }

        // Валидация стартовой цены
        double startPriceValue = 0;
        try {
            startPriceValue = Double.parseDouble(startPrice);
            if (startPriceValue < 1) {
                error = "Начальная цена должна быть не меньше 1.";
            } else if (startPriceValue != Math.floor(startPriceValue)) {
                error = "Начальная цена должна быть целым числом.";
            }
        } catch (NumberFormatException e) {
            error = "Начальная цена должна быть корректным числом.";
        }

        // Если есть ошибка, добавляем ее в модель и перенаправляем на страницу
        if (error != null) {
            model.addAttribute("error", error);
            return "createtenderpage"; // Вернуть на страницу создания тендера с ошибкой
        }

        try {
            // Создание нового объекта заявки на проведение тендера
            ZayavkaNaProvedenieTendera zayavka = new ZayavkaNaProvedenieTendera();

            // Присвоение значений полям объекта
            zayavka.setDataNachalaTendera(startDate);
            zayavka.setDataOkonchaniyaTendera(endDate);
            zayavka.setNachalnayaTsena(startPriceValue);

            // Получение id_organizatsii из сессии
            Long organizationId = getCurrentUserOrganizationId();
            zayavka.setIdOrganizatsii(organizationId); // Установка id_organizatsii в заявку

            // Сохранение заявки в базе данных
            zayavkaNaProvedenieTenderaRepository.save(zayavka);

            // Создание нового объекта тендера
            Tender tender = new Tender();

            // Присвоение значений полям объекта
            tender.setNomer(tenderName);
            tender.setDokument(description);
            tender.setData_nachala(startDate);
            tender.setData_okonchaniya(endDate);
            tender.setNachalnaya_tsena(startPriceValue);
            tender.setId_zayavki_na_provedenie_tendera(zayavka.getIdZayavkiNaProvedenieTendera());

            tender.setId_organizatora(organizationId); // Установка id_organizatora в тендер

            // Сохранение тендера в базе данных
            tenderRepository.save(tender);
        } catch (Exception e) {
            model.addAttribute("error", "Не удалось сохранить данные в базе данных: " + e.getMessage());
            return "createtenderpage";
        }

        // Перенаправление на страницу создания тендера, передавая id заявки
        return "redirect:/myrequests";
    }

    private Long getCurrentUserOrganizationId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof CustomUserDetails) {
            CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
            return userDetails.getOrganizationId();
        }
        throw new IllegalStateException("Не удалось определить организацию авторизованного пользователя");
    }
}
