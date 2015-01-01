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

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.UI;

@Theme("mytheme")
@SuppressWarnings("serial")
public class MyVaadinUI extends UI {

    @WebServlet(value = "/*", asyncSupported = true)
    @VaadinServletConfiguration(productionMode = false, ui = MyVaadinUI.class, widgetset = "com.mcparland.john.AppWidgetSet")
    public static class Servlet extends VaadinServlet {
    }

    @Override
    protected void init(VaadinRequest request) {
        String names[] = { "HTML", "Java", "Vaadin", "GWT", "CSS", "Javascript" };
        int fontSizes[] = { 12, 20, 32, 24, 17, 19 };
        TagCloud tagCloud = new TagCloud();
        for (int i = 0; i < names.length; i++) {
            tagCloud.addComponent(new TagLabel(names[i], fontSizes[i]));
        }
        tagCloud.setWidth(150, Unit.PIXELS);
        setContent(tagCloud);
    }

}
