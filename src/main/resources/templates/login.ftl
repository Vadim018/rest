<!DOCTYPE html>
<html lang="en">
<head>
    <title>Авторизація</title>
    <link rel="icon" type="png" href="/static/images/category/icon.png">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="/static/css/login.css">
</head>
<body>
<div class="container">
    <div class="card" id="loginCard">
        <h1>Авторизація</h1>
        <hr>
        <form class="login-form" action="/login" method="post">
            <div class="form-group">
                <label for="username">Логін</label>
                <input type="text" class="form-control" name="username" id="username">
            </div>
            <div class="form-group password-toggle">
                <label for="password">Пароль</label>
                <div class="input-group">
                    <input type="password" class="form-control" name="password" id="password">
                    <div class="input-group-append">
                        <button class="btn btn-outline-secondary toggle-button" type="button" id="togglePassword">
                            <i class="far fa-eye"></i>
                        </button>
                    </div>
                </div>
            </div>
            <div class="btn-container">
                <a href="/" class="btn btn-outline-secondary">Назад</a>
                <button class="btn btn-outline-primary" type="submit">Увійти</button>
            </div>
        </form>
    </div>
</div>

<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/js/all.min.js"></script>

<script src="/static/js/login.js">

</script>


</body>
</html>