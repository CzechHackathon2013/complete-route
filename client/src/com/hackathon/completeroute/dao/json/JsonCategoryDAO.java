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

package com.hackathon.completeroute.dao.json;

import com.hackathon.completeroute.dao.CategoryDAO;
import com.hackathon.completeroute.dao.factory.JsonDAOFactory;
import com.hackathon.completeroute.dao.json.response.CategoriesResponse;
import com.hackathon.completeroute.pojo.Category;
import org.json.JSONObject;

import java.util.List;

/**
 * JSON Category DAO for REST communication
 *
 * @author <a href="mailto:hanusto@gmail.com">Tomas Hanus</a>
 */
public class JsonCategoryDAO implements CategoryDAO {

    private final static String CONTEXT = "categories";
    private JsonDAOFactory dao = new JsonDAOFactory();

    /**
     * @return all categories
     */
    @Override
    public List<Category> getCategories() {
        JsonDomain domain = JsonDomain.getInstance();
        if (domain.getCategories() == null) {
            JSONObject json = JsonDAOFactory.get(CONTEXT);
            CategoriesResponse response = JsonDAOFactory.fromJson(json, CategoriesResponse.class);
            domain.setCategories(response.getResult());
        }
        return domain.getCategories();
    }

}
