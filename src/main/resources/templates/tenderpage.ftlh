<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/menustyle.css">
    <link rel="stylesheet" href="/tenderpagestyle.css">
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
        <label class="tender-title">Название тендера: Строительство больницы в микрорайоне "Черёмушки".</label>
        <label class="tender-price">Стартовая цена: 479,500,000 рублей</label>
        <a href="path/to/your/file.pdf" class="btn-download" download>Скачать условия тендера в формате PDF</a>
        <label>Заявки на участие</label>
        <div class="results-container">
            <div class="result-item">
                <span>Статус: на рассмотрении</span>
                <span>Цена участница: 400,000,000 рублей</span>
                <button type="button" class="email-button">Открыть</button>
            </div>
            <div class="result-item">
                <span>Статус: принята</span>
                <span>Цена участника: 350,000,000 рублей</span>
                <button type="button" class="email-button">Открыть</button>
            </div>
        </div>
    </div>
</main>
<footer>
    <p>АлтГТУ 2024</p>
</footer>
<script>
    const menuToggle = document.getElementById('menuToggle');
    const sidebar = document.getElementById('sidebar');

    // Открытие/закрытие меню при нажатии на "гамбургер"
    menuToggle.addEventListener('click', () => {
        sidebar.classList.toggle('active');
    });

    // Закрытие меню при клике вне бокового меню
    document.addEventListener('click', (event) => {
        if (!sidebar.contains(event.target) && !menuToggle.contains(event.target)) {
            sidebar.classList.remove('active');
        }
    });
</script>
</body>
</html>