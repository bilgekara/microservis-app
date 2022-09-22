package com.bilgeli.accountservice.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.cassandra.CassandraProperties;
import org.springframework.boot.autoconfigure.cassandra.CqlSessionBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.CqlSessionFactoryBean;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

@Configuration
@EnableCassandraRepositories // gorduğu cas. repositorylerinin instancelarını yaratacak
public class CassandraConfiguration extends AbstractCassandraConfiguration {
    @Value("${spcloud.cassandra.contact.point}") //app.prop dosyası içinden getircek
    private String contactPoint;
    @Value("${spcloud.cassandra.port}") //app.prop dosyası içinden getircek
    private int port;
    @Value("${spcloud.cassandra.keyspace.name}") //app.prop dosyası içinden getircek
    private String keyspaceName;
    @Value("${spcloud.cassandra.username}") //app.prop dosyası içinden getircek
    private String username;
    @Value("${spcloud.cassandra.password}") //app.prop dosyası içinden getircek
    private String password ;

    @Override
    protected String getKeyspaceName() {
        return keyspaceName;
    }

    @Override
    protected int getPort() {
        return port;
    }

    @Override
    protected String getContactPoints() {
        return contactPoint;
    }

    @Override
    public SchemaAction getSchemaAction() {
        return SchemaAction.CREATE_IF_NOT_EXISTS;
    }

    @Override
    public String[] getEntityBasePackages() {
        return new String[]{"com.bilgeli.accountservice"};
    }

    /*public CqlSessionFactoryBean cassandraSession(){
        CqlSessionFactoryBean cassandraSession = super.cassandraSession();
        cassandraSession.setUsername(username);
        cassandraSession.setPassword(password);
        return cassandraSession;
    }*/

    @Bean
    CqlSessionBuilderCustomizer authCustomizer(CassandraProperties properties) {
        properties.setUsername(username);
        properties.setPassword(password);
        return (builder) -> builder.withAuthCredentials(properties.getUsername(), properties.getPassword());
    }
}
