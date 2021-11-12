package com.xxl.business.controller;

import com.xxl.business.domain.CommonResult;
import com.xxl.business.domain.User;
import com.xxl.business.feign.BusinessBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserFeignController {
    @Autowired
    private BusinessBService businessBService;

    @GetMapping("/{id}")
    public CommonResult getUser(@PathVariable Long id) {
        return businessBService.getUser(id);
    }

    @GetMapping("/getByUsername")
    public CommonResult getByUsername(@RequestParam String username) {
        return businessBService.getByUsername(username);
    }

    @PostMapping("/create")
    public CommonResult create(@RequestBody User user) {
        return businessBService.create(user);
    }

    @PostMapping("/update")
    public CommonResult update(@RequestBody User user) {
        return businessBService.update(user);
    }

    @PostMapping("/delete/{id}")
    public CommonResult delete(@PathVariable Long id) {
        return businessBService.delete(id);
    }
}
