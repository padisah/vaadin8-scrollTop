package com.vaadin.issues;

import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

public class IssueWindow extends Window {

    private static final long serialVersionUID = 5075608507247258074L;

    public IssueWindow() {
        super();
        VerticalLayout l = new VerticalLayout();
        l.setWidth("100%");
        for (Integer i = 0; i < 200; i++) {
            Label ll = new Label(i.toString());
            ll.setWidth("100%");
            l.addComponent(ll);
        }
        this.setHeightUndefined();
        this.setContent(l);
        center();
        
    }
}
