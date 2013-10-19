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

import com.google.gson.reflect.TypeToken;
import com.hackathon.completeroute.dao.CompanyDAO;
import com.hackathon.completeroute.dao.factory.JsonDAOFactory;
import com.hackathon.completeroute.pojo.Company;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * JSON Company DAO for REST communication
 *
 * @author <a href="mailto:hanusto@gmail.com">Tomas Hanus</a>
 */
public class JsonCompanyDAO implements CompanyDAO {

    private final static String CONTEXT = "/categories";
    private JsonDAOFactory dao = new JsonDAOFactory();

    /**
     * @return {@link com.hackathon.completeroute.pojo.Company} by id.
     */
    @Override
    public Company getCompanyById(String id) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    /**
     * @return {@link com.hackathon.completeroute.pojo.Company} by name.
     */
    @Override
    public Company getCompanyByName(String name) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    /**
     * @return all {@link com.hackathon.completeroute.pojo.Company}
     */
    @Override
    public List<Company> getCompanies() {

        Type listType = new TypeToken<ArrayList<Company>>() {
        }.getType();

        JSONObject json = JsonDAOFactory.get(CONTEXT);
        return JsonDAOFactory.fromJson(json, listType);

    }

    /**
     * @param category category
     * @return all {@link com.hackathon.completeroute.pojo.Company} in the specific category
     */
    @Override
    public List<Company> getCompaniesByCategory(String category) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

}
