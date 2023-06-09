<!DOCTYPE html>
<html>
<head>
    <title>BUYSELL</title>
</head>
<body>
<h1>BUYSELL</h1>

<hr>
<h4>Товары со всей России</h4>
<form action="/" method="get">
    Поиск по названию объявления: <input type="text" name="name"><br>
    <input type="submit" value="Поиск"/>
</form>

<#if user.logins??>
    <h3>Имя пользователя: <i>${user.logins}</i></h3>
    <form action="/logout" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <input type="submit" value="Выйти"/>
    </form>
    <#if user.isAdmin()>
        <a href="/admin">Панель администратора</a>
    </#if>
<#else>
    <a href="/login">Войти</a></h1>
</#if>

<#list products as product>

    <div>
        <p><b>${product.name}</b>   | <a href="/product/${product.id}">Подробнее...</a></p>
    </div>
    <#else>
    <h3>Товаров нет</h3>
</#list>
<hr>

<#if user.logins??>
<h3>Создать новый товар</h3>
<form action="/product/create" method="post">
    Название темы: <input type="text" name="name"/>
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input type="submit" value="Добавить товар"/>
</form>
</#if>
</body>
</html>