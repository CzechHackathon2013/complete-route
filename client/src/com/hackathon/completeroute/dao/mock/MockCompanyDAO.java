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

import com.hackathon.completeroute.dao.CompanyDAO;
import com.hackathon.completeroute.pojo.Category;
import com.hackathon.completeroute.pojo.Company;

import java.util.*;

/**
 * @author <a href="mailto:hanusto@gmail.com">Tomas Hanus</a>
 */
public class MockCompanyDAO implements CompanyDAO {

    /**
     * @return {@link com.hackathon.completeroute.pojo.Company} by name.
     */
    @Override
    public Company getCompanyByName(String name) {
        List<Category> categories = MockDB.getInstance().getCategories();
        for (Category cat: categories) {
            List<Company> companies = cat.getCompanies();
            if (companies != null && !companies.isEmpty()) {
                for (Company comp : companies) {
                    if (comp.getName().equals(name))
                        return comp;
                }
            }
        }
        return null;
    }

    /**
     * @param category category
     * @return all {@link com.hackathon.completeroute.pojo.Company} in the specific category
     */
    @Override
    public List<Company> getCompaniesByCategory(String category) {
        List<Category> categories = MockDB.getInstance().getCategories();
        for (Category cat: categories) {
            if (cat.getName().equals(category)) {
                return cat.getCompanies();
            }
        }
        return Collections.emptyList();
    }
}
