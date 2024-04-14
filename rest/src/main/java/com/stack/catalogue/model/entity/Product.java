package com.stack.catalogue.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "catalogue", name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(max = 512)
    @Column(name = "url")
    private String url;

    @NotNull
    @Column(name = "price")
    private Double price;

    @NotNull
    @Column(name = "title")
    @Size(min = 3, max = 50)
    private String title;

    @Size(max = 1024)
    @Column(name = "details")
    private String details;

    public Product(
            Integer id,
            String title,
            String details) {
        this.id = id;
        this.title = title;
        this.details = details;
    }
}
