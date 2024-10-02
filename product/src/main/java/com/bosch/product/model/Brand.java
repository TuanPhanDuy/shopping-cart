package com.bosch.product.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "brand")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Brand extends AbstractAuditEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String slug;
    private boolean isPublished;

    @OneToMany(mappedBy = "brand")
    private List<Product> products;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Brand)) return false;
        return id != null && id.equals(((Brand) o).getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
