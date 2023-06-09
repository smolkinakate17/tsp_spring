<!DOCTYPE html>
<html>
<head>
    <title>BUYSELL</title>
</head>
<body>
<h1>BUYSELL</h1><hr>
<h3>Подробная информация о пользователе ${user.logins}</h3>

<h4>Сообщения пользователя ${user.logins}</h4>
<#list messeges as message>
    <div>
        <p><b>${message.text}</b> ${message.theme.id} </p>
    </div>
<#else>
    <h3>Товаров нет</h3>
</#list>
<#if errorMessage??>
    <h2 style="color: red">${errorMessage}</h2>
</#if>
</body>
</html>