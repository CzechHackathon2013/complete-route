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
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.hackathon.completeroute.R;
import com.hackathon.completeroute.dao.CompanyDAO;
import com.hackathon.completeroute.dao.factory.DAOFactory;
import com.hackathon.completeroute.pojo.Company;
import com.hackathon.completeroute.ui.activity.RouteWizardActivity;
import com.hackathon.completeroute.ui.adapter.CompanyImageAdapter;

/**
 * @author <a href="mailto:hanusto@gmail.com">Tomas Hanus</a>
 */
public class CompanyDataLoaderTask extends AsyncTask<Bundle, Void, Company> {

    private Activity activity;
    private TextView tvCallNumber;
    private Company company;

    /**
     * Default constructor for loader of list of companies
     *
     * @param activity the parent activity
     */
    public CompanyDataLoaderTask(Activity activity) {
        this.activity = activity;
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
    protected Company doInBackground(Bundle... params) {

        // Create the required DAO Factory
        DAOFactory dao = DAOFactory.getDefaultDAOFactory();

        // Create a DAO
        CompanyDAO companyDAO = dao.getCompanyDAO();
        String companyName = params[0].getString(Company.NAME);

        company = companyDAO.getCompanyByName(companyName);
        return company;

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
    protected void onPostExecute(final Company company) {

        ImageView ivCompanyLogo = (ImageView)activity.findViewById(R.id.ivCompanyLogo);
        TextView tvCompanyName = (TextView) activity.findViewById(R.id.tvCompanyName);
        TextView tvDescription = (TextView) activity.findViewById(R.id.tvDescription);
        TextView tvCategory = (TextView) activity.findViewById(R.id.tvCategory);

        ivCompanyLogo.setImageResource(CompanyImageAdapter.getThumbs().get(company.getIcon()));
        tvCompanyName.setText(company.getName());
        tvDescription.setText(company.getDescription());
        tvCategory.setText(company.getCategory());

        tvCallNumber = (TextView) activity.findViewById(R.id.tvCallNumber);
        tvCallNumber.setText(company.getPhone());

        ImageView ivCall = (ImageView) activity.findViewById(R.id.route_item_ivCallNumberIcon);
        ivCall.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + tvCallNumber.getText()));
                activity.startActivity(intent);

            }

        });

        ImageView ivRouteWizard = (ImageView) activity.findViewById(R.id.route_item_ivRouteWizardIcon);
        ivRouteWizard.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(activity.getApplicationContext(), RouteWizardActivity.class);
                intent.putExtra(Company.class.getSimpleName(), company);
                activity.startActivity(intent);

            }
        });

    }
}
