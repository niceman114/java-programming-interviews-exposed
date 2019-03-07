package com.wiley.javainterviewsexposed.chapter13;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;

public class JettyServletExample {

    public static void main(String[] args) throws Exception {
        final Server jettyServer = new Server(8080);
        final ServletHandler servletHandler = new ServletHandler();
        jettyServer.setHandler(servletHandler);
        servletHandler.addServletWithMapping(EchoServlet.class, "/*");
        jettyServer.start();
        jettyServer.join();
    }
}
