package com.myCompany.giflib.controller;

import com.myCompany.giflib.data.GifRepository;
import com.myCompany.giflib.model.Gif;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by yoyon on 7/23/2017.
 */
@Controller
public class FavoriteController {
    @Autowired
    private GifRepository gr;

    @RequestMapping(value="/favorites")
    public String listFavorites(ModelMap modelMap) {
        List<Gif> faves = gr.getFavorites();
        modelMap.put("favorites", faves);
        return "favorites";
    }
}
