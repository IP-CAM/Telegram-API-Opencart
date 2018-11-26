package ua.kpi.telegram.opencart.telegramopencart.domain.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.net.URL;

@Entity
public abstract class TaxonomyUnit implements Identified {
    @Id
    private long id;

    private String name;

    private String description;

    private URL image;

    @Override
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
}
