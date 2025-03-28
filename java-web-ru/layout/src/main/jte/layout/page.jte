@import gg.jte.Content
@param Content content
@param Content footer = null

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
<nav>
    <ul>
        <li>
            <a class="nav-link" href="/">Home</a>
        </li>
        <li>
            <a class="nav-link" href="/users">Users</a>
        </li>
    </ul>
</nav>

<div>
    ${content}
</div>

@if (footer != null)
    <footer>
        <div>
            ${footer}
        </div>
    </footer>
@endif

</body>
</html>