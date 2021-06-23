package com.chaitu.repository;

import com.chaitu.entities.AppUser;
import com.chaitu.repository.criteria.UserCriteriaService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import java.util.List;

import static com.chaitu.constants.AppConstants.EMAIL;
import static com.chaitu.constants.AppConstants.PHONE_NUMBER;

@ApplicationScoped
public class UsersRepository {
    @Inject
    EntityManager entityManager;

    @Inject
    UserCriteriaService userCriteriaService;

    @Transactional
    public AppUser createUser(AppUser appUser) {
        entityManager.persist(appUser);
        return appUser;
    }

    public List<AppUser> findByEmail(String email) {
        return userCriteriaService.findUserBy(EMAIL, email);
    }

    public List<AppUser> findByPhoneNumber(Long phoneNumber) {
        return userCriteriaService.findUserBy(PHONE_NUMBER, phoneNumber);
    }
}
