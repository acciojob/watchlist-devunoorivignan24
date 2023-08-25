package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {
    @Autowired
    MovieService movieService;
    @PostMapping("/add-movie")
    public String addMovie(@RequestBody Movie movie){
        return movieService.addMovie(movie);
    }
    @PostMapping("/add-director")
    public String addDirector(@RequestBody Director director){
        return movieService.addDirector(director);
    }
    @PutMapping("/add-movie-director-pair")
    public String addMovieDirectorPair(@RequestParam("q") String moviename,@RequestParam("q1") String directorname){
        return movieService.addMovieDirectorPair(moviename,directorname);
    }

    @GetMapping("/get-movie-by-name/{name}")
    public Movie getMovieByName(@RequestParam("q") String name){
        return movieService.getMovieByName(name);
    }

    @GetMapping("/get-director-by-name/{name}")
    public Director getDirectorByName(@RequestParam("q") String name){
        return movieService.getDirectorByName(name);
    }

    @GetMapping("/get-movies-by-director-name/{director}")
    public List<String> getMoviesByDirectorName(@RequestParam("q") String name){
        return movieService.getMoviesByDirectorName(name);
    }
    @GetMapping("/get-all-movies")
    public List<String> findAllMovies(){
        return movieService.findAllMovies();
    }
    @DeleteMapping("/delete-director-by-name")
    public String deleteDirectorByName(@RequestParam("q") String name){
        return movieService.deleteDirectorByName(name);
    }
    @DeleteMapping("/delete-all-directors")
    public String deleteAllDirectors(){
        return movieService.deleteAllDirectors();
    }
}
