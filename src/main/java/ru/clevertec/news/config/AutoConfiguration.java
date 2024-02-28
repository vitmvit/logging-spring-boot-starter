package ru.clevertec.news.config;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.clevertec.news.aspect.ControllerAspect;

@Slf4j
@Configuration
@ConditionalOnProperty(prefix = "aop.logging", name = "enabled", havingValue = "true", matchIfMissing = true)
public class AutoConfiguration {

    /**
     * Инициализирует класс AutoConfiguration и регистрирует сообщение инициализации
     */
    @PostConstruct
    void init() {
        log.info("AutoConfiguration initialized");
    }

    /**
     * Возвращает bean-компонент ControllerAspect
     *
     * @return ControllerAspect bean.
     */
    @Bean
    @ConditionalOnMissingBean
    public ControllerAspect loggingAspect() {
        return new ControllerAspect();
    }
}
