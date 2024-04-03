package org.example.configuration;

import org.example.aspects.LoggingAspect;
import org.example.model.Comment;
import org.example.services.CommentService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.util.logging.Logger;

@Configuration
@ComponentScan(basePackages = "org.example")
// чтобы добавить работу с аспектами
@EnableAspectJAutoProxy
public class ProjectConfiguration {

    // принудительно кладем аспект внутрь контейнера, иначе работать не будет.
    @Bean
    public LoggingAspect aspect() {
        return new LoggingAspect();
    }

}
