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
 * Chapter 2: Tabs with Hard URL
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

import java.util.Iterator;

import org.apache.commons.lang3.StringUtils;

import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Component;
import com.vaadin.ui.Label;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * Tab sheet with URLs tied to tabs.
 * 
 * @author John McParland.
 * 
 */
@SuppressWarnings("serial")
public class TabsURL extends TabSheet {

    /**
     * Names of the tabs.
     */
    private static final String TAB_NAMES[] = { "Home", "Contractors", "Customers", "Employees", "Help and Info" };

    /**
     * Create a TabsURL.
     * 
     */
    public TabsURL() {
        createTabs(TAB_NAMES);
        addSelectedTabChangeListener(new UrlFragmentSelectedTabChangeListener());
    }

    /**
     * Create the tabs.
     * 
     * @param tabNames
     *            the names of the tabs to create.
     */
    private void createTabs(String[] tabNames) {
        for (String tabName : tabNames) {
            VerticalLayout tab = new VerticalLayout();
            tab.setCaption(tabName);
            tab.addComponent(new Label("<h1>" + tabName + "</h1>", ContentMode.HTML));
            tab.setHeight(400, Unit.PIXELS);
            addComponent(tab);
        }
    }

    /**
     * Select the appropriate tab depending on URL fragment.
     */
    public void selectTab() {
        final String fragment = UI.getCurrent().getPage().getUriFragment();
        if (null == fragment) {
            setSelectedTab(0);
        } else {
            Iterator<Component> compIt = iterator();
            while (compIt.hasNext()) {
                final Component tab = compIt.next();
                final String tabName = tab.getCaption();
                final String tabNameAsURLFragment = convertNameToFragment(tabName);
                // Check tab name against the URL fragment.
                if (null != tabNameAsURLFragment && StringUtils.equalsIgnoreCase(fragment, tabNameAsURLFragment)) {
                    setSelectedTab(tab);
                    return;
                }
            }
            // Yikes, finished the while loop and no tab selected.
            setSelectedTab(0);
        }
    }

    /**
     * Ensure the name of a tab is suitable for a URL fragment.
     * 
     * @param name
     *            the name of the tab.
     * @return the name in a suitable format for a URL fragment.
     */
    private String convertNameToFragment(String name) {
        if (null == name) {
            return null;
        }
        return name.replaceAll("\\s", "-");
    }

    /**
     * Updates the URL depending on the tab selected.
     * 
     * @author John McParland.
     * 
     */
    private class UrlFragmentSelectedTabChangeListener implements SelectedTabChangeListener {

        /*
         * (non-Javadoc)
         * 
         * @see
         * com.vaadin.ui.TabSheet.SelectedTabChangeListener#selectedTabChange
         * (com.vaadin.ui.TabSheet.SelectedTabChangeEvent)
         */
        @Override
        public void selectedTabChange(SelectedTabChangeEvent event) {
            final String selectedTabName = event.getTabSheet().getSelectedTab().getCaption();
            // Ensure the tab name is suitable for a URL fragment.
            final String selectedTabURLFragment = convertNameToFragment(selectedTabName);
            UI.getCurrent().getPage().setUriFragment(selectedTabURLFragment);
        }

    }

}
