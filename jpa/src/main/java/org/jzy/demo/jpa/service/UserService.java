package org.jzy.demo.jpa.service;

import org.jzy.demo.jpa.dao.UserDAO;
import org.jzy.demo.jpa.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserDAO dao;

    public List<User> listAll() {
        return dao.findAll();
    }

    @Cacheable(value = "users", key = "#id")
    public User get(Integer id) {
        Optional<User> byId = dao.findById(id);
        if (!byId.isPresent()) {
            throw new RuntimeException("用户不存在");
        }
        return byId.get();
    }

    @CachePut(value = "users", key = "#result.id")
    public User post(User user) {
        user.setId(null); // id自动生成
        return dao.save(user);
    }

    @CacheEvict(value = "users", key = "#id")
    public void delete(Integer id) {
        if (!dao.existsById(id)) {
            throw new RuntimeException("用户不存在");
        }
        dao.deleteById(id);
    }

    @CachePut(value = "users", key = "#user.id")
    public User put(User user) {
        if (!dao.existsById(user.getId())) {
            throw new RuntimeException("用户不存在");
        }
        return dao.save(user);
    }
}
