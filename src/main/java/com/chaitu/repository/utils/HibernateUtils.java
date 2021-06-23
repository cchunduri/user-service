package com.chaitu.repository.utils;

import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
@Singleton
public class HibernateUtils<T> {

    @Inject
    EntityManager entityManager;

    public Session getSession() {
        return entityManager.unwrap(Session.class);
    }

    public CriteriaBuilder getCriteriaBuilder(Class<T> className) {
        return getSession()
                .getCriteriaBuilder();
    }

    public CriteriaQuery<T> getCriteriaQuery(Class<T> className) {
        return getCriteriaBuilder(className)
                .createQuery(className);
    }

    public CriteriaQuery<T> getCriteriaQuery(CriteriaBuilder criteriaBuilder, Class<T> className) {
        return criteriaBuilder
                .createQuery(className);
    }

    public List<T> select(Class<T> className, String fieldName, String value) {
        var criteriaBuilder = getCriteriaBuilder(className);
        var criteriaQuery = getCriteriaQuery(criteriaBuilder, className);
        var rootObject = criteriaQuery.from(className);

        var queryObject = criteriaQuery.select(rootObject)
                .where(criteriaBuilder.equal(rootObject.get(fieldName), value));

        Query<T> query = getQuery(queryObject);
        return query.getResultList();
    }

    private Query<T> getQuery(CriteriaQuery<T> criteriaQuery) {
        return getSession()
                .createQuery(criteriaQuery);
    }
}
