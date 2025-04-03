@import exercise.util.NamedRoutes
@import exercise.dto.posts.EditPostPage
@param EditPostPage page

<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Document</title>
</head>
<body>
@if(page.getErrors() != null)
    <div>
        <ul>
            @for(var validator : page.getErrors().values())
                @for(var error : validator)
                    <li>${error.getMessage()}</li>
                @endfor
            @endfor
        </ul>
    </div>
@endif

<div>
    <form action="${NamedRoutes.postPath(page.getId())}" method="post">
        <div>
            <label>
                Название
                <input type="text" name="name" value="${page.getName()}" />
            </label>
        </div>
        <div>
            <label>
                Содержание
                <textarea rows="20" cols="70" type="text" name="body">${page.getBody()}</textarea>
            </label>
        </div>
        <input type="submit" value="Сохранить" />
    </form>
</div>
</body>
</html>