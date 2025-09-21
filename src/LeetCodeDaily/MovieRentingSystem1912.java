package LeetCodeDaily;

import java.util.*;

public class MovieRentingSystem1912 {

    static class MovieCopy {
        int shop, movie, price;
        MovieCopy(int shop, int movie, int price) {
            this.shop = shop;
            this.movie = movie;
            this.price = price;
        }
    }

    // data structure initialization
    Map<Integer, TreeSet<MovieCopy>> movieToCopies; // un-rented movies
    Map<String, MovieCopy> shopMovieMap; // uniquely identify movies
    TreeSet<MovieCopy> rentedSet;

    public MovieRentingSystem1912(int n, int[][] entries) {
        movieToCopies = new HashMap<>();
        shopMovieMap = new HashMap<>();
        rentedSet = new TreeSet<>((a, b) -> {
            if (a.price != b.price) return a.price - b.price;
            if (a.shop != b.shop) return a.shop - b.shop;
            return a.movie - b.movie;
        }); // stores sorted movies as price, shop, movie

        for (int[] e : entries) {
            int shop = e[0], movie = e[1], price = e[2];
            MovieCopy movieCopy = new MovieCopy(shop, movie, price);
            shopMovieMap.put(shop + ":" + movie, movieCopy);

            movieToCopies.putIfAbsent(movie, new TreeSet<>(
                    (a, b) -> (a.price != b.price) ? (a.price - b.price) : (a.shop - b.shop)
            ));
            movieToCopies.get(movie).add(movieCopy);
        }
    }

    public List<Integer> search(int movie) {
        List<Integer> result = new ArrayList<>();
        if (!movieToCopies.containsKey(movie)) return result;

        Iterator<MovieCopy> it = movieToCopies.get(movie).iterator();
        for (int i = 0; it.hasNext()&& i < 5; i++) {
            result.add(it.next().shop);
        }
        return result;
    }

    public void rent(int shop, int movie) {
        MovieCopy movieCopy = shopMovieMap.get(shop + ":" + movie);
        rentedSet.add(movieCopy);
        movieToCopies.get(movie).remove(movieCopy);
    }

    public void drop(int shop, int movie) {
        MovieCopy movieCopy = shopMovieMap.get(shop + ":" + movie);
        rentedSet.remove(movieCopy);
        movieToCopies.get(movie).add(movieCopy);
    }

    public List<List<Integer>> report() {
        List<List<Integer>> result = new ArrayList<>();
        Iterator<MovieCopy> it = rentedSet.iterator();
        for (int i = 0; it.hasNext() && i < 5; i++) {
            MovieCopy movieCopy = it.next();
            result.add(Arrays.asList(movieCopy.shop, movieCopy.movie));
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] arr = {
                {0, 1, 5},
                {0, 2, 6},
                {0, 3, 7},
                {1, 1, 4},
                {1, 2, 7},
                {2, 1, 5}
        };
        MovieRentingSystem1912 movieRentingSystem = new MovieRentingSystem1912(3, arr);
        System.out.println(movieRentingSystem.search(1));
        movieRentingSystem.rent(0, 1);
        movieRentingSystem.rent(1, 2);
        System.out.println(movieRentingSystem.report());
        movieRentingSystem.drop(1, 2);
        System.out.println(movieRentingSystem.search(2));
    }
}
