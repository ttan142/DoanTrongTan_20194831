package hust.soict.dsai.aims.media;

public class Disc extends Media {
    protected int length;
    protected String director;

    public Disc(String title) {
        super(title);
    }

    public Disc(String title, String category, float cost) {
        super(title, category, cost);
    }

    public Disc(String title, String director, String category, float cost) {
        super(title, category, cost);
        this.director = director;
    }

    public Disc(String title, String director, String category, int length, float cost) {
        super(title, category, cost);
        this.length = length;
        this.director = director;
    }

    public int getLength() {
        return length;
    }

    public String getDirector() {
        return director;
    }

    public void play() {
        if(this.length <= 0 ) {
            System.out.println("This DVD cannot be played");
        }
        else {
            System.out.println("Playing DVD: " + this.getTitle());
            System.out.println("DVD length: " + this.getLength());
        }
    }
}
