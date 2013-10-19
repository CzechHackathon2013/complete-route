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

package com.hackathon.completeroute.dao.mock;

import com.hackathon.completeroute.dao.CategoryDAO;
import com.hackathon.completeroute.pojo.Category;

import java.util.LinkedList;
import java.util.List;

/**
 * @author <a href="mailto:hanusto@gmail.com">Tomas Hanus</a>
 */
public class MockCategoryDAO implements CategoryDAO {

    /**
     * @return all categories
     */
    @Override
    public List<Category> getCategories() {
        List<Category> result = new LinkedList<>();

        Category category = new Category();
        category.setName("Banking");
        category.setId("banking");
        result.add(category);

        category = new Category();
        category.setName("Telco");
        category.setId("telco");
        result.add(category);

        category = new Category();
        category.setName("Services");
        category.setId("services");
        result.add(category);

        category = new Category();
        category.setName("Insurance");
        category.setId("insurance");
        result.add(category);

        category = new Category();
        category.setName("Government");
        category.setId("government");
        result.add(category);

        return result;
    }
}
