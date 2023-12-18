<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <link rel="stylesheet" href="/static/css/product_admin_page.css">
</head>
<body>
<#import "templ/templ.ftl" as p>
<@p.pages>

    <h1 style="text-align: center">Адміністрування товарів</h1>
    <hr>
    <h2 style="text-align: center">Додати товари</h2>



    <form action="/saveNewProduct" method="post">

        <table>
            <tbody>

            <tr>
                <td>
                    <label for="name">Назва</label><br>
                    <input style="text-align: center" type="text" name="name" id="name"><br>
                </td>
            </tr>

            <tr>
                <td>
                    <label for="description">Опис</label><br>
                    <input style="text-align: center" type="text" name="description"  id="description"><br>
                </td>
            </tr>

            <tr>
                <td>
                    <label for="image">Фото</label><br>
                    <input style="text-align: center" type="text" name="image" id="image" ><br>
                </td>
            </tr>

            <tr>
                <td>
                    <label for="price">Ціна</label><br>
                    <input style="text-align: center" type="number" name="price" id="price"><br>
                </td>
            </tr>

            <tr>
                <td><label style="text-align: center" for="category">Назва категорії</label><br>
                    <select name="categoryId">
                        <#list categories as category>
                            <option value="${category.id}">${category.name}</option>
                        </#list>
                    </select>
                    <br>
                </td>
            </tr>

            <tr>
                <td>
                    <input class="btn btn-primary" type="submit" value="Зберегти зміни">
                </td>
            </tr>

            </tbody>
        </table>
    </form>

    <br>
    <hr>

    <h2 style="text-align: center; margin-bottom: 30px; margin-top: 30px;">Список товарів</h2>


    <form>
        <table>
            <thead>

            <tr>
                <td>Назва</td>
                <td>Опис</td>
                <td>Ціна (1 шт.)</td>
                <td>Назва категорії</td>
            </tr>

            </thead>
            <tbody>
            <#if products??>
                <#list products as product>

                    <tr>
                        <td>
                            <a class="btn btn-warning w-100 h-50" href="/product_manager/${product.id}">${product.name}</a>
                        </td>
                        <td>${product.description}</td>
                        <td>${product.price}</td>
                        <td>${product.categories.name}</td>
                    </tr>

                </#list>
            </#if>
            </tbody>
        </table>
        <br>
        <hr>
    </form>

    <h2 style="text-align: center">Видалити/Оновити товари</h2>

    <table>
        <thead>

        <tr>
            <#--            <td style="text-align: center">ID</td>-->
            <td style="text-align: center">Назва</td>
            <td style="text-align: center">Опис</td>
            <td style="text-align: center">Фото</td>
            <td style="text-align: center">Ціна (1 шт.)</td>
            <td style="text-align: center">Категорія</td>
        </tr>

        </thead>
        <tbody>
        <#if products??>
            <#list products as product>
                <form action="/updateProduct" method="post">

                    <tr>

                        <input style="text-align: center" type="hidden" name="id" value="${product.id}">

                        <td>
                            <input style="text-align: center" type="text" name="name" value="${product.name}">
                        </td>
                        <td>
                            <input style="text-align: center" type="text" name="description" value="${product.description}">
                        </td>
                        <td>
                            <input style="text-align: center" type="text" name="image" value="${product.image}">
                        </td>
                        <td>
                            <input style="text-align: center" type="text" name="price" value="${product.price}">
                        </td>
                        <td>
                            <select name="categoryId">
                                <#list categories as category>
                                    <#if "${category.id}"=="${product.categories.id}">
                                        <option value="${category.id}">${category.name}</option>
                                    <#else>
                                        <option value="${category.id}">${category.name}</option>
                                    </#if>
                                </#list>
                            </select>
                            <input style="top: 20px" class="btn btn-primary mt-4 mb-2" type="submit" value="Оновити">
<#--                            <form action="/deleteProduct" method="post">-->
<#--                                <input type="hidden" name="id" value="${product.id}">-->
<#--                                <input class="btn btn-primary mb-5" type="submit" value="Видалити">-->
<#--                            </form>-->
                        </td>
                </form>
                </tr>

            </#list>
        </#if>
        </tbody>
    </table>
    <br>
    <hr>
    <br>
    <h2 style="text-align: center">Видалити всю продукцію з категорії</h2>

    <form method="post" action="/deleteAllProduct">
        <input style="text-align: center" class="btn btn-primary mt-2 fs-15" type="submit" value="Видалити">
    </form>

    <br>
    <hr>
</@p.pages>
</body>
</html>
