<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="/static/newStyle.css"/>

    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, inital-scale=1.0">
    <title>SSAU</title>
</head>
<div class="blockinput">
    <div class="shapkainputblock">
        <div class="inputtext">
            Регистрация
        </div>
    </div>

        <form class="inputbody" action="/registration" method="post">
            <input class="signin" type="text" name="logins" placeholder=" Логин">
            <input class="signin" type="text" name="passwords" placeholder=" Пароль">
           <#-- <input class="signin" type="text" name="password" placeholder=" Пароль">-->
            <input type="hidden" name="_csrf" value="${_csrf.token}">
            <input class="button2" type="submit" value="Регистрация"/>
        </form>
    <#if errorMessege??>
        ${errorMessege}
    </#if>


</div>
<#--<body>
<h1>BUYSELL</h1><hr>
<h4>Товары со всей России</h4>
<form action="/registration" method="post">
    Логин <input type="text" name="logins"><br>
    Пароль <input type="text" name="passwords"><br>
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input type="submit" value="Войти"/>
</form>
<#if errorMessege??>
    ${errorMessege}
</#if>
</body>-->
</html>