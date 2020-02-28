package com.base.movingwalls.controller;

import com.base.movingwalls.model.user.UserInfo;
import com.base.movingwalls.repository.UserRepository;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.async.DeferredResult;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

import static com.base.movingwalls.service.impl.user.UserServiceFacade.*;
import static provider.DeferredResultProvider.createDeferredResult;
import static provider.DeferredResultProvider.createDeferredResultTwoTrack;

@RestController
@RequestMapping("/oauth")
@Api(value = "Api Provides Users Details")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @ApiOperation(
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            value = "User Details",
            notes = "Get All User Details")
    @ApiResponses({
            @ApiResponse(code = HttpServletResponse.SC_OK, message = "OK"),
            @ApiResponse(code = HttpServletResponse.SC_NOT_FOUND, message = "Data not found"),
            @ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, message = "Invalid request"),
            @ApiResponse(code = HttpServletResponse.SC_INTERNAL_SERVER_ERROR, message = "Internal server error")
    })
    @RequestMapping(method = RequestMethod.GET)
    public DeferredResult<ResponseEntity<List<UserInfo>>> getAllUsers() {
        return createDeferredResult(findAll()
                .with(userRepository), HttpStatus.OK);
    }

    @ApiOperation(
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            value = "save new user",
            notes = "save new user")
    @RequestMapping(method = RequestMethod.POST)
    public DeferredResult<ResponseEntity<UserInfo>> saveUser(
            @ApiParam(name = "UserInfo", value = "New user info in json", required = true)
            @RequestBody final UserInfo userInfo) {
        return createDeferredResult(save(userInfo).with(userRepository), HttpStatus.CREATED);
    }

    @ApiOperation(
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            value = "Get User by id", notes = "Get User Details by id")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public DeferredResult<ResponseEntity<UserInfo>> get(
            @ApiParam(value = "User id", name = "id")
            @PathVariable final Long id) {
        return createDeferredResultTwoTrack(find(id).with(userRepository), HttpStatus.OK);
    }

    @ApiOperation(
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            value = "update User by id",
            notes = "update User Details by id")
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public DeferredResult<ResponseEntity<UserInfo>> updateCategorry(
            @ApiParam(value = "user id", name = "user Id", required = true)
            @PathVariable final Long id,
            @ApiParam(value = "user info in json with updated values", name = "userInfo", required = true)
            @RequestBody final UserInfo userInfo) {
        return createDeferredResult(update(id, userInfo).with(userRepository), HttpStatus.OK);
    }


    @ApiOperation(
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            value = "remove user by id",
            notes = "remove user Details by id")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public DeferredResult<ResponseEntity<Long>> remove(
            @ApiParam(value = "user id", name = "userId", required = true)
            @PathVariable final Long id) {
        return createDeferredResult(delete(id).with(userRepository), HttpStatus.OK);
    }

}
