package com.wiley.javainterviewsexposed.chapter13;

import org.apache.commons.io.IOUtils;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.AbstractHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

public class JettyParams {

    public static void main(String args[]) throws Exception {
        final Server jettyServer = new Server(8080);
        jettyServer.setHandler(new ParamsHandler());
        jettyServer.start();
        jettyServer.join();
    }
}

class ParamsHandler extends AbstractHandler {

    @Override
    public void handle(String s, Request baseRequest, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_OK);
        baseRequest.setHandled(true);

        final StringBuffer output = new StringBuffer();

        final Map<String, String[]> parameterMap = request.getParameterMap();
        for (String parameterName : parameterMap.keySet()) {
            output.append(
                    String.format("%s: %s<br/>",
                            parameterName,
                            Arrays.asList(parameterMap.get(parameterName))));
        }

        IOUtils.write(output, response.getOutputStream());
    }
}

