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

package com.hackathon.completeroute.ui.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import com.hackathon.completeroute.R;
import com.hackathon.completeroute.pojo.Company;
import com.hackathon.completeroute.ui.CompleteRouteApplication;
import com.hackathon.completeroute.ui.activity.bar.ApplicationTitleBarActivity;
import com.hackathon.completeroute.ui.adapter.RouteItemAdapter;
import com.hackathon.completeroute.ui.adapter.provider.KeyResourceProvider;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:hanusto@gmail.com">Tomas Hanus</a>
 */
public class RouteWizardActivity extends ApplicationTitleBarActivity {

    private static List<ImageView> selectedRoutes = new ArrayList<>();
    private static Company company;
    private ImageView routekey1;
    private ImageView routekey2;
    private ImageView routekey3;
    private ImageView routekey4;
    private ImageView dialRoute;
    private CompleteRouteApplication app;

    public CompleteRouteApplication getApplicationContext() {
        return app;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        /** Called when the activity is first created. */
        super.onCreate(savedInstanceState);

        // get "Application" object for shared state or creating of expensive
        // resources - like DataHelper
        // (this is not recreated as often as each Activity)
        this.app = (CompleteRouteApplication) this.getApplication();

        // Selected route
        company = (Company) getIntent().getSerializableExtra(Company.class.getSimpleName());

        initUi(savedInstanceState);

    }

    /**
     * Set route key to pipe line
     *
     * @param routeKey the selected key
     */
    public void setRouteKey(Integer routeKey) {

        int routeCount = selectedRoutes.size();

        //TODO clear all
        if (routeCount>3) {
            for(ImageView iv : selectedRoutes) {
                iv.setImageResource(R.drawable.square_dashed_rounded_128);
            }
            selectedRoutes.clear();
            routeCount = 0;
        }

        switch (routeCount) {
            case 0:
                routekey1.setImageResource(KeyResourceProvider.getKeyResource(routeKey));
                selectedRoutes.add(routekey1);
                break;
            case 1:
                routekey2.setImageResource(KeyResourceProvider.getKeyResource(routeKey));
                selectedRoutes.add(routekey2);
                break;
            case 2:
                routekey3.setImageResource(KeyResourceProvider.getKeyResource(routeKey));
                selectedRoutes.add(routekey3);
                break;
            case 3:
                routekey4.setImageResource(KeyResourceProvider.getKeyResource(routeKey));
                selectedRoutes.add(routekey4);
                break;
            default:
                throw new RuntimeException("Not implemented");
        }

    }

    /**
     * initialization of ui
     */
    private void initUi(Bundle savedInstanceState) {

        setContentView(R.layout.route_wizard_layout);

        routekey1 = (ImageView) this.findViewById(R.id.routekey1);
        routekey2 = (ImageView) this.findViewById(R.id.routekey2);
        routekey3 = (ImageView) this.findViewById(R.id.routekey3);
        routekey4 = (ImageView) this.findViewById(R.id.routekey4);
        dialRoute = (ImageView) this.findViewById(R.id.dialRoute);

        dialRoute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + company.getPhone()));
                startActivity(intent);

            }
        });

        ListView lv = (ListView) this.findViewById(R.id.route_list);
        lv.setAdapter(new RouteItemAdapter(this, company.getRoutes()));


    }
}
