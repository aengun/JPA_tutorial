package hellojpa;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("M")
public class Movie extends Item{

    private String dirrector;
    private String actor;

    public String getDirrector() {
        return dirrector;
    }

    public void setDirrector(String dirrector) {
        this.dirrector = dirrector;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }
}
