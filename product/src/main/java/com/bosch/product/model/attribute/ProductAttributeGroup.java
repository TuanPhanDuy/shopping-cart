package com.bosch.product.model.attribute;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "product_attribute_group")
@Getter
@Setter
public class ProductAttributeGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductAttributeGroup)) return false;
        return id != null && id.equals(((ProductAttributeGroup) o).id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
