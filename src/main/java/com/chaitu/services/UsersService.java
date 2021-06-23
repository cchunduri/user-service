package com.chaitu.services;

import com.chaitu.dto.AppUserDto;
import com.chaitu.entities.AppUser;
import com.chaitu.exceptions.users.UserAlreadyExistsException;
import com.chaitu.repository.UsersRepository;

import javax.inject.Inject;
import javax.inject.Singleton;

import static com.chaitu.constants.AppConstants.USER_ALREADY_EXISTS;

@Singleton
public class UsersService {
    @Inject
    UsersRepository usersRepository;

    public void createUser(AppUserDto appUserDto) {
        AppUser appUser = AppUser.mapper(appUserDto);
        var usersList = usersRepository.findByEmail(appUser.getEmail());
        if (!usersList.isEmpty()) {
            throw new UserAlreadyExistsException(USER_ALREADY_EXISTS);
        }

        usersRepository.createUser(appUser);
    }
}
