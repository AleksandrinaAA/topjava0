package ru.javawebinar.topjava.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import ru.javawebinar.topjava.DAO.UserDAO;
import ru.javawebinar.topjava.DAO.UserDAOImpl;
import ru.javawebinar.topjava.service.TestBean;
import ru.javawebinar.topjava.service.UserService;
import ru.javawebinar.topjava.service.UserServiceImpl;

import javax.sql.DataSource;

//Automatically install Beans
@Configuration
@ComponentScan(basePackages = {"ru.javawebinar.topjava.service","ru.javawebinar.topjava.DAO"})
public class SpringConfig {

    @Bean
    public TestBean getTestBean(){
        return new TestBean("Hello");
    }

    @Bean
    public JdbcTemplate getJdbcTemplate(){
        return new JdbcTemplate(getDataSource());
    }

    @Bean
    public DataSource getDataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/topjava?serverTimezone=UTC");
        dataSource.setUsername("root");
        dataSource.setPassword("7a3l9e1k4c");
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        return dataSource;
    }


//    @Bean
//    public UserDAO getUserDAO(){
//        return new UserDAOImpl(getJdbcTemplate());
//    }

//    @Bean
//    public UserService getUserService(){
//        return new UserServiceImpl();
//    }
}
