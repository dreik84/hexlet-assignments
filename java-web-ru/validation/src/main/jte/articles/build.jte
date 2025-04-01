 @import exercise.dto.articles.BuildArticlePage
  @param BuildArticlePage page

@template.layout.page(
content = @`
  @if(page.getErrors() != null)
      <ul>
          @for(var validator : page.getErrors().values())
              @for(var error : validator)
                  <li>${error.getMessage()}</li>
              @endfor
          @endfor
      </ul>
  @endif

  <form action="/articles" method="post">
    <div>
      <label>
        Загаловок статьи
        <input type="text" name="title" value="${page.getTitle()}" />
      </label>
    </div>
    <div>
      <label>Содержание</label>
      <textarea type="text" name="content">${page.getContent()}</textarea>
    </div>
    <div>
        <input type="submit" class="btn btn-primary" value="Сохранить" />
    </div>
  </form>
  `
  )