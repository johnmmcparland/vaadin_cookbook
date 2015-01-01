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
package com.mcparland.john;

/*
 * #%L
 * Chapter 2: Controlling Components over CSS Layout
 * %%
 * Copyright (C) 2014 John McParland
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

import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;

/**
 * A tag cloud.
 * 
 * @author John McParland.
 * 
 */
@SuppressWarnings("serial")
public class TagCloud extends CssLayout {

    /*
     * (non-Javadoc)
     * 
     * @see com.vaadin.ui.CssLayout#getCss(com.vaadin.ui.Component)
     */
    @Override
    protected String getCss(Component c) {
        String css = null;
        if (c instanceof TagLabel) {
            TagLabel tag = (TagLabel) c;
            css = "font-size: " + tag.getFontSize() + "px;";
            css += "line-height: " + tag.getFontSize() + "px;";
            css += "display: inline-block;";
            css += "margin: 3px;";
        }
        return css;
    };

}
