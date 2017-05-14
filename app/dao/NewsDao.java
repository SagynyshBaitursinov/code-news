package dao;

import models.News;
import play.db.jpa.JPA;

import java.util.List;

/**
 * Created by sagynysh on 5/15/17.
 */
public class NewsDao {

    public static List<News> getAllNews() {
        List<News> result = JPA.em().createQuery("Select n from News n order by n.createdDate desc").getResultList();
        return result;
    }
}
