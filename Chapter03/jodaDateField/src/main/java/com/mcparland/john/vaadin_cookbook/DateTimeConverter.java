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

import java.util.Date;
import java.util.Locale;

import org.joda.time.DateTime;

import com.vaadin.data.util.converter.Converter;

/**
 * A DateTimeConverter.
 * 
 * @author John McParland.
 *
 */
public class DateTimeConverter implements Converter<Date, DateTime> {

    /**
     * The serialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Create a DateTimeConverter.
     *
     */
    public DateTimeConverter() {

    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.vaadin.data.util.converter.Converter#convertToModel(java.lang.Object,
     * java.lang.Class, java.util.Locale)
     */
    @Override
    public DateTime convertToModel(Date value, Class<? extends DateTime> targetType, Locale locale)
            throws com.vaadin.data.util.converter.Converter.ConversionException {
        return new DateTime(value);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.vaadin.data.util.converter.Converter#convertToPresentation(java.lang
     * .Object, java.lang.Class, java.util.Locale)
     */
    @Override
    public Date convertToPresentation(DateTime value, Class<? extends Date> targetType, Locale locale)
            throws com.vaadin.data.util.converter.Converter.ConversionException {
        final Date date = value.toDate();
        return date;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.vaadin.data.util.converter.Converter#getModelType()
     */
    @Override
    public Class<DateTime> getModelType() {
        return DateTime.class;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.vaadin.data.util.converter.Converter#getPresentationType()
     */
    @Override
    public Class<Date> getPresentationType() {
        return Date.class;
    }

}
