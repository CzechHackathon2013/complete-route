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

package com.czechhackathon.completeroute.ui;

import android.os.Bundle;
import com.czechhackathon.completeroute.R;
import com.czechhackathon.completeroute.ui.async.CategoryDataLoaderTask;
import com.czechhackathon.completeroute.ui.bar.ApplicationTitleBarActivity;

/**
 * @author <a href="mailto:hanusto@gmail.com">Tomas Hanus</a>
 */
public class CategoryGridActivity extends ApplicationTitleBarActivity {

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

        initUi(savedInstanceState);

    }

    /**
     * initialization of ui
     */
    private void initUi(Bundle savedInstanceState) {

        setContentView(R.layout.category_grid);

        CategoryDataLoaderTask categoryDataLoader = new CategoryDataLoaderTask(this);
        categoryDataLoader.execute(savedInstanceState);

    }

}
