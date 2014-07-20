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
 * Chapter 2: CSS Mobile
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

import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Tree;

/**
 * Example of using CSS layout on a mobile device.
 * 
 * @author John McParland
 * 
 */
@SuppressWarnings("serial")
public class MobileLayout extends CssLayout {

    private static final String LIPSUM = "Lorem ipsum doler sit amet, consectetur adipisicing elit.";

    public MobileLayout() {
        Label header = new Label("<h1>CSS layout</h1>", ContentMode.HTML);
        addComponent(header);

        Label content = new Label(LIPSUM);
        content.setWidth(70, Unit.PERCENTAGE);
        addComponent(content);

        addComponent(createMenu());
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.vaadin.ui.CssLayout#getCss(com.vaadin.ui.Component)
     */
    @Override
    protected String getCss(Component c) {
        return "margin: 5px; vertical-align: top;";
    }

    /**
     * Create the menu.
     * 
     * @return the menu.
     */
    private Tree createMenu() {
        Tree menu = new Tree();
        for (int i = 1; i < 6; i++) {
            String item = "item" + i;
            String childItem = "subitem" + i;
            menu.addItem(item);
            menu.addItem(childItem);
            menu.setParent(childItem, item);
            menu.setChildrenAllowed(childItem, false);
        }
        return menu;
    }

}
