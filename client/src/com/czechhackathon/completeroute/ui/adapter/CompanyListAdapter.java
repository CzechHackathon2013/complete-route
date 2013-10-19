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

package com.czechhackathon.completeroute.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.czechhackathon.completeroute.R;
import com.czechhackathon.completeroute.pojo.Company;

import java.util.ArrayList;

/**
 * @author <a href="mailto:hanusto@gmail.com">Tomas Hanus</a>
 */
public class CompanyListAdapter extends ArrayAdapter<Company> {

    private ArrayList<Company> companies;
    private TextView tvCompanyName;
    private TextView tvDescription;
    private TextView tvCategory;

    /**
     * Default constructor
     *
     * @param context            the context
     * @param textViewResourceId the if of view
     * @param objects            the objects
     */
    public CompanyListAdapter(Context context, int textViewResourceId,
                              ArrayList<Company> objects) {
        super(context, textViewResourceId, objects);
        this.companies = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;
        if (v == null) {
            LayoutInflater vi = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            v = vi.inflate(R.layout.company_item_layout, null);
        }

        Company company = this.companies.get(position);

        tvCompanyName = (TextView) v.findViewById(R.id.tvCompanyName);
        tvDescription = (TextView) v.findViewById(R.id.tvDescription);
        tvCategory = (TextView) v.findViewById(R.id.tvCategory);

        v.setClickable(true);
        v.setFocusable(true);

        tvCompanyName.setText(company.getName());
        tvDescription.setText(company.getDescription());
        tvCategory.setText(company.getCategory());

        return v;

    }


}
