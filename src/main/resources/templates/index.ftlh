<!DOCTYPE html>
<html lang="en">

<head>
    <link rel="stylesheet" type="text/css" href="/static/newStyle.css"/>
    
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, inital-scale=1.0">
    <title>SSAU</title>

    
</head>
<body class="body" >
    <header>
        <div class="title">
            Форум для студентов Самарского университета
        </div>
        <form action="/" method="get" class="searchForm">
            <input class="search_wrapper" type="text" name="name">
            <input class="inputSubmit" type="submit" value="Поиск"/>
        </form>
        <#if user.logins??>
            <form action="/logout" method="post">
                <input type="hidden" name="_csrf" value="${_csrf.token}">
                <input type="submit" class="button1" value="Выйти"/>
            </form>
            <#--<input type="hidden" name="_csrf" value="${_csrf.token}">
            <a class="button1" href="/logout">Выйти</a>-->
            <#else>
                <a class="button1" href="/login">Войти</a>
                <a class="button2" href="/registration">Регистрация</a>
        </#if>
        <#--<div>
            <a class="button1" href="input.html">Войти</a>
        </div>
        <a class="button2" href="registr.html">Регистрация</a>-->
        
    </header>

     
    <div class="leftList">
            <div class="leftListblock">
                
                    <a class="leftListblockButton" href="/">Главная</a>
                
                
            </div>

        <#if user.isAdmin()>
            <div class="leftListblock">
                <a class="leftListblockButton" href="/admin">Панель администратора</a>
            </div>
        </#if>

            
    </div>
    <div class="popularBlock">
        <div class="popularPopular">
            <div class="popularText">Популярные темы</div>
        </div>
        <#list products as product>

            <div class="themeBlock">
                <a class="themeText" href="/product/${product.id}">${product.name}</a>
            </div>
        <#else>
            <h3>Тут пока нет тем, но вы можете их создать, если войдете или зарегестрируетесь </h3>
        </#list>
        <#--<div class="themeBlock">
            <a class="themeText" href="themepage.html">
                Тут заголовок темы
            </a>
        </div>-->

    </div>

  <#--  <#if user.logins??>
        <h3>Создать новый товар</h3>
        <form action="/product/create" method="post">
            Название темы: <input type="text" name="name"/>
            <input type="hidden" name="_csrf" value="${_csrf.token}">
            <input type="submit" value="Добавить товар"/>
        </form>
    </#if>-->

    <#if user.logins??>
        <div class="ThemeblockAdd" >
            <a class="button2" href="/newtheme">Добавить новую тему</a>
        </div>
        <#else >
            <div class="ThemeblockAdd">
                <a class="button2" href="/login">Добавить новую тему</a>
            </div>
    </#if>
    
    
    
</body>
    
    



</html>