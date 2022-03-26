package de.iu.mtshopbackend.objects;

import lombok.Data;
import lombok.NonNull;
import org.springframework.hateoas.RepresentationModel;

@Data
public class Category extends RepresentationModel {
    @NonNull
    private Long categoryId;
    @NonNull
    private String name;
}
