package dto;

import models.News;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sagynysh on 5/15/17.
 */
public class NewsDto {

    public String title;
    public String text;
    public String imageUrl;
    public String createdDate;

    public NewsDto(News news) {
        this.title = news.title;
        this.text = news.text;
        this.imageUrl = news.imageUrl;
        this.createdDate = news.createdDate.getTime() + "";
    }

    public static List<NewsDto> fromList(List<News> news) {
        List<NewsDto> result = new ArrayList<NewsDto>();
        for (News eachNews: news) {
            result.add(new NewsDto(eachNews));
        }
        return result;
    }
}
