/**
 * 
 */

/*
 * #%L
 * Vaadin Web Application
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

package com.mcparland.john;

import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Component;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Label;
import com.vaadin.ui.ListSelect;

/**
 * @author John
 *
 */
@SuppressWarnings("serial")
public class ContactViewer extends CustomComponent {

    /**
     * 
     */
    public ContactViewer() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @param compositionRoot
     */
    public ContactViewer(Component compositionRoot) {
        super(compositionRoot);
        // TODO Auto-generated constructor stub
    }

    /**
     * @param contacts
     */
    public ContactViewer(BeanItemContainer<Contact> contacts) {
        final HorizontalSplitPanel panel = new HorizontalSplitPanel();
        setCompositionRoot(panel);

        final ListSelect contactSelect = new ListSelect();
        contactSelect.setSizeFull();
        contactSelect.setImmediate(true);
        contactSelect.setContainerDataSource(contacts);
        contactSelect.setItemCaptionPropertyId("fullName");

        // Listen for selections
        contactSelect.addValueChangeListener(new ValueChangeListener() {
            /*
             * (non-Javadoc)
             * 
             * @see
             * com.vaadin.data.Property.ValueChangeListener#valueChange(com.
             * vaadin.data.Property.ValueChangeEvent)
             */
            @Override
            public void valueChange(com.vaadin.data.Property.ValueChangeEvent event) {
                final Contact contact = (Contact) event.getProperty().getValue();
                panel.setSecondComponent(createInfoLabel(contact));
                contactSelect.focus();
            }
        });
        panel.setFirstComponent(contactSelect);
    }

    /**
     * @param contact
     * @return
     */
    private Label createInfoLabel(Contact contact) {
        String info = "";
        if (null != contact) {
            info = "<ul>";
            info += String.format("<li><b>First name:</b> %s </li>", contact.getFirstName());
            info += String.format("<li><b>Last name:</b> %s </li>", contact.getLastName());
            info += String.format("<li><b>Email:</b> %s </li>", contact.getEmail());
            info += "</ul>";
        }
        SafeHtml safeHtml = SafeHtmlUtils.fromSafeConstant(info);
        return new Label(safeHtml.asString(), ContentMode.HTML);
    }

}
