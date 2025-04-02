@import exercise.dto.posts.PostsPage
@import exercise.util.NamedRoutes
@param PostsPage page

@template.layout.page(
content = @`
    <div>
        <main>
            <h1>Все посты</h1>
            <ul>
                @for(var post : page.getPosts())
                    <li>
                        ${post.getId()}
                        <a href="${exercise.util.NamedRoutes.postPath(post.getId())}">${post.getName()}</a>
                        ${post.getBody()}
                    </li>
                @endfor
            </ul>
            <nav>
                <a href="?page=${page.getPage() < 2 ? 1 : page.getPage() - 1}">
                    <span>prev</span>
                </a>
                <a href="${exercise.util.NamedRoutes.postsPath()}?page=${page.getPage()}">${page.getPage()}</a>
                <a href="?page=${page.getPage() + 1}">
                    <span>next</span>
                </a>
            </nav>
        </main>
    </div>
`
)