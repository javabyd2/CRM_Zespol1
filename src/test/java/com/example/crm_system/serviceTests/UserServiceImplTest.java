package com.example.crm_system.serviceTests;

import com.example.crm_system.model.User;
import com.example.crm_system.repository.RoleRepository;
import com.example.crm_system.repository.UserRepository;
import com.example.crm_system.service.UserService;
import com.example.crm_system.service.UserServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
public class UserServiceImplTest {

    @TestConfiguration
    static class UserServiceImplTestContextConfiguration{

        @Bean
        public UserService userService(){
            return new UserServiceImpl();
        }
    }

    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    @MockBean
    private RoleRepository roleRepository;

    @MockBean
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Before
    public void setUp(){
        User adam = new User();
        adam.setEmail("adam@test.pl");
        adam.setId(1L);
        Mockito.when(userRepository.findByEmail(adam.getEmail())).thenReturn(adam);
    }

    @Test
    public void whenValidEmail_thenUserShouldBeFound(){
        String email = "adam@test.pl";
        User found = userService.findUserByEmail(email);
        assertThat(found.getEmail()).isEqualTo(email);
    }

    @Test
    public void whenSaved_roleAndActiveAreSetToUser(){
        int active = 1;
        User user = new User();
        userService.saveUser(user);
        assertThat(user.getActive()).isEqualTo(active);
        assertThat(user.getRoles()).isNotNull();
        assertThat(user.getRoles().size()).isEqualTo(active);
    }

//    @Test
//    public void whenValidId_thenUserShouldBeFound(){
//        Long id = 1L;
//        User found = userService.getUserById(id);
//        assertThat(found.getId()).isEqualTo(id);
//    }
//
//    @Test
//    public void whenEditedOnlyPasswordAndEmailCanBeChanged(){
//        User beforeEditedUser = new User(1L,
//                "Adam",
//                "test@test.pl",
//                "ToBeEdited",
//                "Test",
//                1,
//                new HashSet<>(Arrays.asList(new Role())));
//        User afterEditUser = new User(2L,
//                "Ewa",
//                "edited@edited.pl",
//                "Edited",
//                "Edited",
//                0,
//                new HashSet<>(Arrays.asList(new Role())));
//        userService.editUser(beforeEditedUser.getId(), afterEditUser);
//
//        assertThat(beforeEditedUser.getId()).isNotEqualTo(afterEditUser.getId());
//    }


}
