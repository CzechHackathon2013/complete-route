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

package com.hackathon.completeroute.ui.async;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ListView;
import com.hackathon.completeroute.R;
import com.hackathon.completeroute.dao.CompanyDAO;
import com.hackathon.completeroute.dao.factory.DAOFactory;
import com.hackathon.completeroute.pojo.Category;
import com.hackathon.completeroute.pojo.Company;
import com.hackathon.completeroute.ui.adapter.CompanyListAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:hanusto@gmail.com">Tomas Hanus</a>
 */
public class CompanyDataLoaderTask extends AsyncTask<Bundle, Void, List<Company>> {

    private Context c;
    private Activity activity;

    /**
     * Default constructor for loader of list of companies
     *
     * @param activity the parent activity
     */
    public CompanyDataLoaderTask(Activity activity) {
        this.activity = activity;
        this.c = activity.getApplicationContext();
    }

    /**
     * Override this method to perform a computation on a background thread. The
     * specified parameters are the parameters passed to {@link #execute}
     * by the caller of this task.
     * <p/>
     * This method can call {@link #publishProgress} to publish updates
     * on the UI thread.
     *
     * @param params The parameters of the task.
     * @return A result, defined by the subclass of this task.
     * @see #onPreExecute()
     * @see #onPostExecute
     * @see #publishProgress
     */
    @Override
    protected List<Company> doInBackground(Bundle... params) {

        // Create the required DAO Factory
        DAOFactory dao = DAOFactory.getDefaultDAOFactory();

        // Create a DAO
        CompanyDAO companyDAO = dao.getCompanyDAO();

        String category = params[0].getString(Category.NAME);

        return companyDAO.getCompaniesByCategory(category);
    }

    /**
     * <p>Runs on the UI thread after {@link #doInBackground}. The
     * specified result is the value returned by {@link #doInBackground}.</p>
     * <p/>
     * <p>This method won't be invoked if the task was cancelled.</p>
     *
     * @see #onPreExecute
     * @see #doInBackground
     * @see #onCancelled(Object)
     */
    @Override
    protected void onPostExecute(List<Company> companies) {

        ArrayList<Company> result = new ArrayList<>(companies);

        ListView lv;

        lv = (ListView) activity.findViewById(R.id.lvCompany);
        lv.setAdapter(new CompanyListAdapter(c,
                R.id.lvDeparture, result));

    }
}
