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
import com.hackathon.completeroute.pojo.Company;
import com.hackathon.completeroute.pojo.Route;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author <a href="mailto:hanusto@gmail.com">Tomas Hanus</a>
 */
public class MockCompanyDAO implements CompanyDAO {

    private static Company company;

    static {
        company = new Company();
        company.setCategory("Telco");
        company.setDescription("Description");
        company.setId("O2");
        company.setName("O2");

        List<Route> routes = new LinkedList<>();
        Route route = new Route();
        route.setCompany(company);
        route.setName("Invoice");
        route.setDescription("Invoice");
        route.setKeypad(153);
        routes.add(route);

        company.setRoutes(routes);
    }

    /**
     * @return {@link com.hackathon.completeroute.pojo.Company} by id.
     */
    @Override
    public Company getCompanyById(String id) {
        return company;
    }

    /**
     * @return {@link com.hackathon.completeroute.pojo.Company} by name.
     */
    @Override
    public Company getCompanyByName(String name) {
        return company;
    }

    /**
     * @return all {@link com.hackathon.completeroute.pojo.Company}
     */
    @Override
    public List<Company> getCompanies() {
        return new ArrayList<>(Arrays.asList(company));
    }

    /**
     * @param category category
     * @return all {@link com.hackathon.completeroute.pojo.Company} in the specific category
     */
    @Override
    public List<Company> getCompaniesByCategory(String category) {
        List<Company> result = new ArrayList<>();
        if (category.equalsIgnoreCase("Telco")) {
            result = new ArrayList<>(Arrays.asList(company));
        }
        return result;
    }
}
