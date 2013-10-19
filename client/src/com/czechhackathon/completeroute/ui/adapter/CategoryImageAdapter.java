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
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import com.czechhackathon.completeroute.R;
import com.czechhackathon.completeroute.pojo.Category;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author <a href="mailto:hanusto@gmail.com">Tomas Hanus</a>
 */
public class CategoryImageAdapter extends BaseAdapter {

    // references to our images
    private static Map<String, Integer> mThumbs = new HashMap<>();

    static {
        mThumbs.put("banking", R.drawable.cat_banking);
        mThumbs.put("telecommunications", R.drawable.cat_telecommunications);
        mThumbs.put("services", R.drawable.cat_services);
        mThumbs.put("insurance", R.drawable.cat_insurance);
        mThumbs.put("government", R.drawable.cat_government);
    }

    private Context mContext;
    // references to our images
    private Integer[] mThumbIds;

    public CategoryImageAdapter(Context c, List<Category> categoryList) {
        mContext = c;

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
        ImageView imageView;
        if (convertView == null) {  // if it's not recycled, initialize some attributes
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(mThumbIds[position]);
        return imageView;
    }
}
