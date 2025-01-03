<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/css/menustyle.css">
    <link rel="stylesheet" href="/css/searchtenderpagestyle.css">
    <script src="/js/menuToggle.js" defer></script>
    <title>Поиск тендеров</title>
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
        <h1>Поиск тендеров</h1>
        <input type="text" class="search-input" placeholder="Поиск...">
        <div class="results-container">
            <div class="result-item">
                <span>Название: Строительство больницы в микрорайоне "Черёмушки"</span>
                <span>Стартовая цена: 479,500,000 рублей</span>
                <button class="participate-button">Участвовать</button>
            </div>
            <div class="result-item">
                <span>Название: Тендер на строительство дороги</span>
                <span>Стартовая цена: 100,000,000 рублей</span>
                <button class="participate-button">Участвовать</button>
            </div>
            <div class="result-item">
                <span>Название: Тендер на реконструкцию моста</span>
                <span>Стартовая цена: 150,000,000 рублей</span>
                <button class="participate-button">Участвовать</button>
            </div>
            <div class="result-item">
                <span>Название: Тендер на строительство школы</span>
                <span>Стартовая цена: 200,000,000 рублей</span>
                <button class="participate-button">Участвовать</button>
            </div>
            <div class="result-item">
                <span>Название: Тендер на строительство моста</span>
                <span>Стартовая цена: 260,000,000 рублей</span>
                <button class="participate-button">Участвовать</button>
            </div>
        </div>
    </div>
</main>
<footer>
    <p>АлтГТУ 2024</p>
</footer>
</body>
</html>