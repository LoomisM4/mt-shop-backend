package de.iu.mtshopbackend.controller;

import de.iu.mtshopbackend.objects.Category;
import de.iu.mtshopbackend.util.HttpEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class CategoryController {
    @Autowired
    HttpEnvironment env;

    @GetMapping("/categories")
    public ResponseEntity<CollectionModel<Category>> getCategories() {
        String baseUrl = env.getBaseUrl();

        RepresentationModel c1 = RepresentationModel.of(new Category(0L, "Neu"));
        c1.add(Link.of(baseUrl + "/category/0", "subcategories"));
        RepresentationModel c2 = RepresentationModel.of(new Category(1L, "Oberteile"));
        c2.add(Link.of(baseUrl + "/category/1", "subcategories"));
        RepresentationModel c3 = RepresentationModel.of(new Category(2L, "Accessoires"));
        c3.add(Link.of(baseUrl + "/category/2", "subcategories"));
        RepresentationModel c4 = RepresentationModel.of(new Category(3L, "Schuhe"));
        c4.add(Link.of(baseUrl + "/category/3", "subcategories"));
        RepresentationModel c5 = RepresentationModel.of(new Category(4L, "Unterwäsche"));
        c5.add(Link.of(baseUrl + "/category/4", "subcategories"));
        RepresentationModel c6 = RepresentationModel.of(new Category(5L, "Sport"));
        c6.add(Link.of(baseUrl + "/category/5", "subcategories"));

        CollectionModel categories = CollectionModel.of(List.of(c1, c2, c3, c4, c5, c6));
        return ResponseEntity.of(Optional.of(categories));
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<CollectionModel<Category>> getCategory(@PathVariable Long categoryId) {
        String baseUrl = env.getBaseUrl();

        RepresentationModel c1 = RepresentationModel.of(new Category(100L, "T-Shirts"));
        c1.add(Link.of(baseUrl + "/category/100/articles", "articles"));
        RepresentationModel c2 = RepresentationModel.of(new Category(101L, "Pullover"));
        c2.add(Link.of(baseUrl + "/category/101/articles", "articles"));
        RepresentationModel c3 = RepresentationModel.of(new Category(102L, "Hemden"));
        c3.add(Link.of(baseUrl + "/category/102/articles", "articles"));

        CollectionModel subcategories = CollectionModel.of(List.of(c1, c2, c3));
        return ResponseEntity.of(Optional.of(subcategories));
    }
}
