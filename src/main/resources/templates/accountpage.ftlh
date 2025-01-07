<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/css/menustyle.css">
    <link rel="stylesheet" href="/css/accountpagestyle.css">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.13/css/select2.min.css" rel="stylesheet" />
    <script src="/js/menuToggle.js" defer></script>
    <script src="/js/accountEdit.js" defer></script>
    <script src="/js/passwordToggle.js" defer></script>
    <title>Аккаунт</title>
</head>
<body>
<header>
    <div class="header-container">
        <h1>Сервис для проведения тендерных торгов</h1>
        <div class="menu-toggle" id="menuToggle">&#9776;</div>
        <div class="sidebar" id="sidebar">
            <ul class="sidebar-menu">
                <li><a href="/account">Аккаунт</a></li>
                <li><a href="/searchtender">Поиск тендера</a></li>
                <li><a href="/myrequests">Мои заявки</a></li>
                <li><a href="/mytenders">Мои тендеры</a></li>
                <li><a href="/logout">Выход</a></li>
            </ul>
        </div>
    </div>
</header>
<main>
    <div class="container">
        <h1>Аккаунт</h1>
        <label>
            Наименование организации:
            <input type="text" name="organizationName" value="${organizationName}" readonly id="organizationInput">
            <button type="button" class="email-button" id="editButton" onclick="enableEditing('organizationInput', 'editButton', 'saveButton')">Изменить</button>
            <button type="button" class="email-button" id="saveButton" style="display: none;" onclick="saveOrganizationName()">Сохранить</button>
        </label>
        <label>
            ИНН:
            <input type="text" name="inn" value="${inn}" readonly id="innInput">
            <button type="button" class="email-button" id="editInnButton" onclick="enableEditing('innInput', 'editInnButton', 'saveInnButton')">Изменить</button>
            <button type="button" class="email-button" id="saveInnButton" style="display: none;" onclick="saveInn()">Сохранить</button>
        </label>
        <label>
            ОГРН/ОГРНИП:
            <input type="text" name="ogrn" value="${ogrn}" readonly id="ogrnInput">
            <button type="button" class="email-button" id="editOgrnButton" onclick="enableEditing('ogrnInput', 'editOgrnButton', 'saveOgrnButton')">Изменить</button>
            <button type="button" class="email-button" id="saveOgrnButton" style="display: none;" onclick="saveOgrn()">Сохранить</button>
        </label>
        <label>
            Форма собственности:
            <select name="ownershipType" id="ownershipTypeInput" disabled>
                <option value="" disabled <#if ownershipType == "отсутствует">selected</#if>>Выберите форму собственности</option>
                <#list ownershipTypes as type>
                    <option value="${type.id_forma_sobstvennnosti}" <#if type.forma == ownershipType>selected</#if>>${type.forma}</option>
                </#list>
            </select>
            <button type="button" id="editOwnershipTypeButton" onclick="enableEditing('ownershipTypeInput', 'editOwnershipTypeButton', 'saveOwnershipTypeButton')" class="edit-button">Изменить</button>
            <button type="button" id="saveOwnershipTypeButton" onclick="saveOwnershipType()" style="display: none;">Сохранить</button>
        </label>
        <label>
            Дата основания:
            <input type="date" id="establishmentDateInput" value="${establishmentDate!}" readonly />
            <button type="button" id="editEstablishmentDateButton" onclick="enableEditing('establishmentDateInput', 'editEstablishmentDateButton', 'saveEstablishmentDateButton')" class="edit-button">Изменить</button>
            <button type="button" id="saveEstablishmentDateButton" onclick="saveEstablishmentDate()" style="display:none;">Сохранить</button>
        </label>
    <label>
        Код и расшифровка ОКВЭД:
        <select name="okved" class="select2" id="okvedInput" disabled>
            <option value="" disabled <#if selectedOkvedKod == "отсутствует">selected</#if>>Выберите основной ОКВЭД</option>
            <#list okvedList as okved>
            <option value="${okved.kod}" <#if selectedOkvedKod == okved.kod>selected</#if>>${okved.kod} - ${okved.rasshifrovka}</option>
            </#list>
        </select>
        <button type="button" id="editOkvedButton" onclick="enableEditing('okvedInput', 'editOkvedButton', 'saveOkvedButton')" class="edit-button">Изменить</button>
        <button type="button" id="saveOkvedButton" onclick="saveOkved()" style="display: none;">Сохранить</button>
    </label>
    <label>
        Email:
            <input type="text" name="email" value="${email}" readonly id="emailInput">
            <button type="button" class="email-button" id="editEmailButton" onclick="enableEditing('emailInput', 'editEmailButton', 'saveEmailButton')">Изменить</button>
            <button type="button" class="email-button" id="saveEmailButton" style="display: none;" onclick="saveEmail()">Сохранить</button>
    </label>
<!-- Кнопка для смены пароля -->
<button class="big-buttons" onclick="openChangePasswordModal()">Сменить пароль</button>

<!-- Модальное окно для смены пароля -->
<div id="changePasswordModal" style="display:none; position:fixed; top:0; left:0; width:100%; height:100%; background-color:rgba(0,0,0,0.5);">
    <div style="background-color:white; margin:auto; padding:20px; width:300px; position:relative; top:50%; transform:translateY(-50%);">
        <h2>Сменить пароль</h2>
        <form id="changePasswordForm" onsubmit="return changePassword(event)">
            <label for="oldPassword">Старый пароль:</label>
            <div class="password-container">
                <input type="password" id="oldPassword" required placeholder="Старый пароль">
                <span class="toggle-password" onclick="togglePasswordVisibility('oldPassword')" title="Показать/Скрыть пароль">
        <img id="eye-icon-oldPassword" src="/icons/EyeSlashed.svg" class="eye-icon" alt="Глаз">
    </span>
            </div><br><br>

            <label for="newPassword">Новый пароль:</label>
            <div class="password-container">
                <input type="password" id="newPassword" required placeholder="Новый пароль">
                <span class="toggle-password" onclick="togglePasswordVisibility('newPassword')" title="Показать/Скрыть пароль">
        <img id="eye-icon-newPassword" src="/icons/EyeSlashed.svg" class="eye-icon" alt="Глаз">
    </span>
            </div><br><br>

            <label for="confirmPassword">Повторите новый пароль:</label>
            <div class="password-container">
                <input type="password" id="confirmPassword" required placeholder="Повторите новый пароль">
                <span class="toggle-password" onclick="togglePasswordVisibility('confirmPassword')" title="Показать/Скрыть пароль">
        <img id="eye-icon-confirmPassword" src="/icons/EyeSlashed.svg" class="eye-icon" alt="Глаз">
    </span>
            </div><br><br>

            <button type="submit">Сменить</button>
        </form>
    </div>
</div>

<form action="/logout" method="post" style="display: inline;">
            <button class="big-buttons" type="submit">Выход</button>
        </form>
    </div>
</main>
<footer>
    <p>АлтГТУ 2024</p>
    <input type="hidden" id="currentUserEmail" value="${email}">
</footer>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.13/js/select2.min.js"></script>
<script>
    $(document).ready(function() {
        $('.select2').select2();
    });
</script>
</body>
</html>