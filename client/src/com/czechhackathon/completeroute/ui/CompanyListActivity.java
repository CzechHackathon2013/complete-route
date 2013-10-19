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

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import com.czechhackathon.completeroute.R;
import com.czechhackathon.completeroute.ui.adapter.CategoryImageAdapter;
import com.czechhackathon.completeroute.ui.async.CompanyDataLoaderTask;
import com.czechhackathon.completeroute.ui.bar.ApplicationTitleBarActivity;

/**
 * Main activity of application - root screen
 *
 * @author <a href="mailto:hanusto@gmail.com">Tomas Hanus</a>
 */
public class CompanyListActivity extends ApplicationTitleBarActivity {

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

        setContentView(R.layout.company_list);

        // get intent data
        Intent i = getIntent();

        // Selected image id

        CompanyDataLoaderTask companyDataLoader = new CompanyDataLoaderTask(this);
        companyDataLoader.execute(savedInstanceState);

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            destroyThis();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    protected void destroyThis() {
        super.onDestroy();

	    /*
         * Notify the system to finalize and collect all objects of the
	     * application on exit so that the process running the application can
	     * be killed by the system without causing issues. NOTE: If this is set
	     * to true then the process will not be killed until all of its threads
	     * have closed.
	     */
        System.runFinalization();

	    /*
         * Force the system to close the application down completely instead of
	     * retaining it in the background. The process that runs the application
	     * will be killed. The application will be completely created as a new
	     * application in a new process if the user starts the application
	     * again.
	     */
        System.exit(0);
    }


}