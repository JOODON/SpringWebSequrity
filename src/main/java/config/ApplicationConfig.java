package config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = {"dao","service"})
@EnableTransactionManagement
public class ApplicationConfig implements TransactionManagementConfigurer {

    private String driverClassName = "com.mysql.cj.jdbc.Driver";

    private String url="jdbc:mysql://localhost:3307/MBTIDB";
    private String username="root";
    private String password="kkjjss103@";

    @Bean
    public DataSource dataSource(){
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);

        return dataSource;
    }
    @Bean
    public PlatformTransactionManager transactionManager(){
        return new DataSourceTransactionManager(dataSource());
    }
    @Override
    public PlatformTransactionManager annotationDrivenTransactionManager(){
        return transactionManager();
    }
}
