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

package com.czechhackathon.completeroute.dao.factory;

import com.czechhackathon.completeroute.dao.CategoryDAO;
import com.czechhackathon.completeroute.dao.CompanyDAO;
import com.czechhackathon.completeroute.dao.RouteDAO;
import com.czechhackathon.completeroute.dao.mock.MockCategoryDAO;
import com.czechhackathon.completeroute.dao.mock.MockCompanyDAO;
import com.czechhackathon.completeroute.dao.mock.MockRouteDAO;

/**
 * @author <a href="mailto:hanusto@gmail.com">Tomas Hanus</a>
 */
public class MockDAOFactory extends DAOFactory {

    @Override
    public CategoryDAO getCategoryDAO() {
        return new MockCategoryDAO();
    }

    @Override
    public CompanyDAO getCompanyDAO() {
        return new MockCompanyDAO();
    }

    @Override
    public RouteDAO getRouteDAO() {
        return new MockRouteDAO();
    }
}
