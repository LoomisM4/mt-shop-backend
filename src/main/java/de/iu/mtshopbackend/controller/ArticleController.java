package de.iu.mtshopbackend.controller;

import de.iu.mtshopbackend.objects.Article;
import de.iu.mtshopbackend.util.HttpEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Links;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
public class ArticleController {
    @Autowired
    private HttpEnvironment env;

    @GetMapping("/category/{categoryId}/articles")
    public ResponseEntity<CollectionModel<Article>> getArticles(@PathVariable Long categoryId) {
        String baseUrl = env.getBaseUrl();

        Article a1 = createArticle(0L, baseUrl + "/img/vorne.png");
        a1.add(Link.of(baseUrl + "/details/0", "details"));
        Article a2 = createArticle(1L, baseUrl + "/img/rot.jpg");
        a2.add(Link.of(baseUrl + "/details/1", "details"));
        Article a3 = createArticle(2L, baseUrl + "/img/weiss.jpg");
        a3.add(Link.of(baseUrl + "/details/2", "details"));
        Article a4 = createArticle(3L, baseUrl + "/img/grau.jpg");
        a4.add(Link.of(baseUrl + "/details/3", "details"));

        CollectionModel<Article> articles = CollectionModel.of(List.of(a1, a2, a3, a4));
        return ResponseEntity.of(Optional.of(articles));
    }

    @GetMapping("/details/{articleId}")
    public ResponseEntity<Article> getDetails(@PathVariable Long articleId) {
        String baseUrl = env.getBaseUrl();

        Article a = createArticle(0L, baseUrl + "/img/vorne.png");
        a.setName("T-Shirt");
        a.setPrice(new BigDecimal("15.99"));
        a.setDescription("Blaues T-Shirt aus 100 % Baumwolle");
        Link l1 = Link.of(baseUrl + "/img/vorne.png", "images");
        Link l2 = Link.of(baseUrl + "/img/hinten.jpg", "images");
        Links images = Links.of(l1, l2);
        a.add(images);

        return ResponseEntity.of(Optional.of(a));
    }

    private Article createArticle(Long id, String previewUrls) {
        Article a = new Article(id);
        Link l1 = Link.of(previewUrls, "preview");
        a.add(l1);

        return a;
    }
}
