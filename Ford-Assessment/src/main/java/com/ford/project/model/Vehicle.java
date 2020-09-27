package com.ford.project.model;


import lombok.*;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "VEHICLE")
@Data
@Getter
@Setter
public class Vehicle {

    @Column(name = "id")
    @Id
    private Integer id;

    @Column(name = "make")
    private String make;

    @Column(name = "model")
    private String model;

    @Column(name = "MODEL_YEAR")
    private String modelYear;

    @Column(name = "BODY_STYLE")
    private String bodyStyle;

    private String engine;
    private String driveType;
    private String color;
    private Integer MPG;
    private BigDecimal msrp;
    private BigDecimal savings;
    private BigDecimal finalPrice;

    @Override
    public String toString() {
        return String.format(this.make + " " + this.model + " " + this.modelYear + " " + this.bodyStyle);
    }
}
