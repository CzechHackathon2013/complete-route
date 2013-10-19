package com.czechhackathon.completeroute.dao.json.response;

import com.czechhackathon.completeroute.pojo.Category;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Michal Dojcar
 */
public class CategoriesResponse {

    private CategoryResponse[] result;

    public List<Category> getResult() {
        List<Category> categories = new LinkedList<>();
        for (CategoryResponse c : result) {
            categories.add(new Category(c._id, c._id));
        }
        return categories;
    }

    private CategoriesResponse(CategoryResponse[] result) {
        this.result = result;
    }

    private static class CategoryResponse {
        private String _id;
        private CategoryResponse(String _id) {
            this._id = _id;
        }
    }
}
