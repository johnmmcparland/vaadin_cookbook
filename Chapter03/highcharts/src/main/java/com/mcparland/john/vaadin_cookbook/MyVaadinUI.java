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

        //@formatter:off
        String jsonData = 
                "{" +
                "  chart: "+
                "         { renderTo: 'chart'}, " +
                "         series: " +
                "                  [ " +
                "                     { " +
                "                        type: 'pie', " +
                "                        data: " +
                "                               [ " +
                "                                  ['Im average looking.', 2], " +
                "                                  ['Im shy around girls.', 3], " +
                "                                  ['Im married.',45], " +
                "                                  ['Im level 80 Paladin.', 50] " +
                "                               ] " +
                "                     } " +
                "                  ] " +
                "}";
        //@formatter:on

        Highcharts highcharts = new Highcharts();
        highcharts.setData(jsonData);
        highcharts.setId("chart");
        highcharts.setWidth("400px");
        highcharts.setHeight("300px");

        layout.addComponent(highcharts);
    }

}
