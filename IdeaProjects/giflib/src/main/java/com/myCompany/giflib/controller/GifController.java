package com.myCompany.giflib.controller;

import com.myCompany.giflib.data.GifRepository;
import com.myCompany.giflib.model.Gif;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by yoyon on 7/18/2017.
 */
@Controller
public class GifController {
    @Autowired
    private GifRepository gr;

    @RequestMapping(value = "/")
    public String listGifs(ModelMap modelMap) {
        List<Gif> allGifs = gr.getAllGifs();
        modelMap.put("gifs", allGifs);
        return "home";
    }

    //URL => http://localhost:8080/gif/tenor
    @RequestMapping(value = "/gif/{name}")
    public String gifDetails(@PathVariable String name, ModelMap modelMap) {
        Gif gif = gr.findByName(name);
        // modelMap stores the gif file for the view to use
        modelMap.put("gif", gif);
        return "gif-details";
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String searchResults(@RequestParam("q") String query, ModelMap modelMap) {
        List<Gif> results = gr.findByUserInput(query);
        if (results.size() == 0) {
            return "home";
        }
        modelMap.put("searchResults", results);
        return "searchResult";
    }
}

