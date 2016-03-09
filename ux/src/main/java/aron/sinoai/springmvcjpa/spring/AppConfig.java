package aron.sinoai.springmvcjpa.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan
@Import(PersistenceConfig.class)
public class AppConfig {


}