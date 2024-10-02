package com.bosch.product.model.attribute;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "product_template")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductTemplate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "productTemplate", cascade = {CascadeType.PERSIST})
    @Builder.Default
    private List<ProductAttributeTemplate> productAttributeTemplates = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductTemplate)) return false;
        return id != null && id.equals(((ProductTemplate) o).id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
