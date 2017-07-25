package com.myCompany.giflib.data;

import com.myCompany.giflib.model.Category;
import com.myCompany.giflib.model.Gif;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.*;

/**
 * Created by yoyon on 7/19/2017.
 */
@Component
public class GifRepository {
    private static final List<Gif> ALL_GIFS = Arrays.asList(
        new Gif("android-explosion", 1, LocalDate.of(2015,2,13), "Chris Ramacciotti", false),
        new Gif("ben-and-mike", 2, LocalDate.of(2015,10,30), "Ben Jakuben", true),
        new Gif("book-dominos", 3, LocalDate.of(2015,9,15), "Craig Dennis", false),
        new Gif("compiler-bot", 1, LocalDate.of(2015,2,13), "Ada Lovelace", true),
        new Gif("cowboy-coder", 2, LocalDate.of(2015,2,13), "Grace Hopper", false),
        new Gif("infinite-andrew", 3, LocalDate.of(2015,8,23), "Marissa Mayer", true),
        new Gif("tenor", 1, LocalDate.of(2017,7,19), "Tim Ding", true)
    );

    public Gif findByName(String name) {
        for(Gif gif : ALL_GIFS) {
            if (gif.getName().equals(name)) {
                return gif;
            }
        }
        return null;
    }

    public List<Gif> getAllGifs() {
        return ALL_GIFS;
    }

    public List<Gif> findByCategoryId(int id) {
        List<Gif> sameCatGifs = new ArrayList<>();
        for(Gif gif : ALL_GIFS) {
            if (gif.getCategoryId() == id) {
                sameCatGifs.add(gif);
            }
        }
        return sameCatGifs;
    }

    public List<Gif> getFavorites() {
        List<Gif> faves = new ArrayList<Gif>();
        for (Gif gif : ALL_GIFS) {
            if (gif.isFavorite()) {
                faves.add(gif);
            }
        }
        return faves;
    }

    public List<Gif> findByUserInput(String query) {
        List<Gif> results = new ArrayList<>();
        for (Gif gif : ALL_GIFS) {
            if (gif.getName().contains(query)) {
                results.add(gif);
            }
        }
        return results;
    }
}
