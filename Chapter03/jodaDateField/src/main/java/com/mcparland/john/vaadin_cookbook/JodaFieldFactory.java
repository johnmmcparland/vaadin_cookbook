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

import org.joda.time.DateTime;

import com.vaadin.data.fieldgroup.DefaultFieldGroupFieldFactory;
import com.vaadin.ui.DateField;
import com.vaadin.ui.Field;

/**
 * A JodaFieldFactory.
 * 
 * @author John McParland.
 *
 */
@SuppressWarnings("serial")
public class JodaFieldFactory extends DefaultFieldGroupFieldFactory {

    /**
     * Create a JodaFieldFactory.
     *
     */
    public JodaFieldFactory() {
        // TODO Auto-generated constructor stub
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.vaadin.data.fieldgroup.DefaultFieldGroupFieldFactory#createField(
     * java.lang.Class, java.lang.Class)
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override
    public <T extends Field> T createField(Class<?> type, Class<T> fieldType) {
        T field;
        if (type.isAssignableFrom(DateTime.class)) {
            DateField dateField = new DateField();
            dateField.setConverter(new DateTimeConverter());
            field = (T) dateField;
        } else {
            field = super.createField(type, fieldType);
        }
        return field;
    }

}
