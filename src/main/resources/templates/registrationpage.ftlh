<!DOCTYPE html>
<html lang="ru" xmlns:th="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/registrationpagestyle.css">
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
        <form action="#" method="post">
            <label>Email <span class="required" title="Поле обязательно для заполнения">*</span></label>
            <input type="text" name="email" placeholder="Email" required>

            <label>Пароль <span class="required" title="Поле обязательно для заполнения">*</span></label>
            <input type="password" name="password" placeholder="Пароль" required>

            <label>Повторите пароль <span class="required" title="Поле обязательно для заполнения">*</span></label>
            <input type="password" name="repeatpassword" placeholder="Повторите пароль" required>

            <label>Наименование организации <span class="required" title="Поле обязательно для заполнения">*</span></label>
            <input type="text" name="organizationName" placeholder="Наименование организации" required>

            <label>ИНН <span class="required" title="Поле обязательно для заполнения">*</span></label>
            <input type="text" name="inn" placeholder="ИНН" required>

            <label>ОГРН/ОГРНИП <span class="required" title="Поле обязательно для заполнения">*</span></label>
            <input type="text" name="ogrn" placeholder="ОГРН/ОГРНИП" required>

            <label>Дата основания организации</label>
            <input type="date" name="establishmentDate" required>

            <label>Форма собственности</label>
            <select name="ownershipType" required>
                <option value="" disabled selected>Выберите форму собственности</option>
                <th:block th:each="type : ${ownershipTypes}">
                    <option th:value="${type.id_forma_sobstvennnosti}" th:text="${type.forma}"></option>
                </th:block>
            </select>

            <button type="submit">Зарегистрироваться</button>
        </form>
    </div>
</main>

<footer>
    <p>АлтГТУ 2024</p>
</footer>
</body>
</html>
