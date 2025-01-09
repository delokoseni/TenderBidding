<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/css/loginpagestyle.css">
    <script src="/js/passwordToggle.js"></script>
    <title>Вход</title>
</head>
<body>
<header>
    <div class="header-container">
        <h1>Сервис для проведения тендерных торгов</h1>
        <div class="buttons">
            <a href="/registration" class="btn-register">Регистрация</a>
            <a href="/" class="btn-main">На главную</a>
        </div>
    </div>
</header>

<main>
    <div class="container">
        <h1>Вход</h1>
        <#if error??>
            <div class="error-message" style="color: red;">${error}</div>
        </#if>
    <form action="/login" method="post">
            <label>Email</label>
            <input type="text" name="username" placeholder="Email" style="width: 94%;" required>

            <label>Пароль</label>
            <div class="password-container">
                <input type="password" id="password" name="password" placeholder="Пароль" required>
                <span class="toggle-password" onclick="togglePasswordVisibility('password')" title="Показать/Скрыть пароль">
                    <img id="eye-icon-password" src="/icons/EyeSlashed.svg" class="eye-icon" alt="Глаз">
                </span>
            </div>

            <button type="submit">Войти</button>
        </form>
    </div>
</main>

<footer>
    <p>АлтГТУ 2024</p>
</footer>
</body>
</html>