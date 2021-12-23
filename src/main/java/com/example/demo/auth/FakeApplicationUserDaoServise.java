package com.example.demo.auth;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.example.demo.security.ApplicationUserRole.*;

@Repository("fake")
public class FakeApplicationUserDaoServise implements ApplicationUserDao {

    @Autowired
    PasswordEncoder encoder;

    @Override
    public Optional<ApplicationUser> selectApplicationUserByUsername(String username) {
        return getApplicationUsers()
                .stream()
                .filter(applicationUser -> applicationUser.getUsername().equals(username))
                .findFirst();
    }

    private List<ApplicationUser> getApplicationUsers() {

        List<ApplicationUser> applicationUsers = Lists.newArrayList(

                new ApplicationUser(STUDENT.getGrantedAuthorities(),
                        encoder.encode("1234"),
                        "annasmith",
                        true,
                        true,
                        true,
                        true
                ),

                new ApplicationUser(ADMIN.getGrantedAuthorities(),
                        encoder.encode("1234"),
                        "linda",
                        true,
                        true,
                        true,
                        true
                ),

                new ApplicationUser(ADMINTRAINEE.getGrantedAuthorities(),
                        encoder.encode("1234"),
                        "tom",
                        true,
                        true,
                        true,
                        true
                )
        );


        return applicationUsers;
    }
}
