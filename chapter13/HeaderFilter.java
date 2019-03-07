package com.wiley.javainterviewsexposed.chapter13;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HeaderFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // do nothing
    }

    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        if (request.getParameter("requiredParameter") != null) {
            chain.doFilter(request, response);
        } else {
            ((HttpServletResponse) response).sendError(
                    HttpServletResponse.SC_UNAUTHORIZED);
        }

    }

    @Override
    public void destroy() {
        // do nothing
    }
}
