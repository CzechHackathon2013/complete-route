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
import com.hackathon.completeroute.pojo.Company;

import java.util.List;

/**
 * @author <a href="mailto:hanusto@gmail.com">Tomas Hanus</a>
 */
public class CompanyImageAdapter extends BaseAdapter {

    private List<Company> companyList;
    private Activity mActivity;
    // references to our images
    private Integer[] mThumbIds;

    public CompanyImageAdapter(Activity a, List<Company> companyList) {
        mActivity = a;

        this.companyList = companyList;
        mThumbIds = new Integer[companyList.size()];
        for (int i = 0; i < companyList.size(); i++) {
            //TODO velisher provide reference to image icon
            mThumbIds[i] = CategoryImageAdapter.getThumbs().get(companyList.get(i).getCategory().toLowerCase());
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

            view = li.inflate(R.layout.company_grid_item_layout, null);
        } else {
            view = convertView;
        }

        iconText = (TextView) view.findViewById(R.id.company_icon_text);
        iconText.setText(companyList.get(position).getName());
        iconImage = (ImageView) view.findViewById(R.id.company_icon_image);
        iconImage.setImageResource(mThumbIds[position]);
        return view;
    }


}
