package com.example.demo.Domain;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by jiazhijie on 2017/6/8 0008.
 */
@Repository
@Transactional
public class UserRepositoryImpl implements UserRepository {

    private Logger logger = Logger.getLogger(UserRepositoryImpl.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public User findByUsername(String username) {

        logger.info("ceshidata");
        User user =null;
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery( User.class );
        Root<User> root = query.from( User.class );
        query.select(root).where(builder.and(builder.equal(root.get("username"), username)));
        List<User> users = entityManager.createQuery(query).getResultList();

        if(users!=null && users.size()>0)
            user = users.get(0);

        for(User u:users){
            logger.info(u.toString());
        }

        return user;
    }


    @Override
    public List<User> findAll() {

        List<User> users ;
        CriteriaBuilder crit = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> query = crit.createQuery(User.class);
        users = entityManager.createQuery(query).getResultList();
        return users;
    }

    @Override
    public void save(User user) {
        entityManager.persist(user);
    }
}
