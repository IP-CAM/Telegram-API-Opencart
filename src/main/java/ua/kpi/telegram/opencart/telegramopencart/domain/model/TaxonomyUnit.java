package ua.kpi.telegram.opencart.telegramopencart.domain.model;

import java.net.URL;

public abstract class TaxonomyUnit implements Identified {
    private String name;

    private String description;

    private URL image;

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
