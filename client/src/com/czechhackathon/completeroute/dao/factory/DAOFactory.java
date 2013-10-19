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

/**
 * DAO Factory
 *
 * @author <a href="mailto:hanusto@gmail.com">Tomas Hanus</a>
 */
public abstract class DAOFactory {

    // List of DAO types supported by the factory
    public static final int JSON = 1;
    // Default DAO factory
    public static final int DEFAULT_FACTORY = JSON;

    public static DAOFactory getDAOFactory(
            int whichFactory) {

        switch (whichFactory) {
            case JSON:
                return new JsonDAOFactory();
            default:
                return null;
        }
    }

    public static DAOFactory getDefaultDAOFactory() {

        switch (DEFAULT_FACTORY) {
            case JSON:
                return new JsonDAOFactory();
            default:
                return null;
        }
    }

    // There will be a method for each DAO that can be
    // created. The concrete factories will have to
    // implement these methods.
    public abstract CategoryDAO getCategoryDAO();

    public abstract CompanyDAO getCompanyDAO();

    public abstract RouteDAO getRouteDAO();

}
