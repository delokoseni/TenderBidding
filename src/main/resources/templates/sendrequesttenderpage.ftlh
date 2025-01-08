<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/css/menustyle.css">
    <link rel="stylesheet" href="/css/sendrequesttenderpagestyle.css">
    <script src="/js/menuToggle.js" defer></script>
    <title>Участие в тендере</title>
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
        <h1>Участие в тендере</h1>
        <form action="#" method="post">
            <label class="tender-title">Название тендера: ${tender.nomer}</label>
            <label class="tender-price">Стартовая цена: ${tender.nachalnaya_tsena} рублей.</label>

            <a href="path/to/your/file.pdf" class="btn-download" download>Скачать условия в формате PDF</a>
            <label>Ваша цена<span class="required" title="Поле обязательно для заполнения">*</span></label>
            <input type="text" name="startPrice" placeholder="Ваша цена" required>
            <label>Прикрепить требуемый набор документов (*.pdf)<span class="required" title="Поле обязательно для заполнения">*</span></label>
            <input type="file" name="fileUpload" required>
            <button type="submit">Отправить заявку</button>
        </form>
    </div>
</main>
<footer>
    <p>АлтГТУ 2024</p>
</footer>
</body>
</html>