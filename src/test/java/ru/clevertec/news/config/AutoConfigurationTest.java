package ru.clevertec.news.config;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;
import ru.clevertec.news.aspect.ControllerAspect;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class AutoConfigurationTest {

    private final ApplicationContextRunner contextRunner = new ApplicationContextRunner();

    @Test
    public void shouldCreateControllerBean() {
        contextRunner.withPropertyValues("starter.logging.enabled=true")
                .withUserConfiguration(AutoConfiguration.class)
                .run(context ->
                        assertThat(context).hasSingleBean(ControllerAspect.class)
                );
    }

    @Test
    public void shouldNotCreateControllerBean() {
        contextRunner.withPropertyValues("starter.logging.enabled=false")
                .withUserConfiguration(AutoConfiguration.class)
                .run(context ->
                        assertThat(context).doesNotHaveBean(ControllerAspect.class)
                );
    }
}