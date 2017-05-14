package controllers;

import dao.NewsDao;
import models.News;
import play.mvc.Before;
import play.mvc.Controller;

import java.util.List;

/**
 * Created by sagynysh on 5/15/17.
 */
public class NewsController extends Controller {

    @Before
    static void security() {
        if (session.get("logged") == null) {
            Application.login();
        } else {
            renderArgs.put("email", session.get("logged"));
        }
    }

    public static void index() {
        List<News> news = NewsDao.getAllNews();
        render(news);
    }
}
