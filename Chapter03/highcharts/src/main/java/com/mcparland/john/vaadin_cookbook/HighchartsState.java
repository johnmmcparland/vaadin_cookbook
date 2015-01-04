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
 * Chapter 3: Creating a pie chart with Highcharts (page 72)
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


import org.json.JSONObject;

import com.vaadin.shared.ui.JavaScriptComponentState;

/**
 * A HighchartsState.
 * 
 * @author John McParland.
 *
 */
public class HighchartsState extends JavaScriptComponentState {

    /**
     * The serialVersionUID.
     */
    private static final long serialVersionUID = 1689205960834969895L;

    /**
     * The data.
     */
    private JSONObject data = null;

    /**
     * Create a HighchartsState.
     *
     */
    public HighchartsState() {

    }

    /**
     * Get the data.
     * 
     * @return the data.
     */
    public JSONObject getData() {
        return data;
    }

    /**
     * Set the data.
     * 
     * @param data
     *            the data to set.
     */
    public void setData(JSONObject data) {
        this.data = data;
    }

}
