/**
 * 
 */
package com.exampledemo.microservices.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exampledemo.microservices.model.Rating;
import com.exampledemo.microservices.model.UserRating;

/**
 * @author bhuwangautam
 *
 */

@RestController
@RequestMapping("/ratings")
public class MovieRatingController {

    @GetMapping("{movieId}")
    public Rating getRating(@PathVariable String movieId) {
        System.out.println("movieId: " + movieId);
        return new Rating(movieId, 4);
    }

    @GetMapping("/users/{userId}")
    public UserRating getUserRatings(@PathVariable String userId) {
        System.out.println("UserId: " + userId);

        List<Rating> ratings = Arrays.asList(new Rating("titanic", 4), new Rating("gozilla", 3));
        UserRating userRating = new UserRating();
        userRating.setUserRatings(ratings);

        return userRating;
    }

}
