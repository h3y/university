package com.server.dao;

import com.server.model.AccessKey;
import com.server.service.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by Slavik Glodan on 09.12.2016.
 */

public class AccessKey1 {

    private final Logger logger = Logger.getLogger(AccessKey.class);

    public AccessKey getAccessKey(String key) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();

        AccessKey accessKey = null;
        CriteriaBuilder builder = session.getCriteriaBuilder();

        CriteriaQuery<AccessKey> criteria = builder.createQuery( AccessKey.class );
        Root<AccessKey> root = criteria.from( AccessKey.class );

        criteria.where(builder.equal(root.get("key"), key));

        accessKey = session.createQuery(criteria).getSingleResult();

        session.getTransaction().commit();
        session.close();

        return accessKey;

    }

//
//    public void addAccessKey(AccessKey accessKey) {
//        Session session = null;
//        Transaction tx = null;
//        try {
//            session = HibernateUtil.getSessionFactory().openSession();
//            tx = session.beginTransaction();
//            session.save(accessKey);
//            tx.commit();
//        } catch (HibernateException ex) {
//            if (tx != null) {
//                tx.rollback();
//            }
//            logger.log(Level.FATAL, ex);
//        } finally {
//            session.close();
//        }
//    }
//
//    public void updateAccessKey(AccessKey accessKey) {
//        Session session = null;
//        Transaction tx = null;
//        try {
//            session = HibernateUtil.getSessionFactory().openSession();
//            tx = session.beginTransaction();
//            session.update(accessKey);
//            tx.commit();
//        } catch (HibernateException ex) {
//            if (tx != null) {
//                tx.rollback();
//            }
//            logger.log(Level.FATAL, ex);
//        } finally {
//            session.close();
//        }
//    }
//
//    public void deleteAccessKey(AccessKey accessKey) {
//        Session session = null;
//        Transaction tx = null;
//        try {
//            session = HibernateUtil.getSessionFactory().openSession();
//            tx = session.beginTransaction();
//            session.delete(accessKey);
//            tx.commit();
//        } catch (HibernateException ex) {
//            if (tx != null) {
//                tx.rollback();
//            }
//            logger.log(Level.FATAL, ex);
//        } finally {
//            session.close();
//        }
//    }
}
