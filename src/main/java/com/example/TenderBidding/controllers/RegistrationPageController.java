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
import java.util.regex.Pattern;

import java.util.List;
import java.time.LocalDate;
import java.util.Optional;

@Controller
public class RegistrationPageController {

    private static final int MAX_EMAIL_LENGTH = 255;

    // Регулярное выражение для проверки формата электронной почты
    private static final Pattern EMAIL_REGEX = Pattern.compile("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z]{2,}$",
            Pattern.CASE_INSENSITIVE);

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
            @RequestParam(value = "establishmentDate", required = false) LocalDate establishmentDate,
            @RequestParam(value = "ownershipType", required = false) Long ownershipTypeId,
            Model model) {

        // Проверка существования email в базе данных
        if (organizatsiyaRepository.findByEmail(email).isPresent()) {
            model.addAttribute("error", "Пользователь с таким email уже существует!");
            loadFormData(model); // Загружаем данные для формы
            return "registrationpage"; // Вернуть на страницу регистрации с ошибкой
        }

        // Проверка длины и формата email
        if (email.length() > MAX_EMAIL_LENGTH) {
            model.addAttribute("error", "Email не должен превышать " + MAX_EMAIL_LENGTH + " символов!");
            loadFormData(model); // Загружаем данные для формы
            return "registrationpage"; // Вернуть на страницу регистрации с ошибкой
        }

        if (!EMAIL_REGEX.matcher(email).matches()) {
            model.addAttribute("error", "Введите корректный адрес электронной почты!");
            loadFormData(model); // Загружаем данные для формы
            return "registrationpage"; // Вернуть на страницу регистрации с ошибкой
        }

        if (!password.equals(repeatpassword)) {
            model.addAttribute("error", "Пароли не совпадают!");
            loadFormData(model); // Загружаем данные для формы
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

        newOrganization.setId_forma_sobstvennosti(ownershipTypeId);
        newOrganization.setData_osnovaniya(establishmentDate);

        // Сохранение в базу данных с обработкой ошибок
        try {
            organizatsiyaRepository.save(newOrganization);
            model.addAttribute("success", "Регистрация завершена успешно!");
            return "redirect:/login"; // Переход на страницу успешной регистрации
        } catch (Exception e) {
            model.addAttribute("error", "Не удалось сохранить данные в базе данных: " + e.getMessage());
            loadFormData(model); // Загружаем данные для формы
        }

        return "registrationpage"; // Возврат на страницу с подтверждением или ошибкой
    }

    // Метод для загрузки данных формы
    private void loadFormData(Model model) {
        List<OwnershipType> ownershipTypes = ownershipTypeRepository.findAll();
        model.addAttribute("ownershipTypes", ownershipTypes);
        List<Okved> okvedList = okvedRepository.findAll();
        model.addAttribute("okvedList", okvedList);
    }

}
