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

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.Page.UriFragmentChangedEvent;
import com.vaadin.server.Page.UriFragmentChangedListener;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.UI;

/**
 * @author John McParland
 * 
 */
@Theme("mytheme")
@SuppressWarnings("serial")
public class MyVaadinUI extends UI {

    @WebServlet(value = "/*", asyncSupported = true)
    @VaadinServletConfiguration(productionMode = false, ui = MyVaadinUI.class, widgetset = "com.mcparland.john.AppWidgetSet")
    public static class Servlet extends VaadinServlet {
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.vaadin.ui.UI#init(com.vaadin.server.VaadinRequest)
     */
    @Override
    protected void init(VaadinRequest request) {
        final TabsURL tabsURL = new TabsURL();
        setContent(tabsURL);
        tabsURL.selectTab();

        getPage().addUriFragmentChangedListener(new UriFragmentChangedListener() {
            /*
             * (non-Javadoc)
             * 
             * @see
             * com.vaadin.server.Page.UriFragmentChangedListener#uriFragmentChanged
             * (com.vaadin.server.Page.UriFragmentChangedEvent)
             */
            public void uriFragmentChanged(UriFragmentChangedEvent event) {
                tabsURL.selectTab();
            }
        });
    }

}
