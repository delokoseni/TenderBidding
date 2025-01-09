<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/css/menustyle.css">
    <link rel="stylesheet" href="/css/myrequestspagestyle.css">
    <script src="/js/menuToggle.js" defer></script>
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

        <!-- Заявки на участие в тендере -->
        <label>Заявки на участие</label>
        <div class="results-container">
            <#list zayavkiNaUchastie as zayavka>
                <div class="result-item">
                    <span>Цена участника: ${zayavka.tsenaUchastnika?if_exists!"Не указана"} рублей</span>
                    <span>Дата подачи: ${zayavka.dataPodachi?if_exists!"Не указана"}</span>
                    <span>Статус: ${zayavka.statusZayavki.status_zayavki?if_exists!"Не указан"}</span>
                    <#if zayavka.idZayavkiNaUchastieVTendere??>
                        <a href="/request/${zayavka.idZayavkiNaUchastieVTendere}" class="open-button">Открыть</a>
                    <#else>
                        <span class="error">ID заявки отсутствует</span>
                    </#if>
                    <!-- Форма для отзыва заявки -->
                    <form action="/revokeRequest/${zayavka.idZayavkiNaUchastieVTendere}" method="post">
                        <button type="submit" class="revoke-button" data-id="${zayavka.idZayavkiNaUchastieVTendere}">Отозвать</button>
                    </form>
                </div>
            </#list>
        </div>

        <!-- Заявки на проведение тендера -->
        <label>Заявки на проведение</label>
        <div class="results-container">
            <#list zayavkiNaProvedenie as zayavka>
                <div class="result-item">
                    <span>ID заявки: ${zayavka.idZayavkiNaProvedenieTendera?if_exists!"Не указан"}</span>
                    <span>Период: ${zayavka.dataNachalaTendera?if_exists!"Не указана"} - ${zayavka.dataOkonchaniyaTendera?if_exists!"Не указана"}</span>
                    <span>Цена: ${zayavka.nachalnayaTsena?if_exists!"Не указана"} рублей</span>
                    <span>Статус: ${zayavka.statusZayavki.status_zayavki?if_exists!"Не указан"}</span>
                    <#if zayavka.idZayavkiNaProvedenieTendera??>
                        <!-- Ссылка на страницу заявки -->
                        <a href="/requestTender/${zayavka.idZayavkiNaProvedenieTendera}" class="open-button">Открыть</a>
                    <#else>
                        <span class="error">ID заявки отсутствует</span>
                    </#if>
                    <!-- Кнопка отзыва заявки -->
                    <form action="/revokeTenderRequest/${zayavka.idZayavkiNaProvedenieTendera}" method="post">
                        <button type="submit" class="revoke-button" data-id="${zayavka.idZayavkiNaProvedenieTendera}">Отозвать</button>
                    </form>
                </div>
            </#list>
        </div>

        <!-- Отображение ID заявки после отзыва -->
        <#if zayavkaIdNaUchastie??>
            <p>Заявка на участие ID: ${zayavkaIdNaUchastie}</p>
        </#if>
        <#if zayavkaIdNaProvedenie??>
            <p>Заявка на проведение тендера ID: ${zayavkaIdNaProvedenie}</p>
        </#if>

        <button type="button" class="big-buttons">Создать тендер</button>
    </div>
</main>
<footer>
    <p>АлтГТУ 2024</p>
</footer>
</body>
</html>
