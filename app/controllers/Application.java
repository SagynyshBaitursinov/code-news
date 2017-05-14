package controllers;

import models.User;
import play.mvc.*;

/**
 * Created by sagynysh on 5/15/17.
 */
public class Application extends Controller {

    public static void index() {
        NewsController.index();
    }

    public static void logout() {
        session.clear();
        login();
    }

    public static void login() {
        if (session.get("logged") == null) {
            render();
        } else {
            NewsController.index();
        }
    }

    public static void authorize(String email, String password) {
        if (email == null) {
            login();
        }
        User user = User.find("email = ?", email).first();
        if (user != null && user.password.equals(password)) {
            try {
                session.put("logged", email);
                NewsController.index();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        login();
    }
}