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

/*
 * #%L
 * Vaadin Web Application
 * %%
 * Copyright (C) 2014 - 2015 John McParland
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.vaadin.annotations.JavaScript;
import com.vaadin.ui.AbstractJavaScriptComponent;

/**
 * A FlotChart.
 * 
 * @author John McParland.
 *
 */
@JavaScript({ "jquery.min-1.11.2.js", "jquery.flot-0.8.3.js", "flot_connector.js" })
public class FlotChart extends AbstractJavaScriptComponent {

    /**
     * The serialVersionUID.
     */
    private static final long serialVersionUID = -4887074161683017185L;

    /**
     * Create a FlotChart.
     *
     */
    public FlotChart() {

    }

    /*
     * (non-Javadoc)
     * 
     * @see com.vaadin.ui.AbstractJavaScriptComponent#getState()
     */
    public FlotChartState getState() {
        return (FlotChartState) super.getState();
    }

    /**
     * Sets the data. Please use in preference to
     * {@link AbstractJavaScriptComponent#setData(Object)}.
     * 
     * @param source
     *            the JSON array which is the source of the data.
     */
    public void setData(String source) {
        JSONArray data = null;
        try {
            data = new JSONArray(source);
            getState().setData(data);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /**
     * Set the options.
     * 
     * @param options
     *            the options to set.
     */
    public void setOptions(String options) {
        try {
            JSONObject root = new JSONObject(options);
            getState().setOptions(root);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}
