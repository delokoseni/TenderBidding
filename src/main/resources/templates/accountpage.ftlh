<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/css/menustyle.css">
    <link rel="stylesheet" href="/css/accountpagestyle.css">
    <script src="/js/menuToggle.js" defer></script>
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
            <button type="button" class="email-button" id="editButton" onclick="enableEditing()">Изменить</button>
            <button type="button" class="email-button" id="saveButton" style="display: none;" onclick="saveOrganizationName()">Сохранить</button>
        </label>
        <label>
            ИНН: ${inn}
            <button type="button" class="email-button">Изменить</button>
        </label>
        <label>
            ОГРН/ОГРНИП: ${ogrn}
            <button type="button" class="email-button">Изменить</button>
        </label>
        <label>
            Форма собственности:
            <#if ownershipType?exists && ownershipType?trim != "">
            ${ownershipType}
            <#else>
            отсутствует
        </#if>
        <button type="button" class="email-button" disabled>Изменить</button>
        </label>
        <label>
            Дата основания:
            <#if establishmentDate?exists && establishmentDate?trim != "">
            ${establishmentDate}
            <#else>
            отсутствует
        </#if>
        <button type="button" class="add-button" disabled>Изменить</button>
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
            Email: ${email}
            <button type="button" class="email-button">Изменить</button>
        </label>
        <button class="big-buttons" type="submit">Сменить пароль</button>
        <form action="/logout" method="post" style="display: inline;">
            <button class="big-buttons" type="submit">Выход</button>
        </form>
    </div>
</main>
<footer>
    <p>АлтГТУ 2024</p>
</footer>
<script>
    function enableEditing() {
        document.getElementById("organizationInput").removeAttribute("readonly");
        document.getElementById("editButton").style.display = "none"; // Скрыть кнопку "Изменить"
        document.getElementById("saveButton").style.display = "inline-block"; // Показать кнопку "Сохранить"
    }

    function saveOrganizationName() {
        const newName = document.getElementById("organizationInput").value;

        // Отправка данных методом POST
        fetch('/updateOrganizationName', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({ newOrganizationName: newName })
        })
        .then(response => {
            if (response.ok) {
                document.getElementById("organizationInput").setAttribute("readonly", "true");
                document.getElementById("editButton").style.display = "inline-block"; // Показать кнопку "Изменить"
                document.getElementById("saveButton").style.display = "none"; // Скрыть кнопку "Сохранить"
                window.location.reload(); // Перезагрузить страницу для обновления данных
            } else {
                alert('Ошибка при сохранении.'); // Обработка ошибок
            }
        });
    }
</script>
</body>
</html>