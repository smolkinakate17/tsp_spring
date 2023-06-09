
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





</header>


<div class="leftList">
    <div class="leftListblock">

        <a class="leftListblockButton" href="/">Главная</a>


    </div>

</div>
<div class="blockTheme">
    <div class="popularText">Панель администратора</div>
    <table  border="1">
        <tr>
            <th>Логин</th>
            <th>Активность</th>
            <th>Роль</th>
            <th>Бан</th>
            <th>Изменить роль</th>

        </tr>
        <#list users as user>
            <tr>
                <td>${user.logins}</td>

                <td><#if user.active>true<#else>false</#if></td>
                <td><#list user.roles as role>${role}</#list></td>
                <td>
                    <form action="/admin/user/ban/${user.id}" method="post">
                        <input type="hidden" name="_csrf" value="${_csrf.token}">
                        <input type="submit" value="Бан">
                    </form>
                </td>
                <td>
                    <form action="/admin/user/edit/${user.id}"  method="post">
                        <input type="hidden" name="_csrf" value="${_csrf.token}">
                        <input type="submit" value="Поменять роль">
                    </form>
                </td>

            </tr>
        <#else>
            <h3>Пользователей нет</h3>
        </#list>
    </table>
</div>




</body>

</html>