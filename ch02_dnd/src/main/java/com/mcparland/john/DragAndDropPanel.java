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

/*
 * #%L
 * Chapter 2: Drag and Drop
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

import com.vaadin.event.dd.DragAndDropEvent;
import com.vaadin.event.dd.DropHandler;
import com.vaadin.event.dd.acceptcriteria.AcceptAll;
import com.vaadin.event.dd.acceptcriteria.AcceptCriterion;
import com.vaadin.ui.AbstractLayout;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.DragAndDropWrapper;
import com.vaadin.ui.DragAndDropWrapper.DragStartMode;
import com.vaadin.ui.DragAndDropWrapper.WrapperTransferable;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.VerticalSplitPanel;

/**
 * Split panel for Drag and Drop actions.
 * 
 * @author John McParland
 * 
 */
@SuppressWarnings("serial")
public class DragAndDropPanel extends HorizontalSplitPanel {

    /**
     * Create a DragAndDropPanel.
     * 
     */
    public DragAndDropPanel() {
        super();
        final VerticalSplitPanel leftSplitPanel = new VerticalSplitPanel();
        leftSplitPanel.setSizeFull();
        leftSplitPanel.setFirstComponent(createLayout(new HorizontalLayout()));
        leftSplitPanel.setSecondComponent(new VerticalLayout());

        final VerticalSplitPanel rightSplitPanel = new VerticalSplitPanel();
        rightSplitPanel.setSizeFull();
        rightSplitPanel.setFirstComponent(createLayout(new GridLayout(3, 3)));
        rightSplitPanel.setSecondComponent(new InlineCssLayout());

        setFirstComponent(leftSplitPanel);
        setSecondComponent(rightSplitPanel);
        setSizeFull();
    }

    /**
     * Create a drag-and-droppable layout.
     * 
     * @param layout
     *            the layout.
     * @return a drag-and-droppable layout.
     */
    private Component createLayout(final AbstractLayout layout) {
        layout.addComponent(createButton("One"));
        layout.addComponent(createButton("Two"));
        layout.addComponent(createButton("Three"));
        layout.addComponent(createButton("Four"));

        final DragAndDropWrapper dndWrapper = new DragAndDropWrapper(layout);
        dndWrapper.setSizeFull();
        dndWrapper.setDropHandler(new DropHandler() {

            /*
             * (non-Javadoc)
             * 
             * @see com.vaadin.event.dd.DropHandler#getAcceptCriterion()
             */
            public AcceptCriterion getAcceptCriterion() {
                return AcceptAll.get();
            }

            /*
             * (non-Javadoc)
             * 
             * @see com.vaadin.event.dd.DropHandler#drop(com.vaadin.event.dd.
             * DragAndDropEvent)
             */
            public void drop(DragAndDropEvent event) {
                WrapperTransferable t = (WrapperTransferable) event.getTransferable();
                layout.addComponent(t.getSourceComponent());
            }
        });

        return dndWrapper;
    }

    /**
     * Create a drag-and-droppable button.
     * 
     * @param name
     *            the name of the button.
     * @return a drag-and-droppable button.
     */
    public Component createButton(String name) {
        Button button = new Button(name);
        DragAndDropWrapper buttonWrap = new DragAndDropWrapper(button);
        buttonWrap.setDragStartMode(DragStartMode.COMPONENT);
        buttonWrap.setSizeUndefined();
        return buttonWrap;
    }
}
