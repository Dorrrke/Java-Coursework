package org.example.kursweb.config;


import org.example.kursweb.Service.MainUserService;
import org.example.kursweb.Service.OrdersService;
import org.example.kursweb.Service.OwnersService;
import org.example.kursweb.Service.WorkersService;
import org.example.kursweb.dao.MainUserDao;
import org.example.kursweb.dao.OrdersDao;
import org.example.kursweb.dao.OwnersDao;
import org.example.kursweb.dao.WorkersDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

import javax.sql.DataSource;
import java.sql.DriverManager;


@Configuration
@ComponentScan("org.example.kursweb")
@EnableWebMvc
public class SpringConfig implements WebMvcConfigurer {

    private final ApplicationContext applicationContext;

    @Autowired
    public SpringConfig(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Bean
    public SpringResourceTemplateResolver templateResolver() {
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setApplicationContext(applicationContext);
        templateResolver.setPrefix("/WEB-INF/views/");
        templateResolver.setSuffix(".html");
        return templateResolver;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("src/main/webapp/WEB-INF/static/");
    }

    @Bean
    public SpringTemplateEngine templateEngine() {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver());
        templateEngine.setEnableSpringELCompiler(true);
        return templateEngine;
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
        resolver.setTemplateEngine(templateEngine());
        registry.viewResolver(resolver);
    }

    @Bean
    public JdbcTemplate getJdbcTemplate()
    {
        return new JdbcTemplate(getDataSource());
    }

    @Bean
    public DataSource getDataSource()
    {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setUrl("jdbc:mysql://localhost:3306/fin?useSll=false&serverTimezone=UTC");

        dataSource.setUsername("root");
        dataSource.setPassword("6406655");
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");

        return dataSource;
    }

    @Bean
    public OwnersDao getOwnersDao(){
        return new OwnersDao( getJdbcTemplate() );
    }

    @Bean
    public OwnersService getOwnersService(){
        return new OwnersService();
    }

    @Bean
    public WorkersDao getWorkersDao(){
        return new WorkersDao( getJdbcTemplate() );
    }

    @Bean
    public WorkersService getWorkersService(){
        return new WorkersService();
    }

    @Bean
    public OrdersDao getOrdersDao(){
        return new OrdersDao( getJdbcTemplate() );
    }

    @Bean
    public OrdersService getOrdersService(){
        return new OrdersService();
    }

    @Bean
    public MainUserDao getMainUserDao(){
        return new MainUserDao( getJdbcTemplate() );
    }

    @Bean
    public MainUserService getMainUserService(){
        return new MainUserService();
    }
}