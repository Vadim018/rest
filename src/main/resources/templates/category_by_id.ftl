<#import "templ/templ.ftl" as p>
<@p.pages>

    <#if category??>
        <h1>Категорії</h1>
        <p>ID: ${category.id}</p>
        <p>Назва : ${category.name}</p>
        <p>Опис : ${category.description}</p>
        <p>Фото: ${category.image}</p>
    </#if>

</@p.pages>