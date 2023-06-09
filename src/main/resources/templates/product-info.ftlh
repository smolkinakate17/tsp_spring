<!DOCTYPE html>
<html>
<head>
    <title>BUYSELL</title>
</head>
<body>
<h1>BUYSELL</h1><hr>
<h4>Подробная информация о товаре</h4>
<b>Название товара: </b>${product.name}<br>

Сообщения по теме<hr>
<#list messeges as mess>
    <p>${mess.text} ${mess.user.logins}  | <a href="/user/${mess.user.id}">Подробнее о пользователе...</a></p>
    <#else> Нет сообщений
</#list>

<#if user.logins??>
<form action="/product/messege/create/${product.id}" method="post">
    <input type="text" name="text">
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input type="submit" value="Создать сообщение"/>
</form>

<hr>

<form action="/product/delete/${product.id}" method="post">
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input type="submit" value="Удалить товар"/>
</form>
</#if>
</body>
</html>