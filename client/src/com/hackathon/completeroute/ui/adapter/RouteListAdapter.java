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
import android.widget.TextView;
import com.hackathon.completeroute.R;
import com.hackathon.completeroute.pojo.Route;

import java.util.AbstractList;

/**
 * @author <a href="mailto:hanusto@gmail.com">Tomas Hanus</a>
 */
public class RouteListAdapter extends ArrayAdapter<Route> {

    private AbstractList<Route> routes;
    private Activity mActivity;

    /**
     * Default constructor
     *
     * @param context            the context
     * @param textViewResourceId the if of view
     * @param objects            the objects
     */
    public RouteListAdapter(Activity a, Context context, int textViewResourceId,
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
            v = vi.inflate(R.layout.route_item_layout, null);
        }

        Route route = this.routes.get(position);

        TextView tvName = (TextView) v.findViewById(R.id.tvRouteName);
        TextView tvNumberId = (TextView) v.findViewById(R.id.tvRouteId);
        TextView tvDescription = (TextView) v.findViewById(R.id.tvRouteDesc);

        v.setClickable(true);
        v.setFocusable(true);

        tvName.setText(route.getDescription());
        tvNumberId.setText(String.valueOf(route.getKeypad()));
        tvDescription.setText(route.getDescription());

        return v;

    }


}
