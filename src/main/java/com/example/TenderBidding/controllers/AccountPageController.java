package com.example.TenderBidding.controllers;

import com.example.TenderBidding.models.Organizatsiya;
import com.example.TenderBidding.models.OwnershipType;
import com.example.TenderBidding.repositories.OrganizatsiyaRepository;
import com.example.TenderBidding.repositories.OwnershipTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Map;
import java.util.Optional;

@Controller
public class AccountPageController {

    @Autowired
    private OrganizatsiyaRepository organizatsiyaRepository;
    @Autowired
    private OwnershipTypeRepository ownershipTypeRepository;

    @GetMapping("/account")
    public String showAccountPage(Model model) {
        // Получаем текущего аутентифицированного пользователя
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserEmail = authentication.getName();

        // Получаем информацию о пользователе из базы данных
        Organizatsiya organizatsiya = organizatsiyaRepository.findByEmail(currentUserEmail)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Добавляем данные пользователя в модель
        model.addAttribute("organizationName", organizatsiya.getImya());
        model.addAttribute("inn", organizatsiya.getInn());
        model.addAttribute("ogrn", organizatsiya.getOgrn_ogrnip());
        if (organizatsiya.getId_forma_sobstvennosti() != null) {
            Optional<OwnershipType> ownershipTypeOpt = ownershipTypeRepository.findById_forma_sobstvennnosti(organizatsiya.getId_forma_sobstvennosti());
            model.addAttribute("ownershipType", ownershipTypeOpt.map(OwnershipType::getForma).orElse("отсутствует"));
        } else {
            model.addAttribute("ownershipType", "отсутствует");
        }
        model.addAttribute("establishmentDate", organizatsiya.getData_osnovaniya());
        model.addAttribute("email", organizatsiya.getEmail());

        // Возврат имени шаблона
        return "accountpage";
    }

    @PostMapping("/updateOrganizationName")
    public ResponseEntity<Void> updateOrganizationName(@RequestBody Map<String, String> request) {
        String newOrganizationName = request.get("newOrganizationName");

        // Получаем текущего аутентифицированного пользователя
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserEmail = authentication.getName();

        // Получаем информацию о пользователе из базы данных
        Organizatsiya organizatsiya = organizatsiyaRepository.findByEmail(currentUserEmail)
                .orElseThrow(() -> new RuntimeException("User не найден"));

        // Обновляем наименование организации
        organizatsiya.setImya(newOrganizationName);
        organizatsiyaRepository.save(organizatsiya); // Сохраняем изменения

        // Возвращаем статус 204 No Content для успешного выполнения
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/updateInn")
    public ResponseEntity<Void> updateInn(@RequestBody Map<String, String> request) {
        String newInn = request.get("newInn");
        String currentUserEmail = request.get("email");

        Organizatsiya organizatsiya = organizatsiyaRepository.findByEmail(currentUserEmail)
                .orElseThrow(() -> new RuntimeException("User не найден"));

        organizatsiya.setInn(newInn);
        organizatsiyaRepository.save(organizatsiya);

        return ResponseEntity.noContent().build();
    }

    @PostMapping("/updateOgrn")
    public ResponseEntity<Void> updateOgrn(@RequestBody Map<String, String> request) {
        String newOgrn = request.get("newOgrn");
        String currentUserEmail = request.get("email");

        Organizatsiya organizatsiya = organizatsiyaRepository.findByEmail(currentUserEmail)
                .orElseThrow(() -> new RuntimeException("User не найден"));

        organizatsiya.setOgrn_ogrnip(newOgrn);
        organizatsiyaRepository.save(organizatsiya);

        return ResponseEntity.noContent().build();
    }

    @PostMapping("/updateOwnershipType")
    public ResponseEntity<Void> updateOwnershipType(@RequestBody Map<String, String> request) {
        String newOwnershipType = request.get("newOwnershipType");
        String currentUserEmail = request.get("email");

        Organizatsiya organizatsiya = organizatsiyaRepository.findByEmail(currentUserEmail)
                .orElseThrow(() -> new RuntimeException("User не найден"));

        // Предполагая, что у вас есть метод для обновления типа собственности
        //organizatsiya.setId_forma_sobstvennosti(/* Ваш метод для получения ID типа собственности по имени */);
        organizatsiyaRepository.save(organizatsiya);

        return ResponseEntity.noContent().build();
    }

    @PostMapping("/updateEstablishmentDate")
    public ResponseEntity<Void> updateEstablishmentDate(@RequestBody Map<String, String> request) {
        String newEstablishmentDate = request.get("newEstablishmentDate");
        String currentUserEmail = request.get("email");

        Organizatsiya organizatsiya = organizatsiyaRepository.findByEmail(currentUserEmail)
                .orElseThrow(() -> new RuntimeException("User не найден"));

        // Преобразование строки в LocalDate
        try {
            LocalDate establishmentDate = LocalDate.parse(newEstablishmentDate, DateTimeFormatter.ISO_LOCAL_DATE);
            organizatsiya.setData_osnovaniya(establishmentDate);
        } catch (DateTimeParseException e) {
            throw new RuntimeException("Ошибка при парсинге даты основания: " + newEstablishmentDate);
        }

        organizatsiyaRepository.save(organizatsiya);

        return ResponseEntity.noContent().build();
    }

}
