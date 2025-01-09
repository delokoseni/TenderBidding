<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/css/menustyle.css">
    <link rel="stylesheet" href="/css/requestpagestyle.css">
    <script src="/js/menuToggle.js" defer></script>
    <title>Заявка на участие в тендере</title>
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
        <h1>Заявка на участие в тендере</h1>
        <label class="tender-title">Название тендера:
            <span>${zayavka.idTendera!"не указано"}</span>
        </label>
        <label class="tender-price">Цена участника:
            <span>${zayavka.tsenaUchastnika!"не указано"}</span>
        </label>
        <label>ID заявки:
            <span>${zayavka.idZayavkiNaUchastieVTendere!"не указано"}</span>
        </label>
        <label>ID организации:
            <span>${zayavka.idOrganizatsiya!"не указано"}</span>
        </label>
        <label>Дата подачи:
            <span>${zayavka.dataPodachi!"не указано"}</span>
        </label>
        <label>Дата изменения статуса:
            <span>${zayavka.dataIzmeneniyaStatusa!"не указано"}</span>
        </label>
        <label>Документы:
            <span>${zayavka.dokumenty!"отсутствуют"}</span>
        </label>
    </div>
</main>
<footer>
    <p>АлтГТУ 2024</p>
</footer>
</body>
</html>
