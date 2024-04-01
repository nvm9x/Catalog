package kz.runtime.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "p_name")
    private String name;



    private Integer price;

    //@OneToMany - пишется ос стороны сущностей запись которой будет одна
    //@ManyToOne - со стороны сущности записи которой будет много

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "product")
    private List<Value> valueList;


    public String getName() {
        return name;
    }

    public List<Value> getValueList() {
        return valueList;
    }

    public void setValueList(List<Value> valueList) {
        this.valueList = valueList;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}

