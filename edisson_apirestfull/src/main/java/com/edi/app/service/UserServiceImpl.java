package com.edi.app.service;

import com.edi.app.entity.Usuario;
import com.edi.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl extends GenericServiceImpl<Usuario, Integer> implements UserService{

        @Autowired
        private UserRepository userRepository;

        @Override
        public CrudRepository<Usuario, Integer> getDao() {
            return userRepository;
        }
}
