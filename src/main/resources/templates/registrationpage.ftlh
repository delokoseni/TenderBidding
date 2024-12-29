<!DOCTYPE html>
<html lang="ru" xmlns:th="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/registrationpagestyle.css">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.13/css/select2.min.css" rel="stylesheet" />
    <script src="/js/passwordToggle.js"></script>
    <title>Регистрация</title>
</head>
<body>
<header>
    <div class="header-container">
        <h1>Сервис для проведения тендерных торгов</h1>
        <div class="buttons">
            <a href="/login" class="btn-login">Вход</a>
            <a href="/" class="btn-main">На главную</a>
        </div>
    </div>
</header>

<main>
    <div class="container">
        <h1>Регистрация</h1>
        <#if error??>
            <div class="error-message">
            <p>${error}</p>
            </div>
        </#if>
        <form action="/registration" method="post">
            <label>Email <span class="required" title="Поле обязательно для заполнения">*</span></label>
            <input type="text" name="email" placeholder="Email" required>

            <label>Пароль <span class="required" title="Поле обязательно для заполнения">*</span></label>
            <div class="password-container">
                <input type="password" id="password" name="password" placeholder="Пароль" required>
                <span class="toggle-password" onclick="togglePasswordVisibility('password')" title="Показать/Скрыть пароль">
                    <img id="eye-icon-password" src="/icons/EyeSlashed.svg" class="eye-icon" alt="Глаз">
                </span>
            </div>

            <label>Повторите пароль <span class="required" title="Поле обязательно для заполнения">*</span></label>
            <div class="password-container">
                <input type="password" id="repeatpassword" name="repeatpassword" placeholder="Повторите пароль" required>
                <span class="toggle-password" onclick="togglePasswordVisibility('repeatpassword')" title="Показать/Скрыть пароль">
                    <img id="eye-icon-repeatpassword" src="/icons/EyeSlashed.svg" class="eye-icon" alt="Глаз">
                </span>
            </div>

            <label>Наименование организации <span class="required" title="Поле обязательно для заполнения">*</span></label>
            <input type="text" name="organizationName" placeholder="Наименование организации" required>

            <label>ИНН <span class="required" title="Поле обязательно для заполнения">*</span></label>
            <input type="text" name="inn" placeholder="ИНН" required>

            <label>ОГРН/ОГРНИП <span class="required" title="Поле обязательно для заполнения">*</span></label>
            <input type="text" name="ogrn" placeholder="ОГРН/ОГРНИП" required>

            <label>Дата основания организации</label>
            <input type="date" name="establishmentDate">

            <label>Форма собственности</label>
            <select name="ownershipType">
                <option value="" disabled selected>Выберите форму собственности</option>
                <#list ownershipTypes as type>
                <option value="${type.id_forma_sobstvennnosti}">${type.forma}</option>
            </#list>
            </select>

            <label>Код и расшифровка ОКВЭД</label>
            <select name="okved" class="select2">
                <option value="" disabled selected>Выберите основной ОКВЭД</option>
                <#list okvedList as okved>
                <option value="${okved.kod}">${okved.kod} - ${okved.rasshifrovka}</option>
            </#list>
            </select>
            <button type="submit">Зарегистрироваться</button>
        </form>
    </div>
</main>

<footer>
    <p>АлтГТУ 2024</p>
</footer>

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.13/js/select2.min.js"></script>
<script>
    $(document).ready(function() {
        $('.select2').select2();
    });
</script>
</body>
</html>
