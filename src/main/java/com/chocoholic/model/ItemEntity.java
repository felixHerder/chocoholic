package com.chocoholic.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "catalog")
@Data
public class ItemEntity {
    @Id
    String uuid;

    @NotBlank
    String title;

    @NotNull
    BigDecimal price;

    @Override
    public boolean equals(Object object) {
        if(object instanceof ItemEntity) {
            ItemEntity other = (ItemEntity) object;
            return Objects.equals(this.uuid, other.uuid);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.uuid);
    }
}
