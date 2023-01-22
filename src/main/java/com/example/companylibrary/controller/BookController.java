package com.example.companylibrary.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "Book")
@RequestMapping("/book")
public class BookController {
    @GetMapping("/hello")
    @ApiOperation(
            value = "스웨거 테스트",
            notes = "로그인한 유저의 페이지에서, 회원 정보에 해당하는 부분을 불러오는 API")
    public String Hello(){
        return "hello";
    }
}
