<!DOCTYPE html>
<html lang="en">
<head>
    <title>Confirmation Page</title>
    <link rel="icon" type="png" href="/static/images/category/icon.png">
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="/static/css/order.css">
</head>
<body>
<div class="container mt-4">
    <div class="form-section card">
        <div class="card-header">
            <h2>Форма замовлення</h2>
        </div>
        <div class="card-body">
            <form action="/thank" method="get" onsubmit="return validateForm()">
                <div class="form-row">
                    <div class="col-md-4 mb-3">
                        <label for="firstName">Ім'я</label>
                        <input type="text" class="form-control" id="firstName" name="firstName" required minlength="2" maxlength="14">
                    </div>
                    <div class="col-md-4 mb-3">
                        <label for="lastName">Прізвище</label>
                        <input type="text" class="form-control" id="lastName" name="lastName" required minlength="2" maxlength="14">
                    </div>
                    <div class="col-md-4 mb-3">
                        <label for="phone">Телефон</label>
                        <input type="tel" class="form-control" id="phone" name="phone" required minlength="10" maxlength="14">
                    </div>
                </div>
                <div class="form-row">
                    <div class="col-md-6 mb-3">
                        <label for="email">Пошта</label>
                        <input type="email" class="form-control" id="email" name="email" required>
                    </div>
                    <div class="col-md-6 mb-3">
                        <label for="address">Адреса</label>
                        <input type="text" class="form-control" id="address" name="address" required>
                    </div>
                </div>
                <div class="form-row">
                    <div class="col-md-6 mb-3">
                        <label for="payment">Спосіб оплати</label>
                        <select class="form-control" id="payment" name="payment" onchange="handlePaymentChange(this)" required>
                            <option value="" selected>Вибрати...</option>
                            <option value="cash">Готівка</option>
                            <option value="card">Карта</option>
                        </select>
                    </div>
                    <div class="col-md-6 mb-3">
                        <label for="delivery">Спосіб доставки</label>
                        <div class="delivery-option">Bolt Food</div>
                    </div>
                </div>
                <div class="form-row">
                    <div class="col-md-12">
                        <button type="submit" id="submitButton" class="btn btn-primary" disabled>
                            Оформити замовлення
                        </button>
                    </div>
                </div>
            </form>
        </div>
    </div>
    <div class="form-section card" id="paymentDetailsForm" style="display: none;">
        <form>
            <div class="card-header">
                <h2>Введіть дані вашої карти</h2>
            </div>
            <div class="card-body">
                <div class="form-group">
                    <label for="cardNumber">Номер карти:</label>
                    <input type="text" class="form-control" id="cardNumber" pattern="\d{4} \d{4} \d{4} \d{4}">
                </div>
                <div class="form-row">
                    <div class="col-md-4 mb-3">
                        <label for="cardCVV">CVV:</label>
                        <input type="password" class="form-control" id="cardCVV" pattern="\d{3}">
                    </div>
                    <div class="col-md-4 mb-3">
                        <label for="cardExpiry">Дійсна до:</label>
                        <input type="text" class="form-control" id="cardExpiry" pattern="(0[1-9]|1[0-2])/\d{2}">
                    </div>
                </div>
                <div class="form-row">
                    <div class="col-md-12">
                        <button class="btn btn-primary" type="button" onclick="validateCardDetails()">Перевірити дані</button>
                    </div>
                </div>
            </div>
        </form>
    </div>
    <div class="card product-card mb-4">
        <div class="card-header">
            <h2>Чек-лист</h2>
        </div>
        <div class="card-body">
            <div class="table-responsive">
                <table class="table table-bordered">
                    <tbody>
                    <#if itemCart??>
                        <#list itemCart as item>
                            <tr>
                                <td class="text-center">${item.product.name}</td>
                                <td class="text-center">${item.quantity}</td>
                                <td class="text-center">${item.product.price} (1 шт.)</td>
                                <td class="text-center">${item.product.price * item.quantity}</td>
                            </tr>
                        </#list>
                    </#if>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    <div class="card-sum">
        <p>Сума: <span id="totalCost"></span></p>
        <p>Кількість: <span id="totalQuantity"></span></p>
    </div>
</div>

<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

<script src="/static/js/order.js">

</script>


</body>
</html>