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

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * A view which displays a friendly name.
 * 
 * @author John McParland
 * 
 */
@SuppressWarnings("serial")
public class WelcomeView extends VerticalLayout implements View {

    /**
     * Name of this view.
     */
    public static final String VIEW_NAME = "";

    public WelcomeView() {
        Label welcomeLabel = new Label("Welcome!");
        addComponent(welcomeLabel);

        Button ordersButton = new Button("Open Orders");
        ordersButton.addClickListener(new ClickListener() {

            @Override
            public void buttonClick(ClickEvent event) {
                UI ui = UI.getCurrent();
                Navigator nav = ui.getNavigator();
                nav.navigateTo(OrdersView.VIEW_NAME);
            }
        });

        addComponent(ordersButton);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.vaadin.navigator.View#enter(com.vaadin.navigator.ViewChangeListener
     * .ViewChangeEvent)
     */
    @Override
    public void enter(ViewChangeEvent event) {

    }

}
