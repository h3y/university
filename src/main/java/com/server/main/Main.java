package com.server.main;

import com.server.dao.AccessKey1;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ContextHandlerCollection;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;

/**
 * Created by Slavik Glodan on 08.12.2016.
 */
public class Main {
    public static void main(String[] args) throws Exception {
//        System.out.println("Hi");
        System.out.println(new AccessKey1().getAccessKey("1234"));

        Server server = new Server(8081);

        // Create resource config
        final ResourceConfig sessionConfig = new ResourceConfig();
        sessionConfig.packages("com.server.controller");

        //sessionConfig.register(AuthenticationFilter.class);
        //sessionConfig.register(CORSResponseFilter.class);
        //sessionConfig.register(JacksonFeature.class);

        // Create servlet handler for static resource servlet.
        ServletHolder staticServletHolder = new ServletHolder(new ServletContainer(sessionConfig));
        ServletContextHandler apiContext = new ServletContextHandler(ServletContextHandler.NO_SESSIONS);
        apiContext.setContextPath("/api");
        apiContext.addServlet(staticServletHolder, "/*");
        ContextHandlerCollection contexts = new ContextHandlerCollection();
        contexts.setHandlers(new Handler[] { apiContext });

        server.setHandler(contexts);
        server.start();
        server.dumpStdErr();
        server.join();
    }
}
