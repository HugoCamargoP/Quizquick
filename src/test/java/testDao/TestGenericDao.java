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


import com.generation.beans.Modules;
import java.lang.Integer;


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
    }
    
    
    
}

class Prueba <T> {
    public void prueba (T t) {
        System.out.println(t.getClass());
    }
}
