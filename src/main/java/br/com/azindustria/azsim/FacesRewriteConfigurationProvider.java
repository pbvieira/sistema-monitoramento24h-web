package br.com.azindustria.azsim;

import org.ocpsoft.rewrite.annotation.RewriteConfiguration;
import org.ocpsoft.rewrite.config.Configuration;
import org.ocpsoft.rewrite.config.ConfigurationBuilder;
import org.ocpsoft.rewrite.servlet.config.HttpConfigurationProvider;
import org.ocpsoft.rewrite.servlet.config.rule.Join;

import javax.servlet.ServletContext;

@org.springframework.context.annotation.Configuration
@RewriteConfiguration
public class FacesRewriteConfigurationProvider extends HttpConfigurationProvider {

    @Override
    public int priority() {
        return 10;
    }

    @Override
    public Configuration getConfiguration(ServletContext servletContext) {
        return ConfigurationBuilder.begin()
                .addRule(Join.path("/clientes").to("cadastrar-cliente.xhtml"));
    }
}