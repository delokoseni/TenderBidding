package com.example.TenderBidding.controllers;

import com.example.TenderBidding.models.Organizatsiya;
import com.example.TenderBidding.models.OwnershipType;
import com.example.TenderBidding.models.Okved;
import com.example.TenderBidding.repositories.OrganizatsiyaRepository;
import com.example.TenderBidding.repositories.OwnershipTypeRepository;
import com.example.TenderBidding.repositories.OkvedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import java.util.List;
import java.time.LocalDate;

@Controller
public class RegistrationPageController {

    @Autowired
    private OkvedRepository okvedRepository;

    @Autowired
    private OwnershipTypeRepository ownershipTypeRepository;

    @Autowired
    private OrganizatsiyaRepository organizatsiyaRepository;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @GetMapping("/registration")
    public String showRegistrationForm(Model model) {
        List<OwnershipType> ownershipTypes = ownershipTypeRepository.findAll();
        model.addAttribute("ownershipTypes", ownershipTypes);
        List<Okved> okvedList = okvedRepository.findAll();
        model.addAttribute("okvedList", okvedList);
        return "registrationpage";
    }

    @PostMapping("/registration")
    public String registerUser(
            @RequestParam("email") String email,
            @RequestParam("password") String password,
            @RequestParam("repeatpassword") String repeatpassword,
            @RequestParam("organizationName") String organizationName,
            @RequestParam("inn") String inn,
            @RequestParam("ogrn") String ogrn,
            @RequestParam("establishmentDate") LocalDate establishmentDate,
            Model model) {

        // Проверка на корректность вводимых данных
        if (email.isEmpty() || password.isEmpty() || repeatpassword.isEmpty() ||
                organizationName.isEmpty() || inn.isEmpty() || ogrn.isEmpty()) {
            model.addAttribute("error", "Все поля должны быть заполнены!");
            return "registrationpage"; // Вернуть на страницу регистрации с ошибкой
        }

        if (!password.equals(repeatpassword)) {
            model.addAttribute("error", "Пароли не совпадают!");
            return "registrationpage"; // Вернуть на страницу регистрации с ошибкой
        }

        String hashedPassword = passwordEncoder.encode(password);

        // Создание нового пользователя
        Organizatsiya newOrganization = new Organizatsiya();
        newOrganization.setEmail(email);
        newOrganization.setParol(hashedPassword);
        newOrganization.setImya(organizationName);
        newOrganization.setInn(inn);
        newOrganization.setOgrn_ogrnip(ogrn);

        if(establishmentDate != null)
        {
            newOrganization.setData_osnovaniya(establishmentDate);
        }

        // Установка даты основания
        // LocalDate dataOsnovaniya = LocalDate.now(); // Устанавливаем текущую дату
        //newOrganization.setData_osnovaniya(dataOsnovaniya);

        // Сохранение в базу данных с обработкой ошибок
        try {
            organizatsiyaRepository.save(newOrganization);
            model.addAttribute("success", "Регистрация завершена успешно!");
            return "redirect:/login"; // Переход на страницу успешной регистрации
        } catch (DataIntegrityViolationException e) {
            model.addAttribute("error", "Пользователь с таким email уже существует!");
        } catch (Exception e) {
            model.addAttribute("error", "Не удалось сохранить данные в базе данных: " + e.getMessage());
        }

        return "registrationpage"; // Возврат на страницу с подтверждением или ошибкой
    }
}
