package kz.runtime.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "description")
public class Description {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "d_name")
    private String name;

    @ManyToOne
    @JoinColumn(name  ="category_id")
    private Category description;

    @OneToMany(mappedBy = "description")
    private List<Value> valueList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getDescription() {
        return description;
    }

    public void setDescription(Category description) {
        this.description = description;
    }

    public List<Value> getValueList() {
        return valueList;
    }

    public void setValueList(List<Value> valueList) {
        this.valueList = valueList;
    }
}
