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

import org.json.JSONArray;
import org.json.JSONObject;

import com.vaadin.shared.ui.JavaScriptComponentState;

/**
 * A FlotChartState.
 * 
 * @author John McParland.
 *
 */
public class FlotChartState extends JavaScriptComponentState {

    /**
     * The serialVersionUID.
     */
    private static final long serialVersionUID = 1345528294577585084L;

    /**
     * The data.
     */
    private JSONArray data = null;

    /**
     * The options.
     */
    private JSONObject options = null;

    /**
     * Create a FlotChartState.
     *
     */
    public FlotChartState() {

    }

    /**
     * Get the data.
     * 
     * @return the data.
     */
    public JSONArray getData() {
        return data;
    }

    /**
     * Set the data.
     * 
     * @param data
     *            the data to set.
     */
    public void setData(JSONArray data) {
        this.data = data;
    }

    /**
     * Get the options.
     * 
     * @return the options.
     */
    public JSONObject getOptions() {
        return options;
    }

    /**
     * Set the options.
     * 
     * @param options
     *            the options to set.
     */
    public void setOptions(JSONObject options) {
        this.options = options;
    }

}
