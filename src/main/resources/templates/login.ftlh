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
            Вход
        </div>
    </div>

        <form class="inputbody" action="/login" method="post">
            <input class="signin" type="text" name="username" placeholder=" Логин">
            <input class="signin" type="password" name="password" placeholder=" Пароль">
            <input type="hidden" name="_csrf" value="${_csrf.token}">
            <input class="button1" type="submit" value="Войти"/>
            <a class="button2" href="/registration">Зарегистрироваться</a>
        </form>



</div>
</html>
<#--<body>

<form action="/login" method="post">
    Логин <input type="text" name="username"><br>
    Пароль <input type="password" name="password"><br>
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input type="submit" value="Войти"/>
</form>
<a href="/registration">Зарегистрироваться</a>

</body>



</head>-->
