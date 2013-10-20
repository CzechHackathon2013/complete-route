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

package com.hackathon.completeroute.ui.adapter.provider;

import com.hackathon.completeroute.R;

import java.util.HashMap;
import java.util.Map;

/**
 * Key holder that provides resources according key value
 *
 * @author <a href="mailto:hanusto@gmail.com">Tomas Hanus</a>
 */
public class KeyResourceProvider {

    private static Map<Integer, Integer> keyMap = new HashMap<>();

    static {
        keyMap.put(0, R.drawable.zero_large);
        keyMap.put(1, R.drawable.one_large);
        keyMap.put(2, R.drawable.two_large);
        keyMap.put(3, R.drawable.three_large);
        keyMap.put(4, R.drawable.four_large);
        keyMap.put(5, R.drawable.five_large);
        keyMap.put(6, R.drawable.six_large);
        keyMap.put(7, R.drawable.seven_large);
        keyMap.put(8, R.drawable.eight_large);
        keyMap.put(9, R.drawable.nine_large);
    }

    /**
     * Get resource of icon for the key
     *
     * @param key the key of route
     * @return the resource of icon
     */
    public static Integer getKeyResource(Integer key) {

        return keyMap.get(key);

    }

}
