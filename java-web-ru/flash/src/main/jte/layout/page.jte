<!-- BEGIN -->
@import exercise.dto.BasePage
@import gg.jte.Content
@param Content content
@param BasePage page = null

<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Hello Hexlet!</title>
    </head>
    <body>
    @if(page != null && page.getFlash() != null)
        <div>
            <p>${page.getFlash()}</p>
        </div>
    @endif
        ${content}
    </body>
</html>
<!-- END -->
