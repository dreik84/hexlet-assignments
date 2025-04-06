@import exercise.dto.LoginPage
@import exercise.util.NamedRoutes

@param LoginPage page

@template.layout.page(
content = @`
    @if(page.getError() != null)
        <div>
            ${page.getError()}
        </div>
    @endif

    <main>
        <div>
            <form action="${NamedRoutes.loginPath()}" method="post">
                <div>
                    <label>
                        Имя
                        <input type="text" name="name" value="${page.getName()}">
                    </label>
                </div>
                <div>
                    <label>
                        Пароль
                        <input type="password" required name="password">
                    </label>
                </div>
                <input type="submit" value="Войти">
            </form>
        </div>
    </main>
`
)