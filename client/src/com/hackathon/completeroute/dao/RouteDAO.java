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

import com.hackathon.completeroute.pojo.Route;

import java.util.List;

/**
 * Route DAO
 *
 * @author <a href="mailto:hanusto@gmail.com">Tomas Hanus</a>
 */
public interface RouteDAO {

    /**
     * @param category the category name
     * @param company the company name
     * @return the list of {@link Route} for the company
     */
    List<Route> getRoutesByCompany(String category, String company);

}
