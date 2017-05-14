package controllers;

import dao.NewsDao;
import dto.NewsDto;
import models.News;
import models.User;
import play.db.jpa.JPA;
import play.mvc.Before;
import play.mvc.Controller;
import utils.JWTUtils;

import javax.persistence.NoResultException;
import java.util.List;

/**
 * Created by sagynysh on 5/15/17.
 */
public class API extends Controller {

    @Before(unless = {"login"})
    private static void check() {
        if (!request.headers.containsKey("jwt")) {
            renderText("forbidden");
        }
        String token = request.headers.get("jwt").value();
        String username = JWTUtils.getUsernameFromToken(token);
        if (username == null) {
            renderText("forbidden");
        }
        if (!JWTUtils.isValidToken(token, username)) {
            renderText("forbidden");
        }
    }

    public static void login(String email, String password) {
        if (email != null) {
            email = email.trim();
        } else {
            renderText("forbidden");
        }
        if (password != null) {
            password = password.trim();
        } else {
            renderText("forbidden");
        }
        User user = null;
        try {
            user = JPA.em().createQuery("Select u from User u where UPPER(email) = ?1", User.class).setParameter(1, email.toUpperCase()).getSingleResult();
        } catch (NoResultException e) {
        }
        if (user == null || !user.password.equals(password)) {
            renderText("forbidden");
        } else {
            String token = JWTUtils.generateToken(user.email);
            renderText(token);
        }
    }

    public static void getNews() {
        List<News> news = NewsDao.getAllNews();
        renderJSON(NewsDto.fromList(news));
    }
}
