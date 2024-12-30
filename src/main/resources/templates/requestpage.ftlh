<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/menustyle.css">
    <link rel="stylesheet" href="/requestpagestyle.css">
    <script src="/js/menuToggle.js" defer></script>
    <title>Заявка</title>
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
        <h1>Заявка</h1>
        <label class="tender-title">Название тендера: Строительство больницы в микрорайоне "Черёмушки".</label>
        <label class="tender-price">Стартовая цена: 479,500,000 рублей</label>
        <a href="path/to/your/file.pdf" class="btn-download" download>Скачать условия тендера в формате PDF</a>
        <label>ID заявки: 1</label>
        <label>Наименование организации: БельшКорп</label>
        <label>ИНН: 1234567894</label>
        <label>ОГРН/ОГРНИП: 756890123456789</label>
        <label>Цена участника: 450,000,000 рублей</label>
        <a href="path/to/your/file.pdf" class="btn-download" download>Скачать документы участника в формате PDF</a>
    </div>
</main>
<footer>
    <p>АлтГТУ 2024</p>
</footer>
</body>
</html>