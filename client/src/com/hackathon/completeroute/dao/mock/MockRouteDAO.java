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

import com.hackathon.completeroute.dao.RouteDAO;
import com.hackathon.completeroute.pojo.Company;
import com.hackathon.completeroute.pojo.Route;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author <a href="mailto:hanusto@gmail.com">Tomas Hanus</a>
 */
public class MockRouteDAO implements RouteDAO {

    private static Route route;

    static {
        Company company = new Company();
        company.setDescription("Description");
        company.setName("O2");
        company.setPhone("906112567");
        company.setCategory("telco");

        route = new Route();
//        route.setCompany(company);
//        route.setName("Invoice");
        route.setDescription("Invoice");
        route.setKeypad(153);
    }

    /**
     * @param company the company name
     * @return the list of {@link com.hackathon.completeroute.pojo.Route} for the company
     */
    @Override
    public List<Route> getRoutesByCompany(String category, String company) {
        return new ArrayList<>(Arrays.asList(route));
    }
}
