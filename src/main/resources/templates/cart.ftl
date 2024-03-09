<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Кошик</title>
    <link rel="icon" type="image/png" href="/static/images/category/icon.png">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="/static/css/cart.css">
    <script type="text/javascript" src="/static/jQuery/jquery-3.6.3.min.js"></script>
</head>
<body>
<header>
    <h1 class="text-center">Кошик</h1>
</header>
<section class="h-100">
<div class="container py-5">
    <div class="row">
        <div class="col">
            <div class="card">
                <div class="card-body p-0">
                    <div class="row">
                        <div class="col-md-12">
                            <h5>
                                <a href="/category" class="text-body">
                                    <img class="image-arrow" src="/static/images/category/arrow.png" alt="...">
                                </a>
                            </h5>
                        </div>
                        <div class="col-md-12">
                            <div class="table-responsive">
                                <table>
                                    <thead>
                                    <tr>
                                        <th></th>
                                        <th></th>
                                        <th></th>
                                        <th></th>
                                        <th></th>
                                        <th></th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <#if item_cart??>
                                        <#list item_cart as item>
                                            <form action="/updateItemCart" method="post">
                                                <tr>
                                                    <td>
                                                        <div class="d-flex justify-content-center">
                                                            <img src="${item.product.image}"
                                                                 alt="${item.product.name}" height="60px">
                                                        </div>
                                                    </td>
                                                    <td>
                                                        <div class="d-flex justify-content-center">
                                                            ${item.product.name}
                                                        </div>
                                                    </td>
                                                    <td>
                                                        <div class="d-flex justify-content-center counter">
                                                            <button class="minus btn btn-outline-danger"> -</button>
                                                            <input type="text" name="quantity"
                                                                   value="${item.quantity}" size="3"
                                                                   class="form-control">
                                                            <button class="plus btn btn-outline-success"> +</button>
                                                        </div>
                                                    </td>
                                                    <td>
                                                        <div class="d-flex justify-content-center">
                                                            <span class="cost">${item.product.price * item.quantity}</span>
                                                        </div>
                                                    </td>
                                                    <td>
                                                        <div class="d-flex justify-content-center">
                                                            <form action="/updateItemCart" method="post">
                                                                <input type="hidden" name="id"
                                                                       value="${item.product.id}">
                                                                <div class="btn-group" role="group"
                                                                     aria-label="Опції">
                                                                    <button type="submit" class="btn">
                                                                        <img class="image-update"
                                                                             src="/static/images/category/update.png"
                                                                             alt="...">
                                                                    </button>
                                                                </div>
                                                            </form>
                                                        </div>
                                                    </td>
                                                    <td>
                                                        <div class="d-flex justify-content-center">
                                                            <form action="/deleteItemCart" method="post"
                                                                  onsubmit="return confirm('Ви дійсно хочете видалити цей товар з кошика?');">
                                                                <input type="hidden" name="id"
                                                                       value="${item.product.id}">
                                                                <button type="submit" class="btn">
                                                                    <img src="/static/images/category/trash.png"
                                                                         alt="...">
                                                                </button>
                                                            </form>
                                                        </div>
                                                    </td>
                                                </tr>
                                            </form>
                                        </#list>
                                        <#if item_cart?has_content>
                                            <tr>
                                                <td colspan="6">
                                                    <div class="actions">
                                                        <form action="/deleteItemsCart" method="post">
                                                            <button type="submit" class="btn btn-outline-danger">
                                                                Очистити кошик
                                                            </button>
                                                        </form>
                                                        <form action="/order" method="get">
                                                            <button type="submit" class="btn btn-outline-success">
                                                                Оформити замовлення
                                                            </button>
                                                        </form>
                                                    </div>
                                                </td>
                                            </tr>
                                        </#if>
                                    </#if>
                                    </tbody>
                                </table>
                                <div class="empty-cart-message <#if item_cart?has_content>hide</#if>">
                                    Кошик пустий!
                                </div>
                                <hr>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</section>
<script src="https://kit.fontawesome.com/a076d05399.js" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="/static/js/cart.js"></script>
</body>
</html>