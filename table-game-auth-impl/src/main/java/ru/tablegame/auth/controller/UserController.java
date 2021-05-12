package ru.tablegame.auth.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.tablegame.aspect.annotation.Audit;
import ru.tablegame.aspect.annotation.AuditCode;
import ru.tablegame.auth.resource.UserResource;
import ru.tablegame.auth.resource.dto.Search;
import ru.tablegame.auth.resource.dto.user.UserDto;
import ru.tablegame.auth.resource.dto.user.UserSearchDto;
import ru.tablegame.auth.service.UserService;
import ru.tablegame.auth.validator.UserDtoValidator;

import java.net.URI;
import java.util.Objects;
import java.util.UUID;

/**
 * @author nemykin 28.10.2020
 */
@RestController
@Slf4j
public class UserController implements UserResource {

    private UserService userService;
    private UserDtoValidator userDtoValidator;

    public UserController(UserService userService, UserDtoValidator userDtoValidator) {
        this.userService = userService;
        this.userDtoValidator = userDtoValidator;
    }

    /**
     * блок CRUD
     */
    //create
    @Override
    @Audit(AuditCode.USER_CREATE)
    public Mono<ResponseEntity<UserDto>> createUser(@RequestBody UserDto userDto, UriComponentsBuilder componentsBuilder) {
        log.debug("create with {} - start ", userDto);
        userDtoValidator.validate(userDto);
        var result = userService.regUser(userDto);
        return result.flatMap(user -> {
            URI uri = componentsBuilder.path("/api/v1/location/" + user.getId()).buildAndExpand(result).toUri();
            return Mono.just(ResponseEntity.created(uri).body(user));
        }).doOnSuccess(rs -> log.debug("create end with result {}", rs));
    }

    //GET
    @Override
    @Audit(AuditCode.USER_GET)
    public Mono<ResponseEntity<UserDto>> getUser(@PathVariable("id") UUID id) {
        log.debug("get with {} - start ", id);
        var result = userService.getUser(id);
        return result
                .flatMap(user -> Mono.just(ResponseEntity.ok().body(user)))
                .doOnSuccess(user -> log.debug("get end with {}, with result {}", id, user));
    }

    //UPDATE
    @Override
    @Audit(AuditCode.USER_UPDATE)
    public Mono<ResponseEntity> updateUser(@RequestBody UserDto userDto, @PathVariable("id") UUID id) {
        log.debug("update with {} - start ", userDto);
        if (!Objects.equals(id, userDto.getId())) {
            throw new IllegalArgumentException("id=" + userDto.getId() + ": expected same as " + id);
        }
        userDtoValidator.validate(userDto);
        var result = userService.updateUser(userDto);
        return result
                .flatMap(user -> Mono.just(new ResponseEntity(HttpStatus.OK)))
                .doOnSuccess(user -> log.debug("update with {} - end", user));
    }

    //delete
    @Override
    @Audit(AuditCode.USER_DELETE)
    public Mono<ResponseEntity> deleteUser(@PathVariable("id") UUID id) {
        log.debug("delete with {} - start ", id);
        var result = userService.deleteUser(id);
        return result
                .flatMap(user -> Mono.just(new ResponseEntity(HttpStatus.OK)))
                .doOnSuccess(user -> log.debug("delete end with {}", id));
    }

    @Override
    public Flux<UserDto> getUsers(@RequestBody Search<UserSearchDto> userSearchDto) {
        log.debug("getUser with {} - start ", userSearchDto);
        var result = userService.getUsers(userSearchDto);
        log.debug("getUser end with {}, with result {}", userSearchDto, result);
        return result;
    }
}
