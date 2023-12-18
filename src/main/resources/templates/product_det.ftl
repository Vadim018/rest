<#import "templ/templ.ftl" as p>
<@p.pages>

    <h1>${product.name}</h1>

    <p>ID: ${product.id}</p>
    <p>Назва: ${product.name}</p>
    <p>Опис: ${product.description}</p>
    <p>Ціна: ${product.price}</p>
    <p>Фото: ${product.image}</p>
    <p>Назва категорії: ${product.categories.name}</p>

    <form action="/deleteProduct" method="post">
        <input type="hidden" name="id" value="${product.id}">
        <input class="btn btn-primary mb-5" type="submit" value="Видалити">
    </form>

</@p.pages>