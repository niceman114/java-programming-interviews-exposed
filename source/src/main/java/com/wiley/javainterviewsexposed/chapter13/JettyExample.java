package com.wiley.javainterviewsexposed.chapter13;

import org.apache.commons.io.IOUtils;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.AbstractHandler;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JettyExample {

    public static void main(String args[]) throws Exception {
        final Server jettyServer = new Server(8080);
        jettyServer.setHandler(new EchoHandler());
        jettyServer.start();
        jettyServer.join();
    }
}

class EchoHandler extends AbstractHandler {

    @Override
    public void handle(String target,
                       Request baseRequest,
                       HttpServletRequest request,
                       HttpServletResponse response)
            throws IOException, ServletException {
        response.setContentType("text/plain");
        response.setStatus(HttpServletResponse.SC_OK);
        baseRequest.setHandled(true);

        final ServletInputStream requestInputStream =
                request.getInputStream();
        final ServletOutputStream responseOutputStream =
                response.getOutputStream();

        IOUtils.copy(requestInputStream, responseOutputStream);
    }
}
