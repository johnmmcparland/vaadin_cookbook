package com.mcparland.john.vaadin_cookbook;

/*
 * #%L
 * Chapter 03 (page 81): DateField with JodaTime DateTime
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

import org.joda.time.DateTime;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.fieldgroup.FieldGroupFieldFactory;
import com.vaadin.data.util.BeanItem;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@Theme("mytheme")
@SuppressWarnings("serial")
public class MyVaadinUI extends UI {

    @WebServlet(value = "/*", asyncSupported = true)
    @VaadinServletConfiguration(productionMode = false, ui = MyVaadinUI.class, widgetset = "com.mcparland.john.vaadin_cookbook.AppWidgetSet")
    public static class Servlet extends VaadinServlet {
    }

    @Override
    protected void init(VaadinRequest request) {
        Post post = new Post();
        String label = "I really need that stuff.";
        post.setText(label);
        DateTime created = DateTime.now();
        post.setCreated(created);

        BeanItem<Post> postBean = new BeanItem<Post>(post);
        FieldGroup fieldGroup = new FieldGroup(postBean);

        FieldGroupFieldFactory fieldFactory = new JodaFieldFactory();
        fieldGroup.setFieldFactory(fieldFactory);

        FormLayout formLayout = new FormLayout();
        formLayout.addComponent(fieldGroup.buildAndBind("text"));
        formLayout.addComponent(fieldGroup.buildAndBind("created"));

        VerticalLayout layout = new VerticalLayout();
        layout.setMargin(true);
        setContent(layout);
        layout.addComponent(formLayout);
    }

}
