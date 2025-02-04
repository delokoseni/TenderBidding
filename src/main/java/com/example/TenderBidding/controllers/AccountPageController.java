package com.example.TenderBidding.controllers;

import com.example.TenderBidding.models.*;
import com.example.TenderBidding.repositories.OkvedRepository;
import com.example.TenderBidding.repositories.OrganizatsiyaOkvedRepository;
import com.example.TenderBidding.repositories.OrganizatsiyaRepository;
import com.example.TenderBidding.repositories.OwnershipTypeRepository;
import com.example.TenderBidding.validators.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
public class AccountPageController {

    @Autowired
    private OrganizatsiyaRepository organizatsiyaRepository;
    @Autowired
    private OwnershipTypeRepository ownershipTypeRepository;
    @Autowired
    private OkvedRepository okvedRepository;

    @Autowired
    private OrganizatsiyaOkvedRepository organizatsiyaOkvedRepository;

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

        // Получаем форму собственности
        if (organizatsiya.getId_forma_sobstvennosti() != null) {
            OwnershipType ownershipType = ownershipTypeRepository.findById_forma_sobstvennnosti(organizatsiya.getId_forma_sobstvennosti())
                    .orElseThrow(() -> new RuntimeException("Ownership type not found"));
            model.addAttribute("ownershipType", ownershipType.getForma());
        } else {
            model.addAttribute("ownershipType", "отсутствует");
        }

        model.addAttribute("establishmentDate", organizatsiya.getData_osnovaniya() != null ? organizatsiya.getData_osnovaniya() : "");
        model.addAttribute("email", organizatsiya.getEmail());
        List<OwnershipType> ownershipTypes = ownershipTypeRepository.findAll();
        model.addAttribute("ownershipTypes", ownershipTypes);

        // Получаем основной ОКВЭД
        List<OrganizatsiyaOkved> organizatsiyaOkveds = organizatsiyaOkvedRepository.findByOrganizatsiya(organizatsiya);
        String selectedOkvedKod = "отсутствует"; // По умолчанию

        if (!organizatsiyaOkveds.isEmpty()) {
            // Извлекаем код основного ОКВЭД
            selectedOkvedKod = organizatsiyaOkveds.get(0).getOkved().getKod();
        }

        model.addAttribute("selectedOkvedKod", selectedOkvedKod);

        // Получаем список всех доступных ОКВЭДов
        List<Okved> okvedList = okvedRepository.findAll();
        model.addAttribute("okvedList", okvedList);

