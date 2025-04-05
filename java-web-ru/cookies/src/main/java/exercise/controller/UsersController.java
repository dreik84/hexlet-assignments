package exercise.controller;

import exercise.dto.users.UserPage;
import exercise.model.User;
import exercise.util.NamedRoutes;
import exercise.repository.UserRepository;
import exercise.util.Security;
import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;

import static io.javalin.rendering.template.TemplateUtil.model;


public class UsersController {

    public static void build(Context ctx) throws Exception {
        ctx.render("users/build.jte");
    }

    // BEGIN
    public static void create(Context ctx) {
        var firstName = ctx.formParam("firstName");
        var lastName = ctx.formParam("lastName");
        var email = ctx.formParam("email");
        var password = ctx.formParam("password");
        var encryptedPassword = Security.encrypt(password);
        var token = Security.generateToken();

        var user = new User(firstName, lastName, email, encryptedPassword, token);
        UserRepository.save(user);
        ctx.cookie("X-token", token);
        ctx.redirect(NamedRoutes.userPath(user.getId()));
    }

    public static void show(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var token = ctx.cookie("X-token");
        var user = UserRepository.find(id)
                .orElseThrow(() -> new NotFoundResponse("User with id = " + id + " not found"));

        if (user.getToken().equals(token)) {
            var page = new UserPage(user);
            ctx.render("users/show.jte", model("page", page));
        } else {
            ctx.redirect(NamedRoutes.buildUserPath());
        }
    }
    // END
}
