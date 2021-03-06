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
 * Chapter 09: Binding a container to a component (page 270)
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
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.Table;

/**
 * A ProductTable.
 * 
 * @author John McParland.
 *
 */
public class ProductTable extends Table {

    /**
     * The serialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The products.
     */
    private BeanItemContainer<Product> products = new BeanItemContainer<Product>(Product.class);

    /**
     * Create a ProductTable.
     *
     */
    public ProductTable() {
        fillContainer(products);
        setContainerDataSource(products);
        setPageLength(size());
    }

    /**
     * Fill the container
     * 
     * @param container
     *            the container.
     */
    private void fillContainer(Container container) {
        int id = 0;
        container.addItem(new Product(id++, "Computer", 599.90));
        container.addItem(new Product(id++, "Phone", 14.5));
        container.addItem(new Product(id++, "Tablet", 99.90));
        container.addItem(new Product(id++, "Mouse", 0.99));
    }

}
