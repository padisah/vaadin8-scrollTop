package com.vaadin.issues;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@Theme("valo")
public class IssuePresenter extends UI {

    private static final long serialVersionUID = 6710074225305648146L;

    @Override
    protected void init(VaadinRequest request) {
        setLocale(request.getLocale());
        final VerticalLayout layout = new VerticalLayout();
        layout.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
        layout.setWidth("100%");
        layout.setSpacing(true);
        layout.setMargin(true);
        Button button = new Button("open window");
        button.addClickListener(new ClickListener() {

            private static final long serialVersionUID = 229977307438794574L;

            @Override
            public void buttonClick(ClickEvent event) {
                UI.getCurrent().addWindow(new IssueWindow());
            }
        });
        layout.addComponent(new Label("Click on 'open Window', then scroll down manually to the middle. There will be a poll request from ui, which resets the scroll position"));
        layout.addComponent(button);
        setContent(layout);
        setPollInterval(10000);
    }


}