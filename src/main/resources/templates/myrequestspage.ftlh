<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/css/menustyle.css">
    <link rel="stylesheet" href="/css/myrequestspagestyle.css">
    <script src="/js/menuToggle.js" defer></script>
    <title>Мои заявки</title>
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
        <h1>Мои заявки</h1>

        <!-- Заявки на участие в тендере -->
        <label>Заявки на участие</label>
        <div class="results-container">
            <#list zayavkiNaUchastie as zayavka>
                <div class="result-item">
                    <span>Цена участника: ${zayavka.tsenaUchastnika} рублей</span>
                    <span>Дата подачи: ${zayavka.dataPodachi}</span>
                    <span>Статус: ${zayavka.idStatusZayavki}</span>
                    <button type="button" class="email-button">Открыть</button>
                    <button type="button" class="email-button">Отозвать</button>
                </div>
            </#list>
        </div>

        <!-- Заявки на проведение тендера -->
        <label>Заявки на проведение</label>
        <div class="results-container">
            <#list zayavkiNaProvedenie as zayavka>
                <div class="result-item">
                    <span>Статус: ${zayavka.dataNachalaTendera} - ${zayavka.dataOkonchaniyaTendera}</span>
                    <span>Цена: ${zayavka.nachalnayaTsena} рублей</span>
                    <button type="button" class="email-button">Открыть</button>
                    <button type="button" class="email-button">Отозвать</button>
                </div>
            </#list>
        </div>

        <button type="button" class="big-buttons">Создать тендер</button>
    </div>
</main>
<footer>
    <p>АлтГТУ 2024</p>
</footer>
</body>
</html>
