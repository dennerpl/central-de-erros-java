package dev.codenation.Central.de.Erros.controller;

import dev.codenation.Central.de.Erros.model.User;
import dev.codenation.Central.de.Erros.service.Impl.UserServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@Api(value="API User Rotas")
@CrossOrigin(origins ="*" )
@RequestMapping("/users")
public class UserController {

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    private final UserServiceImpl userService;




    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "User returned"),
            @ApiResponse(code = 500, message = "Internal error")
    })
    @ApiOperation("Find a user by email")
    @GetMapping
    public Optional<User> FindByEmail(@RequestBody User user) {
        return userService.FindByEmail(user.getEmail());
    }


    @RequestMapping(value = "/", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "User returned"),
            @ApiResponse(code = 500, message = "Internal error")
    })
    @ApiOperation("Create a new User")
    @PostMapping
    public User CreateUser(@RequestBody User user) {
        return userService.SaveUser(user);
    }
}