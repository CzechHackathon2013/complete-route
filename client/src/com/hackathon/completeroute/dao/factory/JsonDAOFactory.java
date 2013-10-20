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

package com.hackathon.completeroute.dao.factory;

import android.util.Log;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hackathon.completeroute.dao.CategoryDAO;
import com.hackathon.completeroute.dao.CompanyDAO;
import com.hackathon.completeroute.dao.json.JsonCategoryDAO;
import com.hackathon.completeroute.dao.json.JsonCompanyDAO;
import com.hackathon.completeroute.dao.json.JsonDAOConfiguration;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.Type;

/**
 * JSON DAO Factory for REST communication
 *
 * @author <a href="mailto:hanusto@gmail.com">Tomas Hanus</a>
 */
public class JsonDAOFactory extends DAOFactory {

    private final static String SERVICE = JsonDAOConfiguration.SERVER_URI_DURING_ANDROID_EMULATION;
    private final static String SERVICE_CONTEXT = SERVICE + "/completeroute/";
    private static HttpClient client = null;
    private static Gson gson = null;
    private GsonBuilder gsonBuilder = null;

    /**
     * Default constructor for JSON DAO Factory that holds HttpClient as main_layout source
     */
    public JsonDAOFactory() {
        createConnection();
        gsonBuilder = new GsonBuilder();
        gson = gsonBuilder.create();
    }

    public static JSONObject get(String url) {
        HttpGet get = new HttpGet(SERVICE_CONTEXT + url);
        JSONObject result = null;

        try {
            String res = getResponse(client.execute(get));
            result = new JSONObject(res);
        } catch (IOException e) {
            Log.e(JsonDAOFactory.class.getSimpleName(), "Problem with connection to server " + SERVICE, e);
        } catch (JSONException e) {
            Log.e(JsonDAOFactory.class.getSimpleName(), "Problem with deserialization of message from server " +
                    SERVICE, e);
        } catch (Exception e) {
            Log.e(JsonDAOFactory.class.getSimpleName(), "Unknown error during processing response from " + SERVICE +
                    " server", e);
        }
        return result;
    }

    /**
     * Convert response from server to appropriate object
     *
     * @param json  the JSON object
     * @param clazz the type of corresponding object
     * @param <T>
     * @return the corresponding object
     */
    public static <T> T fromJson(JSONObject json, Class<T> clazz) {
        return gson.fromJson(json.toString(), clazz);
    }

    /**
     * Convert response from server to appropriate object
     *
     * @param json the JSON object
     * @param type the type of corresponding object
     * @param <T>
     * @return the corresponding object
     */
    public static <T> T fromJson(JSONObject json, Type type) {
        return gson.fromJson(json.toString(), type);
    }

    /**
     * Create client which will be used for communication
     *
     * @return the {@link HttpClient} client
     */
    protected static HttpClient createConnection() {
        client = new DefaultHttpClient();
        return client;
    }

    /**
     * @param resp http response from server
     * @return body from response. <b>HTTP Response is passed in, and the String
     *         from the Body is returned.</b>
     * @throws Exception
     */
    private static String getResponse(HttpResponse resp) throws Exception {
        ResponseHandler<String> handler = new BasicResponseHandler();
        return handler.handleResponse(resp);
    }

    @Override
    public CategoryDAO getCategoryDAO() {
        return new JsonCategoryDAO();
    }

    @Override
    public CompanyDAO getCompanyDAO() {
        return new JsonCompanyDAO();
    }
}
