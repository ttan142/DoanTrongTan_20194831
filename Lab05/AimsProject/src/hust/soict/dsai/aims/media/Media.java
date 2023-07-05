package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.MediaComparatorByCostTitle;
import hust.soict.dsai.aims.MediaComparatorByTitleCost;

import java.time.LocalDate;
import java.util.Comparator;

public abstract class Media implements Comparable<Media>{
    protected String title;
    protected String category;
    protected float cost;
    protected LocalDate dateAdded;
    protected int id;
    protected static int nbMedia = 0;

    public static final Comparator<Media> COMPARE_BY_TITLE_COST =
            new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE =
            new MediaComparatorByCostTitle();

    public Media(String title, String category, float cost) {
        this.title = title;
        this.category = category;
        this.cost = cost;
        this.id = nbMedia;
        nbMedia++;
    }

    public Media(String title, String category) {
        this.title = title;
        this.category = category;
        this.id = nbMedia;
        nbMedia++;
    }

    public Media(String title) {
        this.title = title;
        this.id = nbMedia;
        nbMedia++;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public float getCost() {
        return cost;
    }

    public int getId() {
        return id;
    }

    public static int getNbMedia() {
        return nbMedia;
    }

    public String toString() {
        return this.getClass().getSimpleName() + " (ID = " + this.id + ") - " + this.title + "\t - \t" + this.category
                + "\t - \t $" + this.cost;
    }

    public boolean equals(Object o) {
        if(o instanceof Media) {
            Media that = (Media) o;
            return (this.getId() == that.getId());
        }
        else return false;
    }

    public int compareTo(Media obj) {
        if(this.getTitle().compareTo(obj.getTitle()) == 0) {
            return this.getCategory().compareTo(obj.getCategory());
        }
        return this.getTitle().compareTo(obj.getTitle());
    }

}
