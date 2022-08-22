package net.sourcecode.springboot.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data // reduces the stress having to specify our getter and setter with our constructor
// to make this class a jpa entity we use the Entity annotation below
@Entity
@Table(name = "item")  // we specify our table name as our class name if we don't it will use it by default
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Name", nullable = false)
    private String title;

    @Column(name = "Category")
    private String category;

    @Column(name = "Brand")
    private String brand;

    @Column(name = "Stock")
    private int stock;

    @Column(name = "Discount_Percentage")
    private float discountPercentage;

    @Column(name = "Date")
    private LocalDate date;
}
