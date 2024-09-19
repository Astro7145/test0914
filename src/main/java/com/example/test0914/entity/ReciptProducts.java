package com.example.test0914.entity;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "recipt_products")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ReciptProducts {
    @Id
    private String prod_id;

    @ManyToOne
    @JoinColumn(name = "id")
    private Recipt recipt;

    @Nonnull
    private String prod_serial;

    @Nonnull
    private int prod_quantity;

    @Nonnull
    private String purchase_date;

}