        return "accountpage";
    }

    @PostMapping("/updateOrganizationName")
    public ResponseEntity<String> updateOrganizationName(@RequestBody Map<String, String> request) {
        String newOrganizationName = request.get("newOrganizationName");

        // Проверка на допустимую длину
        if (!OrganizationNameValidator.isValidLength(newOrganizationName)) {
            return ResponseEntity.badRequest().body("Наименование слишком длинное. Максимальная длина: " + OrganizationNameValidator.getMaxNameLength());
        }

        // Проверка на корректный формат
        if (!OrganizationNameValidator.isValidFormat(newOrganizationName)) {
            return ResponseEntity.badRequest().body("Наименование содержит недопустимые символы. Разрешены только кириллица, цифры, и некоторые спецсимволы.");
        }

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
    public ResponseEntity<String> updateInn(@RequestBody Map<String, String> request) {
        String newInn = request.get("newInn");
        String currentUserEmail = request.get("email");

        // Проверка валидности ИНН
        if (!InnValidator.isValidInn(newInn)) {
            return ResponseEntity.badRequest().body("ИНН должен содержать от " + InnValidator.getMinInnLength() +
                    " до " + InnValidator.getMaxInnLength() + " цифр и состоял только из цифр.");
        }

        Organizatsiya organizatsiya = organizatsiyaRepository.findByEmail(currentUserEmail)
                .orElseThrow(() -> new RuntimeException("User не найден"));

        organizatsiya.setInn(newInn);
        organizatsiyaRepository.save(organizatsiya);

        return ResponseEntity.noContent().build();
    }

    @PostMapping("/updateOgrn")
    public ResponseEntity<String> updateOgrn(@RequestBody Map<String, String> request) {
        String newOgrn = request.get("newOgrn");
        String currentUserEmail = request.get("email");

        // Проверка валидности ОГРН/ОГРНИП
        if (!OgrnOgrnipValidator.isValidOgrnOgrnip(newOgrn)) {
            return ResponseEntity.badRequest().body("ОГРН/ОГРНИП должен содержать от " +
                    OgrnOgrnipValidator.getMinOgrnOgrnipLength() + " до " +
                    OgrnOgrnipValidator.getMaxOgrnOgrnipLength() + " цифр и состоять только из цифр.");
        }

        Organizatsiya organizatsiya = organizatsiyaRepository.findByEmail(currentUserEmail)
                .orElseThrow(() -> new RuntimeException("User не найден"));

        organizatsiya.setOgrn_ogrnip(newOgrn);
        organizatsiyaRepository.save(organizatsiya);

        return ResponseEntity.noContent().build();
    }

    @PostMapping("/updateOwnershipType")
    public ResponseEntity<String> updateOwnershipType(@RequestBody Map<String, String> request) {
        String newOwnershipTypeId = request.get("newOwnershipType");
        String currentUserEmail = request.get("email");

        Organizatsiya organizatsiya = organizatsiyaRepository.findByEmail(currentUserEmail)
                .orElseThrow(() -> new RuntimeException("User не найден"));

        if (newOwnershipTypeId == null || newOwnershipTypeId.isEmpty()) {
            return ResponseEntity.badRequest().body("Форма собственности не выбрана."); // Обработка ошибки "пустой" выбор
        }

        OwnershipType ownershipType = ownershipTypeRepository.findById(Long.parseLong(newOwnershipTypeId))
                .orElseThrow(() -> new RuntimeException("Форма собственности не найдена"));

        organizatsiya.setId_forma_sobstvennosti(ownershipType.getId_forma_sobstvennnosti());
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

    @PostMapping("/updateEmail")
    public ResponseEntity<String> updateEmail(@RequestBody Map<String, String> request, Authentication authentication) {
        String newEmail = request.get("newEmail");

        // Проверка валидности email
        if (!EmailValidator.isValidLength(newEmail) || !EmailValidator.isValidFormat(newEmail)) {
            return ResponseEntity.badRequest().body("Неверный формат или длина email. Должен быть не более " +
                    EmailValidator.getMaxEmailLength() + " символов и соответствовать стандартному формату email.");
        }

        // Получаем текущего пользователя
        String currentUserEmail = authentication.getName();

        Organizatsiya organizatsiya = organizatsiyaRepository.findByEmail(currentUserEmail)
                .orElseThrow(() -> new RuntimeException("User не найден"));

        if (organizatsiyaRepository.findByEmail(newEmail).isPresent()) {
            return ResponseEntity.badRequest().body("Пользователь с таким email уже существует!"); // Обработка существующего email
        }

        organizatsiya.setEmail(newEmail); // Устанавливаем новый email
        organizatsiyaRepository.save(organizatsiya);

        // Обновляем информацию в сессии
        UsernamePasswordAuthenticationToken newAuth =
                new UsernamePasswordAuthenticationToken(newEmail, null, authentication.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(newAuth);

        return ResponseEntity.noContent().build();
    }

    @PostMapping("/updateOkved")
    public ResponseEntity<String> updateOkved(@RequestBody Map<String, String> request) {
        String newOkvedId = request.get("newOkved");
        String currentUserEmail = request.get("email");

        Organizatsiya organizatsiya = organizatsiyaRepository.findByEmail(currentUserEmail)
                .orElseThrow(() -> new RuntimeException("User не найден"));

        if (newOkvedId == null || newOkvedId.isEmpty()) {
            return ResponseEntity.badRequest().body("ОКВЭД не выбран."); // Обработка ошибки "пустой" выбор
        }

        Okved okved = okvedRepository.findById(Long.parseLong(newOkvedId))
                .orElseThrow(() -> new RuntimeException("ОКВЭД не найден"));

        // Проверяем, есть ли уже существующий ОКВЭД для данной организации
        List<OrganizatsiyaOkved> organizatsiyaOkveds = organizatsiyaOkvedRepository.findByOrganizatsiya(organizatsiya);

        // Если запись существует, удаляем её
        if (!organizatsiyaOkveds.isEmpty()) {
            organizatsiyaOkvedRepository.delete(organizatsiyaOkveds.get(0)); // Удаляем только первую запись, если их несколько
        }

        // Создаём новую связь с ОКВЭДом
        OrganizatsiyaOkvedId newOkvedIdOOI = new OrganizatsiyaOkvedId(okved.getId_okved(), organizatsiya.getId_organizatsii());
        OrganizatsiyaOkved organizatsiyaOkved = new OrganizatsiyaOkved();
        organizatsiyaOkved.setId(newOkvedIdOOI);
        organizatsiyaOkved.setOkved(okved);
        organizatsiyaOkved.setOrganizatsiya(organizatsiya);

        // Сохраняем новую запись
        organizatsiyaOkvedRepository.save(organizatsiyaOkved);

        return ResponseEntity.noContent().build();
    }

    @PostMapping("/changePassword")
    public ResponseEntity<String> changePassword(@RequestBody Map<String, String> request, Authentication authentication) {
        String oldPassword = request.get("oldPassword");
        String newPassword = request.get("newPassword");

        // Получаем текущего аутентифицированного пользователя
        String currentUserEmail = authentication.getName();
        Organizatsiya organizatsiya = organizatsiyaRepository.findByEmail(currentUserEmail)
                .orElseThrow(() -> new RuntimeException("User not found"));

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        // Сравниваем введённый старый пароль с хранимым в БД
        if (!passwordEncoder.matches(oldPassword, organizatsiya.getParol())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Неверный старый пароль.");
        }

        // Проверка нового пароля на валидность
        String validationError = PasswordValidator.validatePassword(newPassword);
        if (validationError != null) {
            return ResponseEntity.badRequest().body(validationError);
        }

        // Если всё в порядке, шифруем новый пароль и сохраняем в БД
        String encryptedNewPassword = passwordEncoder.encode(newPassword);
        organizatsiya.setParol(encryptedNewPassword);
        organizatsiyaRepository.save(organizatsiya);

        return ResponseEntity.ok("Пароль успешно изменен.");
    }
}
