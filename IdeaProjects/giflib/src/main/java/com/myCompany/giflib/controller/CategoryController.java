package com.myCompany.giflib.controller;

import com.myCompany.giflib.data.CategoryRepository;
import com.myCompany.giflib.data.GifRepository;
import com.myCompany.giflib.model.Category;
import com.myCompany.giflib.model.Gif;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by yoyon on 7/20/2017.
 */
@Controller
public class CategoryController {
    @Autowired
    private CategoryRepository all_cat;

    @Autowired
    private GifRepository gifRepository;

    @RequestMapping(value = "/categories")
    public String listCategory(ModelMap modelMap) {
        List<Category> categories = all_cat.getAllCategories();
        modelMap.put("Categories", categories);
        return "categories";
    }

    @RequestMapping(value = "/category/{id}")
    public String category(@PathVariable int id, ModelMap modelMap) {
        Category cat = all_cat.findById(id);
        modelMap.put("Category", cat);

        List<Gif> gifs = gifRepository.findByCategoryId(id);
        modelMap.put("gifs", gifs);
        return "category";
    }
}
