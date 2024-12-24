<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/menustyle.css">
    <link rel="stylesheet" href="/createtenderpagestyle.css">
    <title>Создание тендера</title>
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
                <li><a href="/logout">Выход</a></li>
            </ul>
        </div>
    </div>
</header>
<main>
    <div class="container">
        <h1>Создание тендера</h1>
        <form action="#" method="post">
            <label>Название тендера<span class="required" title="Поле обязательно для заполнения">*</span></label>
            <input type="text" name="tenderName" placeholder="Название тендера" required>
            <label>Краткое описание<span class="required" title="Поле обязательно для заполнения">*</span></label>
            <textarea class="description" name="description" placeholder="Краткое описание" rows="4" required></textarea>
            <label>Дата начала тендера<span class="required" title="Поле обязательно для заполнения">*</span></label>
            <input type="date" name="startDate" required>
            <label>Дата окончания тендера<span class="required" title="Поле обязательно для заполнения">*</span></label>
            <input type="date" name="endDate" required>
            <label>Прикрепить файл с условиями (*.pdf)<span class="required" title="Поле обязательно для заполнения">*</span></label>
            <input type="file" name="fileUpload" required>
            <label>Начальная цена<span class="required" title="Поле обязательно для заполнения">*</span></label>
            <input type="text" name="startPrice" placeholder="Начальная цена" required>
            <button type="submit">Отправить заявку</button>
        </form>
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