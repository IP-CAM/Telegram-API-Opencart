package ua.kpi.telegram.opencart.telegramopencart.domain.model.taxonomy;

import ua.kpi.telegram.opencart.telegramopencart.domain.model.Identified;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.net.URL;

@Entity
public abstract class TaxonomyUnit implements Identified {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    private Category parentCategory;

    private String name;

    private String description;

    private URL image;

    public TaxonomyUnit() {

    }

    public TaxonomyUnit(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Override
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setParentCategory(Category parentCategory) {
        this.parentCategory = parentCategory;
    }

    public Category getParentCategory() {
        return parentCategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public URL getImage() {
        return image;
    }

    public void setImage(URL image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "TaxonomyUnit{" +
                "id=" + id +
                ", parentCategory=" + parentCategory +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", image=" + image +
                '}';
    }
}
