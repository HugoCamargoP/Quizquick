/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import hibernate.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author root
 * @param <T>
 */
public class GenericDao<T> {

    private Session session;
    private Transaction tx;

    public void initOperation() throws HibernateException {
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
    }

    public void manejaException(HibernateException he) throws HibernateException {
        tx.rollback();
        throw new UnsupportedOperationException("Ocurrio un error en la capa de datos" + he);
    }

    public int save(T t) {
        int id = 0;
        try {
            initOperation();
            id = (int) session.save(t);
            tx.commit();
        } catch (HibernateException he) {
            manejaException(he);
            throw he;
        } finally {
            session.close();
        }
        return id;
    }

    public boolean update(T t) {
        try {
            initOperation();
            session.update(t);
            tx.commit();
            return true;
        } catch (HibernateException he) {
            manejaException(he);
            throw he;
        } finally {
            session.close();
        }
    }

    public boolean delete(T t) {
        try {
            initOperation();
            session.delete(t);
            tx.commit();
            return true;
        } catch (HibernateException he) {
            manejaException(he);
            throw he;
        } finally {
            session.close();
        }
    }

    public T get(int id, T classT) {
        T t = null;
        try {
            initOperation();
            t =  (T) session.get(classT.getClass(), id);
        } finally {
            session.close();
        }
        return t;
    }

    public List<T> getAll(T t) {
         List<T>  list = null;
       try {
           initOperation();
           list = session.createQuery("from "+ t).list();
           //users = session.createQuery("from " + columna).list();
           
       } finally {
           session.close();
       }
       return list;
    }

}
