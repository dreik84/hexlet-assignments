package exercise.controller;

import exercise.exception.ResourceNotFoundException;
import exercise.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import java.util.List;

import exercise.model.Post;
import exercise.repository.PostRepository;

// BEGIN
@RestController
@RequestMapping("/posts")
public class PostsController {
    @Autowired
    private PostRepository posts;
    @Autowired
    private CommentRepository comments;

    @GetMapping(path = "")
    public List<Post> index() {
        return posts.findAll();
    }

    @GetMapping(path = "/{id}")
    public Post show(@PathVariable long id) {

        return posts.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post with id " + id + " not found"));
    }

    @PostMapping(path = "")
    @ResponseStatus(HttpStatus.CREATED)
    public Post create(@RequestBody Post post) {
        return posts.save(post);
    }

    @PutMapping(path = "/{id}")
    public Post update(@PathVariable long id, @RequestBody Post post) {
        Post updatePost = posts.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("post with id " + id + " not found"));

        updatePost.setTitle(post.getTitle());
        updatePost.setBody(post.getBody());
        posts.save(updatePost);

        return updatePost;
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable long id) {
        posts.deleteById(id);
        comments.deleteByPostId(id);
    }
}
// END
