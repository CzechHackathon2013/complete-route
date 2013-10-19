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

package com.czechhackathon.completeroute.dao.mock;

import com.czechhackathon.completeroute.dao.CategoryDAO;

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
    public List<String> getCategories() {
        List<String> result = new LinkedList<>();
        result.add("Banking");
        result.add("Telecommunications");
        result.add("Services");
        result.add("Insurance");
        result.add("Government");
        return result;
    }
}
