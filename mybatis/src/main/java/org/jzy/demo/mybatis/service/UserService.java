package org.jzy.demo.mybatis.service;

import org.jzy.demo.mybatis.dao.UserDAO;
import org.jzy.demo.mybatis.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDAO dao;

    public List<User> listAll() {
        return dao.listAll();
    }

    @Cacheable(value = "users", key = "#id")
    public User get(Integer id) {
        User user = dao.get(id);
        if (user == null) {
            throw new RuntimeException("用户不存在");
        }
        return user;
    }

    @CachePut(value = "users", key = "#result.id")
    public User post(User user) {
        dao.post(user);
        return user;
    }

    @CacheEvict(value = "users", key = "#id")
    public void delete(Integer id) {
        int delete = dao.delete(id);
        if (delete == 0) {
            throw new RuntimeException("用户不存在");
        }
    }

    @CachePut(value = "users", key = "#user.id")
    public User put(User user) {
        int put = dao.put(user);
        if (put == 0) {
            throw new RuntimeException("用户不存在");
        }
        return user;
    }
}
