/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testDao;

//import com.generation.beans.Modules;

import com.generation.beans.Modules;
import com.generation.beans.Tokens;
import dao.GenericDao;
import java.util.Date;
import java.util.List;
import util.Hash;
import util.RegexU;

//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mock;
//import org.mockito.runners.MockitoJUnitRunner;




/**
 *
 * @author root
 */
//@RunWith(MockitoJUnitRunner.class)
public class TestGenericDao {

    public static void main(String[] args) {
        //System.out.println(RegexU.isMail("nincub111._-@com.mx"));
        String a = Hash.convertirSHA_1("adssssssssssssssshola");
        System.out.println(a);
        System.out.println(RegexU.isValidToken(a + ":11111"));
        
    }
    
    
    
}

class Prueba <T> {
//    public void prueba (T t) {
//        System.out.println("Only getClass() " + t.getClass());
//        System.out.println("With simpleName()" + t.getClass().getSimpleName());
//        Object obj = new Object();
//        
//    }
    
//     public void consulta () {
//        GenericDao dao = new GenericDao();
//        List<Tokens> users = dao.getAll(Tokens.class.getSimpleName());
//        for (Tokens usu : users) {
//            System.out.println(usu.toString());
//        }
        //System.out.println(List.class.cast(Tokens.class.cast(users.get(0)).getStatus()).get(0).toString());
//    }
     
        public void consultaCol () {
            GenericDao dao = new GenericDao();
            Tokens t = (Tokens) dao.get(2, Tokens.class);
            System.err.println(t != null ? t.toString() : "null");
            
            List<Tokens> list = dao.getAll(Tokens.class.getSimpleName());
            System.out.println((!list.isEmpty()) ? list.get(0) : "null");
            
            list = dao.getByParameter(Tokens.class.getSimpleName(), "token", "FFFF");
            System.out.println((!list.isEmpty()) ? list.get(0) : "null");
        }
        Hash nuevo = new Hash();
        
        
        
        
        
        
        
        
}
