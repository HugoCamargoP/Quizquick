/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author root
 */
public interface IDao <T> {
    
    void initOperation () throws HibernateException;
    
    void handleException (T t) throws HibernateException;
    
    int save (T t);
    
    int update (T t);
    
    int delete (T t);
    
    T get (int id);
    
    List<T> getAll ();
    
}
