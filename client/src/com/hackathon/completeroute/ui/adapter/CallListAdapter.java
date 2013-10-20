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

package com.hackathon.completeroute.ui.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.hackathon.completeroute.R;
import com.hackathon.completeroute.pojo.Route;

import java.util.AbstractList;

/**
 * @author <a href="mailto:hanusto@gmail.com">Tomas Hanus</a>
 */
public class CallListAdapter extends ArrayAdapter<Route> {

    private AbstractList<Route> routes;
    private Activity mActivity;

    /**
     * Default constructor
     *
     * @param context            the context
     * @param textViewResourceId the if of view
     * @param objects            the objects
     */
    public CallListAdapter(Activity a, Context context, int textViewResourceId,
                           AbstractList<Route> objects) {
        super(context, textViewResourceId, objects);
        this.routes = objects;
        mActivity = a;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;
        if (v == null) {
            LayoutInflater vi = mActivity.getLayoutInflater();
            v = vi.inflate(R.layout.callnumber_item_layout, null);
        }

        Route route = this.routes.get(position);

        TextView tvCallNumber = (TextView) v.findViewById(R.id.tvCallNumber);
        tvCallNumber.setText(route.getCompany().getPhone());

        ImageView ivCall = (ImageView) v.findViewById(R.id.route_item_ivCallNumberIcon);
        ivCall.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

            }

        });

        ImageView ivRouteWizard = (ImageView) v.findViewById(R.id.route_item_ivRouteWizardIcon);
        ivRouteWizard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

/*        v.setClickable(true);
        v.setFocusable(true);*/


        <<<<<<<HEAD:
        client / src / com / hackathon / completeroute / ui / adapter / CallListAdapter.java
                =======
        tvName.setText(route.getDescription());
        tvNumberId.setText(String.valueOf(route.getKeypad()));
        tvDescription.setText(route.getDescription());
        >>>>>>>2 ad23e5dfddd0d7c8df35819941ba274cd32d662:
        client / src / com / hackathon / completeroute / ui / adapter / RouteListAdapter.java

        return v;

    }


}
