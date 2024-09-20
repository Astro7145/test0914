package com.example.test0914.entity;

import java.util.Date;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long prod_id;

    @Nonnull
    @ManyToOne
    @JoinColumn(name = "rctId")
    private Recipt recipt;

    @Nonnull
    private Long prod_serial;

    @Nonnull
    private int prod_quantity;

    @Nonnull
    private int prod_price;

    @Nonnull
    private Date purchase_date;

}
