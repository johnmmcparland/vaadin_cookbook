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

import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Label;
import com.vaadin.ui.RichTextArea;
import com.vaadin.ui.Table;
import com.vaadin.ui.Tree;
import com.vaadin.ui.VerticalSplitPanel;

/**
 * An example of an Adjustable layout, taken from Chapter 2 of the Vaadin 7
 * Cookbook.
 * 
 * @author John McParland
 * 
 */
public class AdjustableLayout extends HorizontalSplitPanel {

    /**
     * @see java.io.Serializable
     */
    private static final long serialVersionUID = 1L;

    /**
     * Some random text.
     */
    private static final String LIPSUM = "Lorem ipsum dolor …";

    /**
     * Create an AdjustableLayout.
     * 
     */
    public AdjustableLayout() {
        setFirstComponent(createMenu());
        setSecondComponent(createContentPanel());
        setSplitPosition(10, Unit.PERCENTAGE);
        setSizeFull();
    }

    /**
     * Create the menu.
     * 
     * @return the menu.
     */
    private Tree createMenu() {
        Tree menu = new Tree();
        for (int i = 1; i < 6; i++) {
            String item = "item" + i;
            String childItem = "subitem" + i;
            menu.addItem(item);
            menu.addItem(childItem);
            menu.setParent(childItem, item);
            menu.setChildrenAllowed(childItem, false);
        }
        return menu;
    }

    /**
     * Create the content panel.
     * 
     * @return the content panel.
     */
    private Component createContentPanel() {
        VerticalSplitPanel contentPanel = new VerticalSplitPanel();
        contentPanel.setFirstComponent(createEditorPanel());
        contentPanel.setSecondComponent(createTable());
        contentPanel.setSplitPosition(80, Unit.PERCENTAGE);
        return contentPanel;
    }

    /**
     * Create the editor panel.
     * 
     * @return the editor panel.
     */
    private Component createEditorPanel() {
        SafeHtml safeHtml = SafeHtmlUtils.fromSafeConstant("<b>Help</b> <br />" + LIPSUM);
        HorizontalSplitPanel editorPanel = new HorizontalSplitPanel();
        RichTextArea editor = new RichTextArea();
        editor.setSizeFull();
        editor.setValue(LIPSUM);
        editorPanel.setFirstComponent(editor);
        editorPanel.setSecondComponent(new Label(safeHtml.asString(), ContentMode.HTML));
        editorPanel.setSplitPosition(80, Unit.PERCENTAGE);
        return editorPanel;
    }

    /**
     * Create the table.
     * 
     * @return the table.
     */
    private Table createTable() {
        Table table = new Table();
        table.addContainerProperty("Name", String.class, null);
        table.addContainerProperty("Value", String.class, null);
        table.addItem(new Object[] { "Color", "blue" }, null);
        table.addItem(new Object[] { "Height", "600 px" }, null);
        table.addItem(new Object[] { "Width", "1024 px" }, null);
        table.setSizeFull();
        return table;
    }
}
