/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import antlr.Token;
import dao.GenericDao;
import java.util.List;

/**
 *
 * @author Ismael
 */
public class SearchToken {
    
    public SearchToken() {}

    public static boolean search(String token) {
        GenericDao dao = new GenericDao();
        List<Token> list = dao.getByParameter(Token.class.getSimpleName(), "token", token);
        return !(list.isEmpty());
    }
    
  
    
}
