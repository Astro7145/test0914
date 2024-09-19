package com.example.test0914.entity;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "recipt")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Recipt {
    @Id
    private String id;

    @Nonnull
    private int tax;

    @Nonnull
    private String purchase_date;

    private int purchase_type;
}
