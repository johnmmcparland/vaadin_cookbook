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
 * Chapter 2: Collections Of Components
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

import com.vaadin.server.Resource;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.Accordion;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.DragAndDropWrapper;
import com.vaadin.ui.DragAndDropWrapper.DragStartMode;
import com.vaadin.ui.Image;
import com.vaadin.ui.Layout;

/**
 * @author John McParland
 * 
 */
@SuppressWarnings("serial")
public class ComponentCollection extends Accordion {

    /**
     * Sizes of icons.
     */
    private String[] sizes = { "16", "32", "64" };

    /**
     * The icons.
     */
    private String[] icons = { "cancel.png", "calendar.png", "document.png", "email.png", "globe.png", "help.png",
            "note.png", "ok.png", "trash.png", "user.png" };

    /**
     * Create a ComponentCollection.
     * 
     */
    public ComponentCollection() {
        setSizeFull();
        createTabs();
    }

    /**
     * Create some tabs for each size
     * 
     * @param sizes
     *            the sizes
     */
    private void createTabs() {
        for (String size : sizes) {
            final Layout layout = createLayout();
            layout.setCaption("Icons size " + size + " x " + size);
            addComponent(layout);

            for (String icon : icons) {
                final Image image = createImage(size, icon);
                DragAndDropWrapper imageWrap = new DragAndDropWrapper(image);
                imageWrap.setDragStartMode(DragStartMode.COMPONENT);
                imageWrap.setSizeUndefined();
                layout.addComponent(imageWrap);
            }
        }
    }

    /**
     * @return
     */
    private Layout createLayout() {
        final CssLayout layout = new CssLayout() {
            public String getCss(Component c) {
                return "display: inline-block;";
            }
        };
        return layout;
    }

    /**
     * @param size
     * @param icon
     * @return
     */
    private Image createImage(String size, String icon) {
        final Resource imageResource = new ThemeResource("../runo/icons/" + size + "/" + icon);
        final Image image = new Image(null, imageResource);
        return image;
    }
}
