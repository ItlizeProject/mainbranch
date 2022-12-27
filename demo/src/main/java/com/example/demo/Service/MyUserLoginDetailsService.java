package com.example.demo.Service;

import com.example.demo.Repository.UserRepository;
import com.example.demo.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Service;
import java.util.*;

//Spring Security
//what is the role of the class? A:用来通过用户名获取用户及权限信息
//UserController class @Autowired this class and use the  "MyUserLoginDetailsService userService;" to call methods in this class
//需要自定义逻辑时，只需要实现 UserDetailsService 接口即可
@Service
public class MyUserLoginDetailsService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    //method loadUserByUsername（）是UserDetailsService接口里的一个method，在这里override后自己定义识别用户的具体要求
    //input "String username" means标识需要其数据的用户的用户名
    //返回值"UserDetails" is an interface,返回的是授予用户的权限
    //UserController里调用了这个方法
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(username).orElse(null);
        if(user == null){
            throw new UsernameNotFoundException(username);
        }

        Collection <GrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority(user.getUserType()));
/*
要想返回 UserDetails 的实例就只能返回UserDetails接口的实现类。SpringSecurity 中提供了User 类作为实例。注意 User 的全限定路径是：
org.springframework.security.core.userdetails.User 此处经常和系统中自己开发的 User 类弄混：
特别注意：该User不是该project entity里自定义的User,而是spring security里提供的当前方法返回值UserDetails 接口的实现类 */
        //下面的authorities包含的所有内容为此用户具有的权限
        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getUserPassword(), authorities);
    }

}