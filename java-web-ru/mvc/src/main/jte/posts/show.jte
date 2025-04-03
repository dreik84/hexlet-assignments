@import exercise.dto.posts.PostPage
@import exercise.util.NamedRoutes
@param PostPage page

@template.layout.page(
    content = @`
        <main>
            <div>
                <h1>${page.getPost().getName()}</h1>
            </div>
            <div>
                ${page.getPost().getBody()}
            </div>
            <!-- BEGIN -->
            <div>
                <a href="/posts/${page.getPost().getId()}/edit">Редактировать</a>
            </div>
            <!-- END -->
        </main>
    `
)
