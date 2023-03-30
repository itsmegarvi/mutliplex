package com.example.bookingservice.controller;

import com.example.bookingservice.dto.MovieDto;
import com.example.bookingservice.model.Movie;
import com.example.bookingservice.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/movie")
public class MovieController {
    final
    MovieService movieService;

    public static final String msg = "message";

    @PostMapping("/add")
    public ResponseEntity<Map<String,String>> addMovie(@RequestBody MovieDto moviedto){
        String response =movieService.addMovie(moviedto);
        Map<String, String> map = Map.of(msg, response);
        return ResponseEntity.ok(map);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Map<String,String>> updateMovie(@RequestBody MovieDto movieDto,@PathVariable("id") Long id){
        Map<String, String> map = Map.of(msg, movieService.updateMovie(movieDto, id));
        return new ResponseEntity<>(map, HttpStatusCode.valueOf(201));
    }

    @GetMapping("/get/movie/{name}")
    public ResponseEntity<MovieDto> getMovie(@PathVariable("name") String name){
        return ResponseEntity.ok(movieService.getMovie(name));
    }

    @GetMapping("/get/movies")
    public ResponseEntity<List<Movie>> getAllMovies(){
        return ResponseEntity.ok(movieService.getAllMovies());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map<String ,String>> deleteMovie(@PathVariable("id") Long id){
        Map<String,String> map = Map.of(msg,movieService.deleteMovie(id));
        return new ResponseEntity<>(map,HttpStatusCode.valueOf(200));
    }
}
