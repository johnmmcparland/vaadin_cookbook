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
 * Page 63: Inserting a button to remove a table row
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


import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;

/**
 * A list of {@link Price}s.
 * 
 * @author John McParland.
 *
 */
public class PriceList extends CustomComponent {

    /**
     * The serialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The container.
     */
    private BeanItemContainer<Product> container = null;

    /**
     * Create a PriceList.
     *
     */
    public PriceList() {

    }

    /**
     * Create a PriceList.
     *
     * @param container
     *            the container of products.
     */
    public PriceList(BeanItemContainer<Product> container) {
        super();
        this.container = container;

        // Table stuff
        Table table = createTable();
        table.setContainerDataSource(this.container);

        // Layout
        VerticalLayout layout = new VerticalLayout();
        layout.addComponent(createAddProductButton());
        layout.addComponent(table);
        setCompositionRoot(layout);
    }

    /**
     * Get the container.
     * 
     * @return the container.
     */
    public BeanItemContainer<Product> getContainer() {
        return container;
    }

    /**
     * Set the container.
     * 
     * @param container
     *            the container to set.
     */
    public void setContainer(BeanItemContainer<Product> container) {
        this.container = container;
    }

    /**
     * Create the table.
     * <p>
     * Needs either {@link #PriceList(BeanItemContainer)} or
     * {@link #setContainer(BeanItemContainer)} to have been called first.
     * </p>
     * 
     * @return
     */
    @SuppressWarnings("serial")
    private Table createTable() {
        if (null == container) {
            return null;
        }

        // Basic table stuff.
        final Table table = new Table();
        table.setContainerDataSource(container);
        table.setEditable(true);

        // Allow items to be removed
        table.addGeneratedColumn("Remove", new Table.ColumnGenerator() {
            /*
             * (non-Javadoc)
             * 
             * @see
             * com.vaadin.ui.Table.ColumnGenerator#generateCell(com.vaadin.ui
             * .Table, java.lang.Object, java.lang.Object)
             */
            @Override
            // NOTE: I've made the itemId parameter final.
            public Object generateCell(Table source, final Object itemId, Object columnId) {
                Button removeButton = new Button("X");

                removeButton.addClickListener(new ClickListener() {

                    @Override
                    public void buttonClick(ClickEvent event) {
                        table.removeItem(itemId);
                    }

                });

                return removeButton;
            }
        });

        return table;
    }

    /**
     * Create a button to add products to the table.
     * 
     * @return button to add products to the table.
     */
    @SuppressWarnings("serial")
    private Button createAddProductButton() {
        Button addProductButton = new Button("Add Product");
        addProductButton.addClickListener(new ClickListener() {
            /*
             * (non-Javadoc)
             * 
             * @see
             * com.vaadin.ui.Button.ClickListener#buttonClick(com.vaadin.ui.
             * Button.ClickEvent)
             */
            public void buttonClick(ClickEvent clickEvent) {
                container.addItem(new Product("", 0.0d));
            }
        });
        return addProductButton;
    }

}
