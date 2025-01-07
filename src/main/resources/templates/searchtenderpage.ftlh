<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/css/menustyle.css">
    <link rel="stylesheet" href="/css/searchtenderpagestyle.css">
    <script src="/js/menuToggle.js" defer></script>
    <title>Поиск тендеров</title>
</head>
<body>
<header>
    <div class="header-container">
        <h1>Сервис для проведения тендерных торгов</h1>
        <div class="menu-toggle" id="menuToggle">☰</div>
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
        <h1>Поиск тендеров</h1>
<#--        <search-container class="search-container">-->
            <form action="/search" method="get">
                <input type="text" name="searchTerm" placeholder="Поиск...">
                <button type="submit" class="participate-button">Поиск</button>
            </form>
<#--        </search-container>-->
        <table>
            <thead>
            <tr>
                <th>Название</th>
                <th>Статус</th>
                <th>Дата начала</th>
                <th>Дата окончания</th>
                <th>Стартовая цена</th>
                <th>Организатор</th>
                <th>Действия</th>
            </tr>
            </thead>
            <tbody>
            <#if tenders?size == 0>
                <tr>
                    <td colspan="7" style="text-align:center;">Нет доступных тендеров</td>
                </tr>
            <#else>
                <#list tenders as tender>
                    <tr>
                        <td>${tender.nomer}</td>
                        <#if tender.id_statusa_tendera == 1>
                            <td>${status1}</td>
                        </#if>
                        <#if tender.id_statusa_tendera == 2>
                            <td>${status2}</td>
                        </#if>
                        <#if tender.id_statusa_tendera == 3>
                            <td>${status3}</td>
                        </#if>
                        <#if tender.id_statusa_tendera == 4>
                            <td>${status4}</td>
                        </#if>
                        <td>${tender.data_nachala}</td>
                        <td>${tender.data_okonchaniya}</td>
                        <td>${tender.nachalnaya_tsena}</td>
                        <td>
                            <#assign organization = "">
                            <#list organizations as org>
                                <#if org.id_organizatsii == tender.id_organizatora>
                                    <#assign organization = org>
                                </#if>
                            </#list>
                            <#if organization.equals(null)>
                                Неизвестный организатор
                            <#else>
                                ${organization.imya}
                            </#if>
                        </td>
                        <td>
                            <button class="button">Участвовать</button>
                        </td>
                    </tr>
                </#list>
            </#if>
            </tbody>
        </table>
    </div>
</main>
<footer>
    <p>АлтГТУ 2024</p>
</footer>
</body>
</html>