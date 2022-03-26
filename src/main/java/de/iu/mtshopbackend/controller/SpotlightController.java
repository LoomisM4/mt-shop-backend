package de.iu.mtshopbackend.controller;

import de.iu.mtshopbackend.objects.Article;
import de.iu.mtshopbackend.util.HttpEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class SpotlightController {
    @Autowired
    HttpEnvironment env;

    @GetMapping("/spotlight")
    public ResponseEntity<CollectionModel<Article>> getSpotlightArticles() {
        Article a1 = createArticle(0, "/img/spotlight/S1.jpg");
        Article a2 = createArticle(1, "/img/spotlight/S2.JPG");
        Article a3 = createArticle(2, "/img/spotlight/S3.jpg");

        CollectionModel c = CollectionModel.of(List.of(a1, a2, a3));
        return ResponseEntity.of(Optional.of(c));
    }

    private Article createArticle(long id, String spotlightUrl) {
        String baseUrl = env.getBaseUrl();

        Article a = new Article(id);
        a.add(Link.of(baseUrl + spotlightUrl, "spotlightImage"));
        a.add(Link.of(baseUrl + "/details/" + id, "details"));

        return a;
    }
}
