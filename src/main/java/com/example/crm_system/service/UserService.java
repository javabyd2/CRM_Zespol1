package com.example.crm_system.service;

import com.example.crm_system.model.User;
import com.example.crm_system.repository.UserRepository;
import com.example.crm_system.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


<<<<<<< HEAD

    private static final String DEFAULT_ROLE = "ROLE_USER";
    private UserRepository userRepository;
    private UserRoleRepository roleRepository;

    @Autowired
    public UserService(UserRepository userRepository, UserRoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Transactional
    public User addWithDefaultRole(User user) {
        UserRole defaultRole = roleRepository.findByRole(DEFAULT_ROLE);
        user.getRoles().add(defaultRole);
        userRepository.save(user);
        return user;
    }

    public void delete(User user){
        userRepository.delete(user);
    }
}
=======
public interface UserService {
    public User findUserByEmail(String email);
    public void saveUser(User user);
}


//@Service("userService")
//public class UserService {
//
//    @Autowired
//    private static final String DEFAULT_ROLE = "ROLE_USER";
//    @Autowired
//    private UserRepository userRepository;
//    @Autowired
//    private RoleRepository roleRepository;
//
//    //@Autowired
//    //private BCryptPasswordEncoder bCryptPasswordEncłoder;
//
//
//    @Autowired
//    public void setUserRepository(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//    @Autowired
//    public void setRoleRepository(RoleRepository roleRepository) {
//        this.roleRepository = roleRepository;
//    }
//
//    @Transactional
//    public User addWithDefaultRole(User user) {
//        UserRole defaultRole = roleRepository.findByRole(DEFAULT_ROLE);
//        user.getRoles().add(defaultRole);
//        userRepository.save(user);
//        return user;
//    }
//
//
//
//
//
//
//
//
//}
>>>>>>> adrian_reviewLogin
