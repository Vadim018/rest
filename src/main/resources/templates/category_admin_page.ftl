<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="/static/css/category_admin_page.css">
    <title>Document</title>
</head>
<body>

<#import "templ/templ.ftl" as p>
<@p.pages>

    <h1 style="text-align: center">Управління категоріями</h1>

    <hr>

    <h2 style="text-align: center">Взяти дані з файлу</h2>

    <hr>
    <h2 style="text-align: center">Додати категорію</h2>


    <form action="/saveNewCategory" method="post">

        <table>
            <tbody>
            <tr>
                <td style="text-align: center">
                    <label style="text-align: center" for="name">
                        Назва
                    </label>
                    <br>
                    <input style="text-align: center" type="text" name="name" id="name">
                    <br>
                </td>
            </tr>
            <tr>
                <td style="text-align: center"><label style="text-align: center" for="description">Опис</label><br>
                    <input style="text-align: center" type="text" name="description" id="description"><br>
                </td>
            </tr>
            <tr>
                <td style="text-align: center" ><label style="text-align: center" for="image">Фото</label><br>
                    <input style="text-align: center" type="text" name="image" id="image" ><br>
                </td>
            </tr>

            <tr>
                <td style="text-align: center">
                    <input style="text-align: center" class="btn btn-primary mt-2" type="submit" value="Зберегти зміни">
                </td>
            </tr>
            </tbody>
        </table>

    </form>

    <br>
    <hr>
    <h2 style="text-align: center">Список доступних категорій</h2>

    <table>
        <thead>
        <tr>
            <td>Назва</td>
            <td>Опис</td>
        </tr>
        </thead>

        <tbody>

        <#if categories??>
            <#list categories as category>
                <tr>
                    <#--                    <td>${category.id}</td>-->
                    <td><a class="btn btn-warning w-100 h-50" href="/category_manager/${category.id}"> ${category.name} </a></td>
                    <td><a class="btn btn-success w-100 h-50">${category.description}</a></td>
                    <#--                    <td>${category.image}</td>-->
                </tr>
            </#list>
        </#if>

        </tbody>
    </table>

    <br>
    <hr>
    <h2 style="text-align: center"> Оновити/Видалити категорії</h2>

    <table>
        <thead>
        <tr>
            <td>Назва</td>
            <td>Опис</td>
            <#--            <td>Фото</td>-->

        </tr>
        </thead>

        <tbody>
        <#if categories??>
            <#list categories as category>
                <tr>
                    <form method="post" action="/updateCategory">
                        <input type="hidden" name="id" value="${category.id}">
                        <td><input type="text" name="name" value="${category.name}"></td>
                        <td><input type="text" name="description" value="${category.description}"></td>
                        <td><input type="hidden" name="image" value="${category.image}"></td>

                        <td>
                            <input class="btn btn-primary mt-2" type="submit" value="Оновити">
                        </td>
                    </form>
                    <td>
                        <form method="post" action="/deleteCategory">
                            <input class="btn btn-primary mt-2" type="hidden" name="id" value="${category.id}">
                            <input class="btn btn-primary mt-2" type="submit" value="Видалити"> ${Error}
                        </form>
                    </td>
                </tr>
            </#list>
        </#if>

        </tbody>
    </table>
    <br>
    <hr>
    <br>
    <h1 style="text-align: center">Видалити всі категорії</h1>
    <form method="post" action="/deleteAllCategory">${Error}
        <input class="btn btn-primary mt-2 mb-5" type="submit" value="Видалити">
    </form>

    <hr>

</@p.pages>
</body>
</html>
