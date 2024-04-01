package kz.runtime.entity;


import jakarta.persistence.*;

@Entity
@Table(name="value")

public class Value {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

@ManyToOne
@JoinColumn(name = "product_id" )
    private Product product;

@ManyToOne
    @JoinColumn(name = "description_id")
    private Description description;


    @Column(name="value_name")
    private String name;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Description getDescription() {
        return description;
    }

    public void setDescription(Description description) {
        this.description = description;
    }


}
