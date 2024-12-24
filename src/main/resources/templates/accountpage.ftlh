<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/menustyle.css">
    <link rel="stylesheet" href="/accountpagestyle.css">
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
            Наименование организации: БельшКорп
            <button type="button" class="email-button">Изменить</button>
        </label>
        <label>
            ИНН: 1234567894
            <button type="button" class="email-button">Изменить</button>
        </label>
        <label>
            ОГРН/ОГРНИП: 756890123456789
            <button type="button" class="email-button">Изменить</button>
        </label>
        <label>
            Форма собственности: ООО
            <button type="button" class="email-button">Изменить</button>
        </label>
        <label>
            Дата основания: отсутствует
            <button type="button" class="add-button">Изменить</button>
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
            Email: art*****@****.com
            <button type="button" class="email-button">Изменить</button>
        </label>
        <button class="big-buttons" type="submit">Сменить пароль</button>
        <button class="big-buttons" type="submit">Выход</button>
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