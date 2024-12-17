package com.udea.siiuseguimproyectosback.core.config;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Global Filter for Cross-Origin Resource Sharing (CORS).
 * <p>
 * This filter ensures that the application supports requests from different origins
 * by configuring CORS headers. It allows specific HTTP methods and headers for
 * cross-origin requests, providing a way for the backend to communicate with
 * clients from different domains.
 * </p>
 */
@Component
@WebFilter("/*")  // Apply this filter to all incoming requests
public class CORSFilter implements Filter {

    /**
     * Applies the CORS filter to every incoming request and response.
     * <p>
     * This method sets the necessary headers in the HTTP response to allow
     * cross-origin requests. It configures the allowed origins, HTTP methods,
     * headers, and the max age of the preflight request.
     * </p>
     *
     * @param req the incoming ServletRequest
     * @param res the outgoing ServletResponse
     * @param chain the FilterChain that allows the request to continue to the next filter
     * @throws IOException if an input or output exception occurs during filtering
     * @throws ServletException if a servlet-related error occurs during filtering
     */
    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {

        HttpServletResponse response = (HttpServletResponse) res;

        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with, origin, content-type, accept");
        response.setHeader("Access-Control-Max-Age", "1800");

        chain.doFilter(req, res);
    }
}
