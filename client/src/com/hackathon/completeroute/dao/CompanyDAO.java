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

package com.hackathon.completeroute.dao;

import com.hackathon.completeroute.pojo.Category;
import com.hackathon.completeroute.pojo.Company;

import java.util.List;

/**
 * Company DAO
 *
 * @author <a href="mailto:hanusto@gmail.com">Tomas Hanus</a>
 */
public interface CompanyDAO {

    /**
     * @return {@link Company} by name.
     */
    Company getCompanyByName(String name);

    /**
     * @param category category
     * @return all {@link Company} in the specific category
     */
    List<Company> getCompaniesByCategory(String category);

}
