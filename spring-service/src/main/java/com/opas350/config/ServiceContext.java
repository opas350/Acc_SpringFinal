package com.opas350.config;

import com.opas350.persistence.PersistenceJPAConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


/**
 * Created by javier.reyes.valdez on 3/2/2017.
 */
@Configuration
@Import(PersistenceJPAConfig.class)
@ComponentScan(basePackages="com.opas350.service")
public class ServiceContext {
}
