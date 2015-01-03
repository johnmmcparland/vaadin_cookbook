/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package com.mcparland.john.vaadin_cookbook;

import org.json.JSONException;
import org.json.JSONObject;

import com.vaadin.annotations.JavaScript;
import com.vaadin.ui.AbstractJavaScriptComponent;

/**
 * A Highcharts.
 * 
 * @author John McParland.
 *
 */
@JavaScript({ "jquery.min-1.11.2.js", "highcharts-4.0.4.js", "highcharts_connector.js" })
public class Highcharts extends AbstractJavaScriptComponent {

    /**
     * The serialVersionUID.
     */
    private static final long serialVersionUID = -547025047609094894L;

    /**
     * Create a Highcharts.
     *
     */
    public Highcharts() {

    }

    /*
     * (non-Javadoc)
     * 
     * @see com.vaadin.ui.AbstractJavaScriptComponent#getState()
     */
    public HighchartsState getState() {
        return (HighchartsState) super.getState();
    }

    /**
     * Set the data from a JSON string. Use instead of
     * {@link AbstractJavaScriptComponent#setData(Object)}.
     * 
     * @param jsonData
     *            the JSON string.
     */
    public void setData(String jsonData) {
        try {
            JSONObject data = new JSONObject(jsonData);
            getState().setData(data);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}
