<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/css/menustyle.css">
    <link rel="stylesheet" href="/css/tenderpagestyle.css">
    <script src="/js/menuToggle.js" defer></script>
    <title>Тендер</title>
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
        <h1>Тендер</h1>
        <label class="tender-title">Название тендера:${tender.nomer}.</label>
        <label class="tender-price">Стартовая цена: ${tender.nachalnaya_tsena} рублей</label>
        <label class="tender-price">Дата начала: ${startDate}</label>
        <label class="tender-price">Дата окончания: ${endDate}</label>
        <a href="path/to/your/file.pdf" class="btn-download" download>Скачать условия тендера в формате PDF</a>
        <#if tender.id_organizatora == userId>
            <div>
                <label>Заявки на участие</label>
                <#if zayavki?size == 0>
                <label style="text-align:center;">Нет заявок на участие</label>
                <#else>
                <#list zayavki as zayavka>
                <div class="results-container">
                <div class="result-item">
                    <#if zayavka.idStatusZayavki == 1>
                        <span>Статус: ${status1}</span>
                    </#if>
                    <#if  zayavka.idStatusZayavki == 2>
                        <span>Статус:  ${status2}</span>
                    </#if>
                    <#if  zayavka.idStatusZayavki == 3>
                        <span>Статус:  ${status3}</span>
                    </#if>
                    <span>Цена участника: ${zayavka.tsenaUchastnika} рублей</span>
                    <button type="button" class="email-button">Открыть</button>
                </div>
        </div>
            </#list>
        </div>
        </#if>
        <#else>
            <a href="/sendrequesttender?id=${tenderId}" class="btn-download" >Участвовать</a>
        </#if>
    </div>
</main>
<footer>
    <p>АлтГТУ 2024</p>
</footer>
</body>
</html>