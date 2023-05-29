package hust.soict.dsai.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable {
    private String artist;
    public ArrayList<Track> tracks = new ArrayList<Track>();

    public String getArtist() {
        return artist;
    }

    public CompactDisc(String title, String artist) {
        super(title);
        this.artist = artist;
    }

    public CompactDisc(String title, String category, float cost, String artist) {
        super(title, category, cost);
        this.artist = artist;
    }

    public CompactDisc(String title, String director, String category, float cost, String artist) {
        super(title, director, category, cost);
        this.artist = artist;
    }

    public CompactDisc(String title, String director, String category, int length, float cost, String artist) {
        super(title, director, category, length, cost);
        this.artist = artist;
    }

    public void addTrack(Track track) {
        if(tracks.contains(track)) {
            System.out.println("The track is already in the list.");
        }
        else {
            tracks.add(track);
            System.out.println("Track " + track.getTitle() + " added successfully.");
        }
    }

    public void removeTrack(Track track) {
        if(!tracks.contains(track)) {
            System.out.println("The track does not exist. Please try again.");
        }
        else {
            tracks.remove(track);
            System.out.println("Track " + track.getTitle() + " removed from the list.");
        }
    }

    public int getLength() {
        int totalLength = 0;
        for(Track track : this.tracks) {
            totalLength += track.getLength();
        }
        return totalLength;
    }

    @Override
    public void play() {
        if(this.getLength() <= 0) {
            System.out.println("The CD cannot be played");
        }
        else {
            System.out.println("Playing tracks by: " + this.artist);
            System.out.println("Total length: " + this.getLength());
            for (Track track : tracks) {
                track.play();
            }
        }
    }

    public String toString() {
        StringBuffer trackInfo = new StringBuffer();
        for(Track track : tracks) {
            trackInfo.append(track.toString());
        }
        return
                "CD: " + this.title +
                        "\nCategory: " + this.category +
                        "\nArtist: " + this.artist +
                        "\nDirector: " + this.director +
                        "\nCD length: " + this.getLength() +
                        "\nCost: " + this.cost +
                        "\nTracks: " + trackInfo;
    }

}
