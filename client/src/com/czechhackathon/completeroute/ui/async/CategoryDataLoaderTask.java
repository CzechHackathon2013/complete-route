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

package com.czechhackathon.completeroute.ui.async;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;
import com.czechhackathon.completeroute.R;
import com.czechhackathon.completeroute.dao.CategoryDAO;
import com.czechhackathon.completeroute.dao.factory.DAOFactory;
import com.czechhackathon.completeroute.pojo.Category;
import com.czechhackathon.completeroute.ui.adapter.CategoryImageAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:hanusto@gmail.com">Tomas Hanus</a>
 */
public class CategoryDataLoaderTask extends AsyncTask<Bundle, Void, List<Category>> {

    private Context c;
    private Activity activity;

    /**
     * Default constructor for loader of list of companies
     *
     * @param activity the parent activity
     */
    public CategoryDataLoaderTask(Activity activity) {
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
    protected List<Category> doInBackground(Bundle... params) {
        // Create the required DAO Factory
        DAOFactory dao = DAOFactory.getDefaultDAOFactory();

        // Create a DAO
        CategoryDAO categoryDAO = dao.getCategoryDAO();

        return categoryDAO.getCategories();
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
    protected void onPostExecute(List<Category> categories) {

        GridView gridview = (GridView) activity.findViewById(R.id.category_grid);

        gridview.setAdapter(new CategoryImageAdapter(c, categories));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Toast.makeText(c, "Create new item to get to new screen with companies: " + position,
                        Toast.LENGTH_SHORT).show();
            }
        });

    }
}
