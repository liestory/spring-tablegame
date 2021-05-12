package ru.tablegame;

import ma.glasnost.orika.MapperFacade;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;
import ru.tablegame.repository.CharacterRepository;
import ru.tablegame.repository.GameRepository;
import ru.tablegame.validator.CharacterDtoValidator;
import ru.tablegame.validator.GameDtoValidator;

@TestConfiguration
@ComponentScan(basePackages = {"ru.tablegame.service"})
@ContextConfiguration(initializers = {TestConfig.Initializer.class})
@Import(TestConfig.ConfigurationTests.class)
public class TestConfig {

    public static class Initializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
        @Override
        public void initialize(ConfigurableApplicationContext applicationContext) {
        }
    }

    @TestConfiguration
    public static class ConfigurationTests {

        @MockBean
        MessageSource messageSource;

        @MockBean
        CharacterRepository characterRepository;

        @MockBean
        GameRepository gameRepository;

        @MockBean
        CharacterDtoValidator characterDtoValidator;

        @MockBean
        GameDtoValidator gameDtoValidator;

        @MockBean
        MapperFacade mapperFacade;

    }

}
