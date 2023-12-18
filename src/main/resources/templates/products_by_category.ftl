<!DOCTYPE html>
<html lang="en">
<head>
    <title>${category}</title>
    <link rel="icon" type="png" href="/static/images/category/icon.png">
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <script type="text/javascript" src="/static/jQuery/jquery-3.6.3.min.js"></script>
    <link rel="stylesheet" href="/static/css/products_by_category.css">
</head>
<body>
<div class="row row-cols-2 row-cols-md-4 g-4 mb-2">
    <#if products_by_category??>
        <#list products_by_category as product>
            <div class="col">
                <div class="card" data-price="${product.price}">
                    <form class="add-to-cart-form" action="/cart" method="post">
                        <input type="hidden" name="id" id="id_" value="${product.id}">
                        <img src="${product.image}" class="card-img-top" alt="${product.name}">
                        <div class="card-body">
                            <h5 class="card-title">${product.name}</h5>
                            <p class="card-text">${product.description}</p>
                            <h5 class="total-price-container">
                                Ціна: <span class="total-price">${product.price}</span> ₴
                            </h5>
                            <div class="btn-container">
                                <button type="submit" class="btn btn-success add-to-cart-btn">У кошик</button>
                                <div class="counter">
                                    <button class="minus"> - </button>
                                    <input type="text" name="quantity" value="1" size="3">
                                    <button class="plus"> + </button>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </#list>
    </#if>
</div>

<script src="/static/js/products_by_category.js">

</script>

</body>
</html>