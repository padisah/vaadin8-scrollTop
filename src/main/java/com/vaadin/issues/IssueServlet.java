package com.vaadin.issues;

import java.io.IOException;
import java.util.Set;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.common.collect.Sets;
import com.vaadin.server.VaadinServlet;

public class IssueServlet extends VaadinServlet {
    private static final long serialVersionUID = -1802443237320466849L;
    private static Logger logger = Logger.getLogger(IssueServlet.class.getName());

    private String contextPath = "";

    private Set<String> allowedSubPath = Sets.newHashSet("/PUSH", "/APP/UPLOAD/", "/HEARTBEAT", "/VAADIN/", "/UIDL/", "/APP/PUBLISHED/");

    @Override
    public void init(javax.servlet.ServletConfig servletConfig)
            throws ServletException {
        super.init(servletConfig);
        contextPath = servletConfig.getServletContext().getContextPath();
    }

    @Override
    protected void service(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        String uriPath = request.getRequestURI().replace(contextPath, "");
        if (uriPath.equals("/")) {
            super.service(request, response);
            return;
        }
        for (String pattern : allowedSubPath) {
            if (uriPath.startsWith(pattern)) {
                super.service(request, response);
                return;
            }
        }
        logger.info("Refused uriPath: " + uriPath);
        response.sendError(404);
    }

}