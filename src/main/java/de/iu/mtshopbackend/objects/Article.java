package de.iu.mtshopbackend.objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NonNull;
import org.springframework.hateoas.RepresentationModel;

import java.math.BigDecimal;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class Article extends RepresentationModel {
    @NonNull
    private Long id;
    private String name;
    private BigDecimal price;
    private String description;
}
