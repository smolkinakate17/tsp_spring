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

    </header>


    <div class="leftList">
        <div class="leftListblock">

            <a class="leftListblockButton" href="/">Главная</a>
        </div>

        <#if user.isAdmin()>
            <div class="leftListblock">
                <a class="leftListblockButton" href="adminpage.html">Панель администратора</a>
            </div>
        </#if>
    </div>

    <div class="blockTheme">
        <div class="blockThemeText">
            <div class="popularText">${product.name}</div>

            <div class="populatTextTheme">
                <#if product.description??>
                    ${product.description}
                    <#else >
                        Тут нет описания
                </#if>

            </div>
        </div>

        <#list messeges as mess>
            <div class="messegeBlockDelete">

                <div class="messegesBlock">
                    <div class="messegeAuthor">

                        <div class="messegeAuthorName">${mess.user.logins}</div>
                    </div>
                    <div class="messegeText">${mess.text}</div>
                </div>
                <#if user.isAdmin()>
                    <form action="/product/messege/${mess.id}/delete/${product.id}/${mess.user.id}" method="post">
                        <input type="hidden" name="_csrf" value="${_csrf.token}">
                        <input type="image" src="/static/images/DeleteButt.svg" width="30" height="30">
                    </form>

                </#if>

            </div>
            <#else> Нет сообщений
        </#list>



    </div>

<#--<#if user.logins??>
<form action="/product/messege/create/${product.id}" method="post">
    <input type="text" name="text">
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input type="submit" value="Создать сообщение"/>
</form>
</#if>-->
<div class = 'left'>
</div>

<#if user.logins??>
    <div class = 'right'>
        <form class="newMessegeBlock" action="/product/messege/create/${product.id}" method="post">
            <div class="newMessegeTextBlock" >
                <textarea class="newMessegeText" name="text">

                </textarea>


            </div>
            <input type="hidden" name="_csrf" value="${_csrf.token}">
            <input type="image" src="/static/images/send.svg" width="30" height="30" />


        </form>
    </div>

    <#else >
        <div class = 'right'>

                <div class="logoutMessage" >
                Зарегестрируйтесь чтобы оставлять сообщения


                </div>
        </div>
</#if>
<#--<div class = 'right'>
    <form class="newMessegeBlock" action="/product/messege/create/${product.id}" method="post">
        <div class="newMessegeTextBlock" >
                <textarea class="newMessegeText" name="text">

                </textarea>


        </div>
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <input type="submit" value="Создать сообщение"/>
        <&lt;#&ndash;img src="send.svg" width="30" height="30">&ndash;&gt;

    </form>-->
</div>




</body>