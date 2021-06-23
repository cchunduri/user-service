package com.chaitu.services;

import com.chaitu.dto.appuser.AppUserDto;
import com.chaitu.entities.AppUser;
import com.chaitu.exceptions.users.UserAlreadyExistsException;
import com.chaitu.repository.UsersRepository;

import javax.inject.Inject;
import javax.inject.Singleton;

import static com.chaitu.constants.AppConstants.USER_ALREADY_EXISTS;

@Singleton
public class UsersService {
    @Inject UsersRepository usersRepository;

    public AppUserDto createUser(AppUserDto appUserDto) {
        AppUser appUser = AppUser.mapper(appUserDto);
        validateUser(appUser);

        return AppUserDto.mapper(usersRepository.createUser(appUser));
    }

    private void validateUser(AppUser appUser) {
        var usersListByEmail = usersRepository.findByEmail(appUser.getEmail());
        if (!usersListByEmail.isEmpty()) {
            throw new UserAlreadyExistsException(USER_ALREADY_EXISTS);
        }

        var usersListByPhoneNumber = usersRepository.findByPhoneNumber(appUser.getPhoneNumber());
        if (!usersListByPhoneNumber.isEmpty()) {
            throw new UserAlreadyExistsException(USER_ALREADY_EXISTS);
        }
    }
}
