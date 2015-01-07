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
package com.mcparland.john.vaadin_cookbook;

/*
 * #%L
 * Chapter 9: Complex CRUD Table (page 273)
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

import com.vaadin.data.Container;
import com.vaadin.data.Item;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup.CommitException;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.event.Action;
import com.vaadin.event.Action.Handler;
import com.vaadin.event.ItemClickEvent;
import com.vaadin.event.ItemClickEvent.ItemClickListener;
import com.vaadin.shared.MouseEventDetails.MouseButton;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Layout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Table;

/**
 * A CRUD.
 * 
 * @author John McParland.
 *
 */
public class CRUD extends HorizontalSplitPanel {

    /**
     * The serialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    private final static Action ACTION_ADD = new Action("Add");
    private final static Action ACTION_DELETE = new Action("Delete");
    private int id = 0;
    private BeanItemContainer<Product> products = new BeanItemContainer<>(Product.class);

    /**
     * Create a CRUD.
     *
     * @param firstComponent
     * @param secondComponent
     */
    public CRUD() {
        fillContainer(products);
        setFirstComponent(createTable(products));
    }

    /**
     * @param container
     * @return
     */
    @SuppressWarnings("serial")
    private Table createTable(Container container) {
        final Table table = new Table(null, container);
        table.setSelectable(true);
        table.setSizeFull();
        table.addItemClickListener(new ItemClickListener() {
            @Override
            public void itemClick(ItemClickEvent event) {
                if (MouseButton.LEFT.getName().equals(event.getButtonName())) {
                    setSecondComponent(createForm(event.getItem()));
                }
            }
        });
        table.addActionHandler(new Handler() {
            @Override
            public void handleAction(Action action, Object sender, Object target) {
                if (ACTION_DELETE == action) {
                    products.removeItem(target);
                }
                if (ACTION_ADD == action) {
                    products.addBean(new Product(id++, "", 0));
                }
            }

            @Override
            public Action[] getActions(Object target, Object sender) {
                return new Action[] { ACTION_ADD, ACTION_DELETE };
            }
        });
        return table;
    }

    /**
     * Create the form for the given item.
     * 
     * @param item
     *            the item.
     * @return a layout for the form.
     */
    @SuppressWarnings("serial")
    private Layout createForm(Item item) {
        FormLayout layout = new FormLayout();
        layout.setSpacing(true);
        layout.setMargin(true);
        final FieldGroup group = new FieldGroup(item);
        for (Object propertyId : group.getUnboundPropertyIds()) {
            layout.addComponent(group.buildAndBind(propertyId));
        }
        Button button = new Button("Commmit");
        button.addClickListener(new ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {
                try {
                    group.commit();
                } catch (CommitException e) {
                    Notification.show(e.getCause().getMessage(), Notification.Type.ERROR_MESSAGE);
                }
            }
        });
        layout.addComponent(button);
        return layout;
    }

    private void fillContainer(Container container) {
        container.addItem(new Product(id++, "Computer", 599.90));
        container.addItem(new Product(id++, "Phone", 14.5));
        container.addItem(new Product(id++, "Tablet", 99.90));
        container.addItem(new Product(id++, "Mouse", 0.99));
    }
}
