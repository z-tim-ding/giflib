package com.myCompany.giflib.data;

import com.myCompany.giflib.model.Category;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * Created by yoyon on 7/20/2017.
 */
@Component
public class CategoryRepository {
    private static final List<Category> ALL_CATEGORIES = Arrays.asList(
            new Category(1, "people"),
            new Category(2, "stuff"),
            new Category(3, "funny"),
            new Category(4, "soccer"),
            new Category(5, "other")
    );

    public List<Category> getAllCategories() {
        return ALL_CATEGORIES;
    }

    public Category findById(int id) {
        for (Category c : ALL_CATEGORIES) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }
}
