/*
 * Copyright [2013] [CzechHackathon@hostovo]
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.hackathon.completeroute.dao.json.response;

import com.hackathon.completeroute.pojo.Category;

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
