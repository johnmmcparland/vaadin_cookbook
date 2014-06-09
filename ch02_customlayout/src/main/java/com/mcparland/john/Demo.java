package com.mcparland.john;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.CustomLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;

@Theme("mytheme")
@SuppressWarnings("serial")
public class Demo extends UI {

    @WebServlet(value = "/*", asyncSupported = true)
    @VaadinServletConfiguration(productionMode = false, ui = Demo.class, widgetset = "com.mcparland.john.AppWidgetSet")
    public static class Servlet extends VaadinServlet {
    }

    @Override
    protected void init(VaadinRequest request) {
        CustomLayout layout = new CustomLayout("mylayout");
        setContent(layout);
        Label header = new Label("Custom layout");
        header.addStyleName("header");
        layout.addComponent(header, "header");
        Label menu = new Label("menu");
        layout.addComponent(menu, "menu");
        Label content = new Label("This is content of page.");
        layout.addComponent(content, "content");
        Label footer = new Label("Created by Vaadin, 2013");
        layout.addComponent(footer, "footer");
    }

}
