<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/menustyle.css">
    <link rel="stylesheet" href="/myrequestspagestyle.css">
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
        <label>Заявки на участие</label>
        <div class="results-container">
            <div class="result-item">
                <span>Статус: на рассмотрении</span>
                <span>Название: Тендер на строительство моста</span>
                <span>Ваша цена: 190,000,000 рублей</span>
                <button type="button" class="email-button">Открыть</button>
                <button type="button" class="email-button">Отозвать</button>
            </div>
            <div class="result-item">
                <span>Статус: принята</span>
                <span>Название: Тендер на строительство школы</span>
                <span>Ваша цена: 35,000,000 рублей</span>
                <button type="button" class="email-button">Открыть</button>
                <button type="button" class="email-button">Отозвать</button>
            </div>
        </div>
        <label>Заявки на проведение</label>
        <div class="results-container">
            <div class="result-item">
                <span>Статус: на рассмотрении</span>
                <span>Название: Тендер на строительство аквапарка</span>
                <span>Стартовая цена: 60,000,000 рублей</span>
                <button type="button" class="email-button">Открыть</button>
                <button type="button" class="email-button">Отозвать</button>
            </div>
        </div>
        <button type="button" class="big-buttons">Создать тендер</button>
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