package com.itheima.manger.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LoginQuery {
    private Integer id;
    private String username;
    private String name;
    private String password;
    private String token;
}
