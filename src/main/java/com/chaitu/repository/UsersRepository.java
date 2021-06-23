package com.chaitu.repository;

import com.chaitu.entities.AppUser;
import com.chaitu.repository.criteria.UserCriteriaService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import java.util.List;

import static com.chaitu.constants.AppConstants.EMAIL;

@ApplicationScoped
public class UsersRepository {
    @Inject
    EntityManager entityManager;

    @Inject
    UserCriteriaService userCriteriaService;

    @Transactional
    public void createUser(AppUser appUser) {
        entityManager.persist(appUser);
    }

    public List<AppUser> findByEmail(String email) {
        return userCriteriaService.findUserBy(EMAIL, email);
    }
}
