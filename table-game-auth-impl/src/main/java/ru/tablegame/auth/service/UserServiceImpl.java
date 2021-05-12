package ru.tablegame.auth.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.MapperFacade;
import org.reactivestreams.Publisher;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.tablegame.auth.model.User;
import ru.tablegame.auth.repository.UserRepository;
import ru.tablegame.auth.resource.dto.Search;
import ru.tablegame.auth.resource.dto.user.UserDto;
import ru.tablegame.auth.resource.dto.user.UserSearchDto;

import javax.annotation.PostConstruct;
import javax.persistence.criteria.Predicate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static java.util.UUID.randomUUID;

/**
 * @author Asus 14.10.2020
 */
@Service
@Slf4j
@AllArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private final MapperFacade mapperFacade;

    @PostConstruct
    public void postConstruct() {
        log.info("postConstruct");
    }

    @Override
    public Mono<UserDto> regUser(UserDto userDto) {
        User user = mapperFacade.map(userDto, User.class);
        user.setId(randomUUID());
        user.setActiveUser(true);
        userRepository.save(user);
        return Mono.when((Iterable<? extends Publisher<?>>) userRepository.save(user))
                .then(Mono.fromSupplier(() -> mapperFacade.map(user, UserDto.class)));
    }

    @Override
    public Mono<UserDto> getUser(UUID id) {
        return Mono.fromSupplier(() ->
                userRepository.findById(id)
                        .map(user -> mapperFacade.map(user, UserDto.class))
                        .orElseThrow(() -> new IllegalArgumentException("There wasn't found user with id = " + id))
        );
    }

    @Override
    public Mono<UserDto> updateUser(UserDto userDto) {
        User user = userRepository.getOne(userDto.getId());
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        return Mono.when((Iterable<? extends Publisher<?>>) userRepository.save(user))
                .then(Mono.fromSupplier(() -> userDto));
    }

    @Override
    public Mono<Void> deleteUser(UUID id) {
        return Mono.fromRunnable(() -> userRepository.deleteById(id));
    }

    @Override
    public void addUser(User user) {
        log.info("now: " + LocalDateTime.now() + " UserService: " + this.toString());
        userRepository.save(user);
    }

    @Override
    public Flux<UserDto> getUsers(Search<UserSearchDto> userSearchDto) {
        return Flux.fromIterable(userRepository.findAll(getSpec(userSearchDto.getData()), getOf(userSearchDto)))
                .map(user -> mapperFacade.map(user, UserDto.class));
    }

    private PageRequest getOf(Search<UserSearchDto> userSearchDto) {
        var page = userSearchDto.getPage();
        return PageRequest.of(page.getPage(), page.getSize());
    }

    private Specification<User> getSpec(UserSearchDto userSearchDto) {
        return (root, query, builder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (userSearchDto.getUsername() != null) {
                predicates.add(root.get("username").in(userSearchDto.getUsername()));
            }
            return builder.and(predicates.toArray(Predicate[]::new));
        };
    }
}
