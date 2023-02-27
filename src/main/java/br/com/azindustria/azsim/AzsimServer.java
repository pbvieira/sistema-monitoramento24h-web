package br.com.azindustria.azsim;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AzsimServer {

    public static void main(String[] args) {
        SpringApplication.run(AzsimServer.class, args);
    }


/*
    @Bean
    public ServletRegistrationBean<FacesServlet> jsfServletRegistration(ServletContext servletContext) {
        //spring boot only works if this is set
        servletContext.setInitParameter("com.sun.faces.forceLoadConfiguration", Boolean.TRUE.toString());

        servletContext.setInitParameter("javax.faces.DATETIMECONVERTER_DEFAULT_TIMEZONE_IS_SYSTEM_TIMEZONE", Boolean.TRUE.toString());

        //FacesServlet registration
        ServletRegistrationBean<FacesServlet> srb = new ServletRegistrationBean<>();
        srb.setServlet(new FacesServlet());
        srb.setUrlMappings(Arrays.asList("*.xhtml"));
        srb.setLoadOnStartup(1);
        return srb;
    }
*/
}