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

/**
 * A Product.
 * 
 * @author John McParland.
 *
 */
public class Product {

    /**
     * The id.
     */
    private int id = 0;

    /**
     * The name.
     */
    private String name = null;

    /**
     * The price.
     */
    private double price = 0.0f;

    /**
     * Create a Product.
     *
     */
    public Product() {
        // TODO Auto-generated constructor stub
    }

    /**
     * Create a Product.
     *
     * @param id
     * @param name
     * @param price
     */
    public Product(int id, String name, double price) {
        super();
        this.id = id;
        this.name = name;
        this.price = price;
    }

    /**
     * Get the id.
     * 
     * @return the id.
     */
    public int getId() {
        return id;
    }

    /**
     * Set the id.
     * 
     * @param id
     *            the id to set.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Get the name.
     * 
     * @return the name.
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name.
     * 
     * @param name
     *            the name to set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the price.
     * 
     * @return the price.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Set the price.
     * 
     * @param price
     *            the price to set.
     */
    public void setPrice(double price) {
        this.price = price;
    }

}
