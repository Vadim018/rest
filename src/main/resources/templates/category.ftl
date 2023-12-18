<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Категорії</title>
  <link rel="icon" type="png" href="/static/images/category/icon.png">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
  <link rel="stylesheet" href="/static/css/category.css">
</head>
<body>
<div class="search-container">
  <form role="search" action="/search" class="m-2">
    <input class="form-control" type="search" name="q" placeholder="Пошук" aria-label="Search">
    <button class="btn btn-outline-success" type="submit">Пошук</button>
    <a href="/cart" class="btn btn-outline-success m-2">Кошик</a>
    <a href="/" class="btn btn-outline-success">Назад</a>
  </form>
</div>
<div class="menu-container">
  <#if categories??>
    <#if categories?size == 0>
      <div class="card">
        <div class="card-body">
          <h5 class="card-title">Нічого не знайдено :(</h5>
        </div>
      </div>
    <#else>
      <#list categories as category>
        <div class="card category-card">
          <a href="/category/${category.id}">
            <img src="${category.image}" class="card-img-top" alt="${category.name}">
          </a>
          <div class="card-body">
            <h5 class="card-title">${category.name}</h5>
          </div>
        </div>
      </#list>
    </#if>
  <#else>
    <div class="card">
      <div class="card-body">
        <h5 class="card-title">It's still empty here...</h5>
      </div>
    </div>
  </#if>
</div>

<script src="/static/js/category.js">

</script>


</body>
</html>