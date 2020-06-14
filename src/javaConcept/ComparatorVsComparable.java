package javaConcept;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

class Movie implements Comparable<Movie> {

    int rating;
    String name;
    int year;

    Movie(int rating, String name, int year) {
        this.rating = rating;
        this.name = name;
        this.year = year;
    }

    @Override
    public int compareTo(Movie m) {
        return this.year - m.year;
    }

    public int getRating() {
        return rating;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }
}

class MovieSortByRating implements Comparator<Movie> {

    @Override
    public int compare(Movie m1, Movie m2) {
        return m1.getRating()-m2.getRating();
    }
}


class MovieSortByName implements Comparator<Movie> {
    @Override
    public int compare(Movie m1 , Movie m2) {
        return m1.getName().compareTo(m2.getName());
    }
}

public class ComparatorVsComparable {
    public static void main(String[] args) {
        new ComparatorVsComparable().run();
    }

    private void run() {
        LinkedList<Movie> arr = new LinkedList<>();
        arr.add(new Movie(5, "Avengers", 2012));
        arr.add(new Movie(4, "GOG", 2018));
        arr.add(new Movie(1, "Hulk", 2004));

        Collections.sort(arr);
        arr.forEach(m -> System.out.println(m.getName() + " " + m.getRating() + " " + m.getYear()));

        System.out.println();
        Collections.sort(arr, new MovieSortByRating());
        arr.forEach(m -> System.out.println(m.getName() + " " + m.getRating() + " " + m.getYear()));

        System.out.println();
        Collections.sort(arr, new MovieSortByName());
        arr.forEach(m -> System.out.println(m.getName() + " " + m.getRating() + " " + m.getYear()));
    }
}
