<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/css/menustyle.css">
    <link rel="stylesheet" href="/css/mytenderspagestyle.css">
    <script src="/js/menuToggle.js" defer></script>
    <title>Мои тендеры</title>
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
        <h1>Мои тендеры</h1>
        <div class="results-container">
            <div class="result-item">
                <span>Статус: Прием заявок</span>
                <span>Название: Тендер на строительство моста</span>
                <button type="button" class="email-button">Открыть</button>
            </div>
            <div class="result-item">
                <span>Статус: Стадия аукциона</span>
                <span>Название: Тендер на строительство школы</span>
                <button type="button" class="email-button">Открыть</button>
            </div>
        </div>
    </div>
</main>
<footer>
    <p>АлтГТУ 2024</p>
</footer>
</body>
</html>