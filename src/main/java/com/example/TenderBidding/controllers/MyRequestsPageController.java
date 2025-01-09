package com.example.TenderBidding.controllers;

import com.example.TenderBidding.models.ZayavkaNaProvedenieTendera;
import com.example.TenderBidding.models.ZayavkaNaUchastieVTendere;
import com.example.TenderBidding.repositories.ZayavkaNaProvedenieTenderaRepository;
import com.example.TenderBidding.repositories.ZayavkaNaUchastieVTendereRepository;
import com.example.TenderBidding.repositories.StatusZayavkiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import com.example.TenderBidding.security.CustomUserDetails;
import com.example.TenderBidding.models.StatusZayavki;

import java.util.List;

@Controller
public class MyRequestsPageController {

    @Autowired
    private ZayavkaNaProvedenieTenderaRepository zayavkaNaProvedenieTenderaRepository;

    @Autowired
    private ZayavkaNaUchastieVTendereRepository zayavkaNaUchastieVTendereRepository;

    @Autowired
    private StatusZayavkiRepository statusZayavkiRepository;

    // Методы для отображения страницы моих заявок
    @GetMapping("/myrequests")
    public String showMyRequestsPage(Model model) {
        Long currentOrganizationId = getCurrentUserOrganizationId();

        // Получаем заявки, связанные с текущей организацией
        List<ZayavkaNaUchastieVTendere> zayavkiNaUchastie =
                zayavkaNaUchastieVTendereRepository.findByIdOrganizatsiya(currentOrganizationId);
        List<ZayavkaNaProvedenieTendera> zayavkiNaProvedenie =
                zayavkaNaProvedenieTenderaRepository.findByIdOrganizatsii(currentOrganizationId);
        // Добавление данных в модель для отображения на странице
        model.addAttribute("zayavkiNaUchastie", zayavkiNaUchastie);
        model.addAttribute("zayavkiNaProvedenie", zayavkiNaProvedenie);
        return "myrequestspage";
    }


    // Метод для отзыва заявки на участие в тендере
    @PostMapping("/revokeRequest/{id}")
    public String revokeRequest(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        // Найдем заявку на участие в тендере по ID
        ZayavkaNaUchastieVTendere zayavka = zayavkaNaUchastieVTendereRepository.findByIdZayavkiNaUchastieVTendere(id).orElse(null);
        if (zayavka != null) {
            // Получаем статус "Отозвана" (предполагаем, что его ID = 4)
            StatusZayavki status = statusZayavkiRepository.findById(4L).orElse(null);
            if (status != null) {
                // Изменяем ID статуса заявки напрямую
                zayavka.setIdStatusZayavki(4L);
                zayavka.setStatusZayavki(status);  // Обновление связанного объекта статуса
                zayavkaNaUchastieVTendereRepository.save(zayavka);
                redirectAttributes.addFlashAttribute("successMessage", "Заявка успешно отозвана.");
            } else {
                redirectAttributes.addFlashAttribute("errorMessage", "Статус заявки не найден.");
            }
        } else {
            redirectAttributes.addFlashAttribute("errorMessage", "Заявка не найдена.");
        }
        return "redirect:/myrequests"; // Перенаправление на страницу заявок
    }

    // Метод для отзыва заявки на проведение тендера
    @PostMapping("/revokeTenderRequest/{id}")
    public String revokeTenderRequest(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        // Найдем заявку на проведение тендера по ID
        ZayavkaNaProvedenieTendera zayavka = zayavkaNaProvedenieTenderaRepository.findById(id).orElse(null);
        if (zayavka != null) {
            // Получаем статус "Отозвана" (предполагаем, что его ID = 4)
            StatusZayavki status = statusZayavkiRepository.findById(4L).orElse(null);
            if (status != null) {
                // Изменяем ID статуса заявки напрямую
                zayavka.setIdStatusZayavki(4L);
                zayavka.setStatusZayavki(status);  // Обновление связанного объекта статуса
                zayavkaNaProvedenieTenderaRepository.save(zayavka);
                redirectAttributes.addFlashAttribute("successMessage", "Заявка на проведение тендера успешно отозвана.");
            } else {
                redirectAttributes.addFlashAttribute("errorMessage", "Статус заявки не найден.");
            }
        } else {
            redirectAttributes.addFlashAttribute("errorMessage", "Заявка не найдена.");
        }
        return "redirect:/myrequests"; // Перенаправление на страницу заявок
    }

    // Метод для получения ID организации текущего пользователя
    private Long getCurrentUserOrganizationId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof CustomUserDetails) {
            CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
            return userDetails.getOrganizationId(); // Предполагаем, что у пользователя есть это поле
        }
        throw new IllegalStateException("Не удалось определить организацию авторизованного пользователя");
    }
}
