package ru.tablegame.config.security;

import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.MappingContext;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import net.rakugakibox.spring.boot.orika.OrikaMapperFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import ru.tablegame.auth.model.User;
import ru.tablegame.auth.resource.dto.user.UserDto;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;

/**
 * @author nemykin 23.03.2021
 */
@Slf4j
@Component
public class MapperConfig implements OrikaMapperFactoryConfigurer {
    private final PasswordConverter passwordConverter;

    public MapperConfig(PasswordConverter passwordConverter) {
        this.passwordConverter = passwordConverter;
    }

    @Bean
    DatatypeFactory datatypeFactory() throws DatatypeConfigurationException {
        return DatatypeFactory.newInstance();
    }

    @Bean
    MappingContext.Factory mappingFactory() {
        var factory = new MappingContext.Factory();
        new DefaultMapperFactory.Builder().mappingContextFactory(factory).build();
        return factory;
    }

    @Override
    public void configure(MapperFactory orikaMapperFactory) {
        orikaMapperFactory.classMap(User.class, UserDto.class)
                .fieldMap("password", "password")
                .bToA().converter("passwordConverter").aToB().exclude().add()
                .byDefault()
                .register();

        var converterFactory = orikaMapperFactory.getConverterFactory();
        converterFactory.registerConverter("passwordConverter", passwordConverter);
    }
}