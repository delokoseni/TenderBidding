<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/css/menustyle.css">
    <link rel="stylesheet" href="/css/requestpagestyle.css">
    <script src="/js/menuToggle.js" defer></script>
    <title>Заявка на проведение тендера</title>
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
        <h1>Заявка на проведение тендера</h1>
        <label>ID заявки:
            <span>${zayavka.idZayavkiNaProvedenieTendera!"не указано"}</span>
        </label>
        <label class="tender-price">Начальная цена:
            <span>${zayavka.nachalnayaTsena!"не указано"}</span>
        </label>
        <label>ID организации:
            <span>${zayavka.idOrganizatsii!"не указано"}</span>
        </label>
        <label>Дата начала тендера:
            <span>${zayavka.dataNachalaTendera!"не указано"}</span>
        </label>
        <label>Дата окончания тендера:
            <span>${zayavka.dataOkonchaniyaTendera!"не указано"}</span>
        </label>
        <label>Документы:</label>
        <!-- Проверяем, если файл существует -->
        <#if zayavka.usloviyaPdf?has_content>
            Документ доступен
            <form action="/downloadFile" method="POST">
                <input type="hidden" name="idZayavki" value="${zayavka.idZayavkiNaProvedenieTendera}">
                <button type="submit">Скачать PDF</button>
            </form>
        <#else>
            Документ отсутствует
        </#if>

        <!-- Форма для загрузки файла -->
        <form action="/uploadFile" method="POST" enctype="multipart/form-data">
            <label for="usloviyaPdf">Загрузить PDF:</label>
            <input type="file" name="usloviyaPdf" id="usloviyaPdf" accept="application/pdf">
            <input type="hidden" name="idZayavki" value="${zayavka.idZayavkiNaProvedenieTendera}">
            <button type="submit">Загрузить</button>
        </form>
    </div>
</main>
<footer>
    <p>АлтГТУ 2024</p>
</footer>
</body>
</html>
