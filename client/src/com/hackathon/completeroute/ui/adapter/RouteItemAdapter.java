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

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.hackathon.completeroute.R;
import com.hackathon.completeroute.pojo.Route;
import com.hackathon.completeroute.ui.activity.RouteWizardActivity;
import com.hackathon.completeroute.ui.adapter.provider.KeyResourceProvider;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author <a href="mailto:hanusto@gmail.com">Tomas Hanus</a>
 */
public class RouteItemAdapter extends BaseAdapter {

    private static Map<ImageView, Integer> ivContainer = new HashMap<>();

    private List<Route> routes;
    private RouteWizardActivity activity;

    public RouteItemAdapter(RouteWizardActivity activity, List<Route> routes) {
        this.activity = activity;
        this.routes = routes;
    }

    public int getCount() {
        return routes.size();
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    /**
     * Get a View that displays the data at the specified position in the data set. You can either
     * create a View manually or inflate it from an XML layout file. When the View is inflated, the
     * parent View (GridView, ListView...) will apply default layout parameters unless you use
     * {@link android.view.LayoutInflater#inflate(int, android.view.ViewGroup, boolean)}
     * to specify a root view and to prevent attachment to the root.
     *
     * @param position    The position of the item within the adapter's data set of the item whose view
     *                    we want.
     * @param convertView The old view to reuse, if possible. Note: You should check that this view
     *                    is non-null and of an appropriate type before using. If it is not possible to convert
     *                    this view to display the correct data, this method can create a new view.
     *                    Heterogeneous lists can specify their number of view types, so that this View is
     *                    always of the right type (see {@link #getViewTypeCount()} and
     *                    {@link #getItemViewType(int)}).
     * @param parent      The parent that this view will eventually be attached to
     * @return A View corresponding to the data at the specified position.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view;
        TextView iconText;
        ImageView iconImage;


        if (convertView == null) {
            LayoutInflater li = activity.getLayoutInflater();
            view = li.inflate(R.layout.route_item_layout, null);
        } else {
            view = convertView;
        }

        iconText = (TextView) view.findViewById(R.id.route_item_desc);
        iconText.setText(routes.get(position).getDescription());
        iconImage = (ImageView) view.findViewById(R.id.routekey_item_icon);
        iconImage.setImageResource(KeyResourceProvider.getKeyResource(routes.get(position).getKeypad()));

        ivContainer.put(iconImage, routes.get(position).getKeypad());

        iconImage.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                ImageView iconImage = (ImageView) v.findViewById(R.id.routekey_item_icon);
                Integer routeKey = ivContainer.get(iconImage);
                activity.setRouteKey(routeKey);

            }
        });

        return view;
    }
}
