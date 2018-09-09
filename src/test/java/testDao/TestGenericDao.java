/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testDao;

//import com.generation.beans.Modules;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mock;
//import org.mockito.runners.MockitoJUnitRunner;

//
//import com.generation.beans.Modules;
//import com.generation.beans.Users;
import com.generation.beans.Modules;
import com.generation.beans.Tokens;
import com.generation.beans.Users;
import dao.GenericDao;
import java.util.List;


/**
 *
 * @author root
 */
//@RunWith(MockitoJUnitRunner.class)
public class TestGenericDao {
    
//    @Mock
//    Modules m;
//    
//    @Test
//    public void primero () {
//        System.out.println(Integer.class);
//    }
    
    public static void main(String[] args) {
        System.out.println("Maaaa" + Modules.class);
        Prueba p = new Prueba();
        Modules m = new Modules();
        p.prueba(m);
//        
        p.consulta();
    }
    
    
    
}

class Prueba <T> {
    public void prueba (T t) {
        System.out.println("Only getClass() " + t.getClass());
        System.out.println("With simpleName()" + t.getClass().getSimpleName());
        Object obj = new Object();
        
    }
    
     public void consulta () {
        GenericDao dao = new GenericDao();
        List<Tokens> users = dao.getAll(Tokens.class.getSimpleName());
        for (Tokens usu : users) {
            System.out.println(usu.toString());
        }
        System.out.println(List.class.cast(Tokens.class.cast(users.get(0)).getStatus()).get(0).toString());
    }
}
