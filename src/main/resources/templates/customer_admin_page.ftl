<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <link rel="stylesheet" href="/static/css/customer_admin_page.css">
</head>
<body>
<#import "templ/templ.ftl" as p>
<@p.pages>
    <h1 style="text-align: center">Список зареєстрованих користувачів</h1>

    <hr>
    <#if customers??>

        <style>

        </style>

        <#list customers as customer>
            <ul>
                <li>ID: ${customer.id}</li>
                <li>Ім'я: ${customer.firstName}</li>
                <li>Прізвище: ${customer.lastName}</li>
                <li>Логін: ${customer.user.username}</li>
                <li>Пароль: ${customer.user.password}</li>
                <li>EMAIL: ${customer.email}</li>
                <li>Телефон: ${customer.phone}</li>
                <li>Адреса: ${customer.address}</li>
                <li>
                    <form method="post" action="/deleteUser">
                        <input type="hidden" name="userId" value="${customer.id}">
                        <button type="submit">Видалити</button>
                    </form>
                </li>
            </ul>

            <hr>

        </#list>
    </#if>
</@p.pages>
</body>
</html>
