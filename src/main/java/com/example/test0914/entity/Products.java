package com.example.test0914.entity;

import java.util.Date;

import org.hibernate.annotations.ColumnDefault;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "products")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prod_serial")
    private Long prodSerial;

    @Nonnull
    @ColumnDefault("0")
    private int prod_price;

    @Nonnull
    @Column(length = 50)
    @ColumnDefault("unnamed")
    private String prod_name;

    @Nonnull
    private Date modified;
}
