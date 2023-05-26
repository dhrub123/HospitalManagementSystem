package com.hospital.frontdesk.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableJpaAuditing
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "primaryEntityManagerFactoryModule",
        transactionManagerRef = "primaryTransactionManagerModule",
        basePackages = {"com.hospital.frontdesk.dao"}
)
public class PostGreConfig {

    @Primary
    @Bean(name = "primaryEntityManagerFactoryModule")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
            final EntityManagerFactoryBuilder builder,
            @Qualifier("primaryDatasourceModule") final DataSource datasource,
            final Environment env
            ){
        return builder.dataSource(datasource).packages("com.hospital.frontdesk.dao")
                .persistenceUnit("primaryModuleUnit").build();
    }

    @Primary
    @Bean(name = "primaryDatasourceModule")
    @ConfigurationProperties(prefix = "datasource.primary.database")
    public DataSource datasource(){
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean(name = "primaryTransactionManagerModule")
    public PlatformTransactionManager transactionManager(
            @Qualifier("primaryEntityManagerFactoryModule") final EntityManagerFactory entityManagerFactory
            ){
        return new JpaTransactionManager(entityManagerFactory);
    }
}
