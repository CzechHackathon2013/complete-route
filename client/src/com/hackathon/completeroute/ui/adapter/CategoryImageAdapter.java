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
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.hackathon.completeroute.R;
import com.hackathon.completeroute.pojo.Category;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author <a href="mailto:hanusto@gmail.com">Tomas Hanus</a>
 */
public class CategoryImageAdapter extends BaseAdapter {

    // references to our images
    private static Map<String, Integer> mThumbs = new HashMap<>();
    private List<Category> categoryList;

    static {
        //TODO better solution for mapping resources to categories
        mThumbs.put("banking", R.drawable.cat_banking);
        mThumbs.put("telco", R.drawable.cat_teleco);
        mThumbs.put("services", R.drawable.cat_services);
        mThumbs.put("insurance", R.drawable.cat_insurance);
        mThumbs.put("government", R.drawable.cat_government);
    }

    private Activity mActivity;
    // references to our images
    private Integer[] mThumbIds;

    public CategoryImageAdapter(Activity a, List<Category> categoryList) {
        mActivity = a;

        this.categoryList = categoryList;
        mThumbIds = new Integer[categoryList.size()];
        for (int i = 0; i < categoryList.size(); i++) {
            mThumbIds[i] = mThumbs.get(categoryList.get(i).getId());
        }
    }

    public int getCount() {
        return mThumbIds.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {

        View view;
        TextView iconText = null;
        ImageView iconImage;


        if (convertView == null) {
            LayoutInflater li = mActivity.getLayoutInflater();

            view = li.inflate(R.layout.category_grid_item_layout, null);
        } else {
            view = convertView;
        }

        iconText = (TextView) view.findViewById(R.id.category_icon_text);
        iconText.setText(categoryList.get(position).getName());
        iconImage = (ImageView) view.findViewById(R.id.category_icon_image);
        iconImage.setImageResource(mThumbIds[position]);
        return view;
    }

    public static Map<String, Integer> getThumbs() {
        return mThumbs;
    }
}
