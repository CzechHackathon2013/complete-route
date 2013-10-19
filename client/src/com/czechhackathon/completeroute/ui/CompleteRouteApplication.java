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

import android.app.Application;
import android.util.Log;

/**
 * Main runner of application
 *
 * @author <a href="mailto:hanusto@gmail.com">Tomas Hanus</a>
 */
public class CompleteRouteApplication extends Application {

    public static final String APP_NAME = CompleteRouteApplication.class.getSimpleName();

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(APP_NAME, "APPLICATION onCreate");
    }

    @Override
    public void onTerminate() {
        Log.d(APP_NAME, "APPLICATION onTerminate");
        super.onTerminate();
    }

}
