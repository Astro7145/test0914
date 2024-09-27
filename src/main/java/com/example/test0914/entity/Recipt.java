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
@Table(name = "recipt")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Recipt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rctId;

    @Nonnull
    private int table_number;

    @Nonnull
    private int tax;

    @Nonnull
    private Date purchase_date;

    @Nonnull
    private int purchase_type;

    @Nonnull
    @ColumnDefault("false")
    @Column(columnDefinition = "TINYINT(1)")
    private boolean isDone;

    @Nonnull
    @ColumnDefault("false")
    @Column(columnDefinition = "TINYINT(1)")
    private boolean isCanceled;
}
