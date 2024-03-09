<!DOCTYPE html>
<html lang="en">
<head>
    <title>Реєстрація</title>
    <link rel="icon" type="png" href="/static/images/category/icon.png">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <script type="text/javascript" src="/static/jQuery/jquery-3.6.3.min.js"></script>
    <link rel="stylesheet" href="/static/css/registration.css">
</head>
<body>
<#import "/spring.ftl" as spring>
<div class="container">
    <div class="card hidden">
        <h1>Форма реєстрації</h1><br>
        <form action="/registration" method="post">
            <@spring.bind "users"/>
            <div class="form-group">
                <label for="username">Логін</label>
                <@spring.formInput "users.username"/>
                <@spring.showErrors "<br>"/>
            </div>
            <div class="form-group">
                <label for="password">Пароль</label>
                <div class="input-group">
                    <input type="password" id="password" name="password" class="form-control">
                    <span class="input-group-text peephole"><i class="fas fa-eye"></i></span>
                </div>
                <@spring.showErrors "<br>"/>
            </div>
            <@spring.bind "customer"/>
            <div class="form-group">
                <label for="firstName">Ім'я</label>
                <@spring.formInput "customer.firstName"/>
                <@spring.showErrors "<br>"/>
            </div>
            <div class="form-group">
                <label for="lastName">Прізвище</label>
                <@spring.formInput "customer.lastName"/>
                <@spring.showErrors "<br>"/>
            </div>
            <div class="form-group">
                <label for="phone">Телефон</label>
                <@spring.formInput "customer.phone"/>
                <@spring.showErrors "<br>"/>
            </div>
            <div class="form-group">
                <label for="email">Пошта</label>
                <@spring.formInput "customer.email"/>
                <@spring.showErrors "<br>"/>
            </div>
            <div class="form-group">
                <label for="age">Вік</label>
                <@spring.formInput "customer.age"/>
                <@spring.showErrors "<br>"/>
            </div>
            <div class="form-group">
                <label for="address">Адреса</label>
                <@spring.formInput "customer.address"/>
                <@spring.showErrors "<br>"/>
            </div>
            <div class="btn d-flex justify-content-center">
                <a class="btn btn-outline-secondary" href="/login">
                    Назад
                </a>
                <button class="btn btn-outline-primary" type="submit">
                    Зберегти
                </button>
            </div>
        </form>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
        integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js"
        integrity="sha384-mQ93GR66B00ZXjt0YO5KlohRA5SY2XofN4zfuZxLkoj1gXtW8ANNCe9d5Y3eG5eD"
        crossorigin="anonymous"></script>

<script src="/static/js/registration.js">

</script>

<style>

</style>

</body>
</html>