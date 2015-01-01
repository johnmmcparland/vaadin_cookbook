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

import com.vaadin.ui.Label;

/**
 * A "tag" on a tag cloud.
 * 
 * @author John McParland
 * 
 */
@SuppressWarnings("serial")
public class TagLabel extends Label {

    private int fontSize = 0;

    /**
     * Create a TagLabel.
     * 
     * @param text
     *            the text to display
     * @param fontSize
     *            the size to display the text.
     */
    public TagLabel(String text, int fontSize) {
        super(text);
        this.fontSize = fontSize;
        this.setSizeUndefined();
    }

    /**
     * Get the fontSize.
     * 
     * @return the fontSize.
     */
    public int getFontSize() {
        return fontSize;
    }

    /**
     * Set the fontSize.
     * 
     * @param fontSize
     *            the fontSize to set.
     */
    public void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }
}
