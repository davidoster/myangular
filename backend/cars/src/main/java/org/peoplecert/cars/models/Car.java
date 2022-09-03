package org.peoplecert.cars.models;

import javax.persistence.*;

@Entity
@Table(name = "cars")
public class Car {
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "name")
	private String name;

	@Column(name = "color")
	private String color;

    @Column(name = "price")
	private double price;

    public Car() {}

    public Car(String name, String color, double price) {
        this.name = name;
        this.color = color;
        this.price = price;
    }

    public long getId() {
		return id;
	}

    public String getName() { return this.name; }
    public String getColor() { return this.color; }
    public double getPrice() { return this.price; }

    public void setName(String name) { this.name = name; }
    public void setColor(String color) { this.color = color; }
    public void setPrice(double price) { this.price = price; }

    public String toString() { return this.name + " " + this.color + " " + this.price; }
}