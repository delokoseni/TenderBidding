<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/css/menustyle.css">
    <link rel="stylesheet" href="/css/accountpagestyle.css">
    <script src="/js/menuToggle.js" defer></script>
    <script src="/js/accountEdit.js" defer></script>
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
            Список ОКВЭД
            <button type="button" class="email-button">Изменить</button>
        </label>
        <div class="results-container">
            <div class="result-item">
                <span>Код: 01</span>
                <span>Расшифровка: Растениеводство и животноводство, охота и предоставление соответствующих услуг в этих областях</span>
            </div>
            <div class="result-item">
                <span>Код: 02</span>
                <span>Расшифровка: Лесоводство и лесозаготовки</span>
            </div>
            <div class="result-item">
                <span>Код: 03</span>
                <span>Расшифровка: Рыболовство и рыбоводство</span>
            </div>
            <div class="result-item">
                <span>Код: 04</span>
                <span>Расшифровка: Добыча угля</span>
            </div>
            <div class="result-item">
                <span>Код: 05</span>
                <span>Расшифровка: Добыча полезных ископаемых</span>
            </div>
        </div>
        <label>
            Email:
            <input type="text" name="email" value="${email}" readonly id="emailInput">
            <button type="button" class="email-button" id="editEmailButton" onclick="enableEditing('emailInput', 'editEmailButton', 'saveEmailButton')">Изменить</button>
            <button type="button" class="email-button" id="saveEmailButton" style="display: none;" onclick="saveEmail()">Сохранить</button>
        </label>
        <button class="big-buttons" type="submit">Сменить пароль</button>
        <form action="/logout" method="post" style="display: inline;">
            <button class="big-buttons" type="submit">Выход</button>
        </form>
    </div>
</main>
<footer>
    <p>АлтГТУ 2024</p>
    <input type="hidden" id="currentUserEmail" value="${email}">
</footer>
</body>
</html>