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

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * A MyVaadinUI.
 * 
 * @author John McParland.
 *
 */
@Theme("mytheme")
@SuppressWarnings("serial")
public class MyVaadinUI extends UI {

    /**
     * A Servlet.
     * 
     * @author John McParland.
     *
     */
    @WebServlet(value = "/*", asyncSupported = true)
    @VaadinServletConfiguration(productionMode = false, ui = MyVaadinUI.class, widgetset = "com.mcparland.john.vaadin_cookbook.AppWidgetSet")
    public static class Servlet extends VaadinServlet {
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.vaadin.ui.UI#init(com.vaadin.server.VaadinRequest)
     */
    @Override
    protected void init(VaadinRequest request) {
        final VerticalLayout layout = new VerticalLayout();
        layout.setMargin(true);
        setContent(layout);

        FlotChart flot = new FlotChart();
        flot.setWidth("300px");
        flot.setHeight("300px");

        // @formatter:off
        String data = "[" +
                      "  [" +
                      "    [0, 5]," +
                      "    [2, 7]," +
                      "    [4, 8]," +
                      "    [10, 5]" +
                      "  ]" +
                      "]";
        
        String options = 
                "{" +
                "  grid: {" +
                "          backgroundColor: {" +
                "                             colors: [" +
                "                                       \"#fef\"," +
                "                                       \"#eee\"" +
                "                                     ]" +
                "                           }" +
                "        }" +
                "}";
        // @formatter:on

        flot.setData(data);
        flot.setOptions(options);
        layout.addComponent(flot);
    }

}
