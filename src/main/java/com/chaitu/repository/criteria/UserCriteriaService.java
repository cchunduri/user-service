package com.chaitu.repository.criteria;

import com.chaitu.entities.AppUser;
import com.chaitu.repository.utils.HibernateUtils;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Any;
import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;

@Singleton
public class UserCriteriaService {

    @Any
    @Inject
    HibernateUtils<AppUser> hibernateUtils;

    public List<AppUser> findUserBy(String field, Object value) {
        return hibernateUtils.select(AppUser.class, field, value);
    }
}
