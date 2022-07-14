package com.berry.aptgetbuy.controller;

import com.berry.aptgetbuy.domain.dto.UserFindPasswordDto;
import com.berry.aptgetbuy.domain.dto.UserGetDto;
import com.berry.aptgetbuy.domain.dto.UserLoginDto;
import com.berry.aptgetbuy.domain.entity.User;
import com.berry.aptgetbuy.mapper.BlacklistMapper;
import com.berry.aptgetbuy.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.naming.AuthenticationException;
import javax.servlet.http.HttpServletRequest;
import java.nio.file.AccessDeniedException;

@CrossOrigin("*")
@RestController
@RequestMapping("users")
public class UserController {

    private final UserService userService;
    private final BlacklistMapper blacklistMapper;

    @Autowired
    public UserController(
            UserService userService,
            BlacklistMapper blacklistMapper
    ) {
        this.userService = userService;
        this.blacklistMapper = blacklistMapper;
    }

    @ApiOperation(value = "회원 조회", notes = "id를 통해 회원 정보를 조회")
    @GetMapping("/{id}")
    public UserGetDto getUser(@PathVariable String id) throws Exception {
        User user = userService.getUser(id);
        return new UserGetDto(
                user.getId(),
                user.getName(),
                user.getTel(),
                user.getBmk_addr_lv1(),
                user.getBmk_addr_lv2(),
                user.getBmk_addr_lv3(),
                user.getBmk_addr_lv4(),
                user.getRole()
        );
    }

    @ApiOperation(value = "회원 조회", notes = "id를 통해 회원 정보를 조회")
    @GetMapping("/auth/{id}")
    public String getUserWith(@PathVariable String id) throws Exception {
        return userService.getUser(id) != null ? "yes" : "no";
    }

    @ApiOperation(value = "회원 등록", notes = "User 객체를 통해 신규 회원을 등록")
    @PostMapping("/auth")
    public User registerUser(@RequestBody User user) throws Exception {
        return userService.registerUser(user);
    }

    @ApiOperation(value = "회원 수정", notes = "id와 User 객체를 통해 기존 회원 정보를 수정")
    @PutMapping("/{id}")
    public User modifyUser(@PathVariable String id, @RequestBody User user) throws Exception {
        if (!checkIdIsEqualToTarget(id, user)) {
            throw new IllegalArgumentException("요청 id와 변경 id가 다릅니다");
        }
        return userService.modifyUser(user);
    }

    @ApiOperation(value = "로그인", notes = "id와 pw를 통해 로그인")
    @PostMapping("/auth/login")
    public ResponseEntity<String> login(@RequestBody UserLoginDto userLoginDto) throws Exception {
        String token = userService.login(userLoginDto.getId(), userLoginDto.getPw());
        return new ResponseEntity<>(token, HttpStatus.OK);
    }

    @ApiOperation(value = "로그인 정보 조회", notes = "현재 로그인되어 있는 계정 정보를 조회")
    @GetMapping("/login/current")
    public User getCurrentUser(HttpServletRequest request) throws Exception {
        String id = (String)request.getAttribute("userId");
        User user = userService.getUser(id);
        if (!checkUserExists(user)) {
            throw new AuthenticationException("존재하지 않는 아이디");
        } else {
            return user;
        }
    }

    @ApiOperation(value = "분실 비밀번호 갱신", notes = "id, tel, name을 통해 분실 비밀번호 갱신")
    @PostMapping("/auth/forget-password")
    public String findPassword(
            @RequestBody UserFindPasswordDto userFindPasswordDto
    ) throws Exception {
        String id = userFindPasswordDto.getId();
        String name = userFindPasswordDto.getName();
        String tel = userFindPasswordDto.getTel();
        String newPw = userFindPasswordDto.getNewPw();

        User user = userService.getUser(id);
        user.setPw(newPw);
        if (!checkUserExists(user)) {
            throw new AuthenticationException("존재하지 않는 아이디입니다.");
        } if (!checkNameAndTelEqualsTarget(user, name, tel)) {
            throw new AccessDeniedException("이름 또는 전화번호가 일치하지 않습니다.");
        } else {
            userService.modifyUser(user);
        }

        return "success";
    }

    @ApiOperation(value = "로그아웃", notes = "현재 로그인된 계정을 로그아웃 처리")
    @PostMapping("/logout")
    public String logout(HttpServletRequest request) throws Exception {
        String id = (String)request.getAttribute("userId");
        blacklistMapper.add(id);
        return "success";
    }

    private boolean checkIdIsEqualToTarget(String id, User user) {
        return id.equals(user.getId());
    }

    private boolean checkUserExists(User user) {
        return user != null;
    }

    private boolean checkNameAndTelEqualsTarget(User user, String name, String tel) {
        return user.getName().equals(name) && user.getTel().equals(tel);
    }

}
