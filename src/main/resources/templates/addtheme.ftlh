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
<div class="blockinput">
    <div class="shapkainputblock">
        <div class="inputtext">
            Добавление темы
        </div>
    </div>
    <form class="inputbody" action="/product/create" method="post">
        <input class="signin" type="text"  name="name" placeholder=" Название темы">
        <div class="textadd">
            Описание темы
        </div>
        <textarea class="newThemeText" cols="30" rows="10" name="description">
            </textarea>
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <input class="button2" type="submit" value="Добавить тему"/>

    </form>

</div>