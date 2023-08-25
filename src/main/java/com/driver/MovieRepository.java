package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

@Repository
public class MovieRepository {
    private HashMap<String,Movie> movieMap;
    private HashMap<String,Director> directorMap;
    private HashMap<String,List<String>> directorMovieMap;

    public MovieRepository() {
        this.movieMap=new HashMap<String,Movie>();
        this.directorMap=new HashMap<String,Director>();
        this.directorMovieMap=new HashMap<String, List<String>>();
    }

    public String addMovie(Movie movie) {
        movieMap.put(movie.getName(),movie);
        return "success";
    }

    public String addDirector(Director director) {
        directorMap.put(director.getName(),director);
        return "success";
    }

    public String addMovieDirectorPair(String moviename, String directorname) {
        if(movieMap.containsKey(moviename) && directorMap.containsKey(directorname)){
            movieMap.put(moviename,movieMap.get(moviename));
            directorMap.put(directorname,directorMap.get(directorname));
            List<String> currentMovies=new ArrayList<>();
            if(directorMovieMap.containsKey(directorname))
                currentMovies=directorMovieMap.get(directorname);
                currentMovies.add(moviename);
                directorMovieMap.put(directorname,currentMovies);

        }
        return "success";
    }

    public Movie getMovieByName(String name) {
        return movieMap.get(name);
    }

    public Director getDirectorByName(String name) {
        return directorMap.get(name);
    }

    public List<String> getMoviesByDirectorName(String name) {
        List<String> arr=new ArrayList<>();
        if(directorMovieMap.containsKey(name))
          arr=directorMovieMap.get(name);
        return arr;
    }

    public List<String> findAllMovies() {
        return new ArrayList<>(movieMap.keySet());
    }

    public String deleteDirectorByName(String name) {
        if(directorMovieMap.containsKey(name)){
            List<String> movies=directorMovieMap.get(name);
            for(String movie:movies){
                movieMap.remove(movie);
            }
            directorMovieMap.remove(name);
        }
        if(directorMap.containsKey(name))directorMap.remove(name);
        return "success";
    }

    public String deleteAllDirectors() {
        HashSet<String> movieSet=new HashSet<>();
        for(String director:directorMovieMap.keySet()){
            for(String movie:directorMovieMap.get(director)){
                movieSet.add(movie);
            }
        }
        for(String movie:movieSet){
            movieMap.remove(movie);
        }
        return "success";
    }
}
