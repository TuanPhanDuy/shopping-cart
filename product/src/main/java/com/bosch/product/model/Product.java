package com.bosch.product.model;

import com.bosch.product.model.attribute.ProductAttributeValue;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "product")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product extends AbstractAuditEntity implements Serializable {

    private Long id;
    private String name;
    private String description;
    private String specification;
    private String sku;
    private String gtin;
    private String slug;
    private double price;
    private boolean hasOptions;
    private boolean isAllowedToOrder;
    private boolean isPublished;
    private boolean isFeatured;
    private boolean isVisibleIndividually;
    private boolean stockTrackingEnabled;
    private Long stockQuantity;
    private Long taxClassId;
    private String metaTitle;
    private String metaKeyword;
    private String metaDescription;
    private Long thumbnailMediaId;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @OneToMany(mappedBy = "product", cascade = CascadeType.PERSIST)
    @Builder.Default
    private List<ProductCategory> productCategories = new ArrayList<>();

    @OneToMany(mappedBy = "product")
    @JsonIgnore
    @Builder.Default
    private List<ProductAttributeValue> attributeValues = new ArrayList<>();

    @OneToMany(mappedBy = "product", cascade = {CascadeType.PERSIST})
    @Builder.Default
    private List<ProductImage> productImages = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Product parent;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.REMOVE)
    @JsonIgnore
    @Builder.Default
    private List<Product> products = new ArrayList<>();

    @OneToMany(mappedBy = "product")
    @Builder.Default
    List<ProductRelated> relatedProducts = new ArrayList<>();

    private boolean taxIncluded;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Product)) {
            return false;
        }
        return id != null && id.equals(((Product) o).id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
