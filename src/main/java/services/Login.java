/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import com.generation.beans.Tokens;
import com.generation.beans.Users;
import dao.GenericDao;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONException;
import org.json.JSONObject;
import util.Hash;
import util.RegexU;
import util.SearchToken;


/*
Consultar contrseña o user
 */
/**
 *
 * @author root
 */
@WebServlet(name = "Login", urlPatterns = {"/api/Login"})
public class Login extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param req servlet request
     * @param resp servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param req servlet request
     * @param resp servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setHeader("Access-Control-Allow-Methods", "POST");
        req.setCharacterEncoding("utf-8");
        resp.setContentType("application/json");
        BufferedReader br = req.getReader();
        StringBuilder sb = new StringBuilder("");
        JSONObject jsono, result;

        String str;
        while ((str = br.readLine()) != null) {
            sb.append(str);
        }
        System.out.println(sb.toString());
        if (!sb.toString().equals("")) {
            try {
                jsono = new JSONObject(sb.toString());
                String tkn = jsono.optString("tkn", "null");
                String auth = (String) jsono.opt("auth");
                GenericDao dao = new GenericDao();
                List<Tokens> tokense;
                if (RegexU.isValidMail(auth) || RegexU.isValidNick(auth)) {
                    if (tkn.equals("null")) {
                        String pass = (String) jsono.opt("pass");
                        List<Users> list = dao.getAll(Users.class.getSimpleName());
                        Users us = null;
                        for (Users users : list) {
                            if (users.getMail().equalsIgnoreCase(auth) || users.getNick().equalsIgnoreCase(auth)) {
                                us = users;
                            }
                        }
                        if (us != null) {
                            if (pass.equals(us.getPass())) {
                                long da = System.currentTimeMillis();
                                boolean ban;
                                do {
                                    ban = false;
                                    if (SearchToken.search(Hash.convertirSHA_1(Long.toString(da)))) {
                                        da--;
                                        ban = true;
                                    }
                                } while (ban);
                                String tok = Hash.convertirSHA_1(Long.toString(da));
                                tokense = dao.getByParameter(Tokens.class.getSimpleName(), "users_id_user", us.getIdUser().toString());
                                if (!tokense.isEmpty()) {
                                    //Tokens aux;
                                    for (Tokens aux : tokense) {
                                        aux.setStatus(0);
                                        dao.update(aux);
                                    }
                                }
                                Tokens token = new Tokens();
                                token.setDate(new Date());
                                token.setKey("0");
                                token.setStatus(1);
                                token.setTurn(tok.substring(0, 0));
                                token.setToken(tok);
                                token.setUsers(us);
                                dao.save(token);
                                result = new JSONObject();
                                result.put("result", "success");
                                result.put("message", "login created");
                                jsono = new JSONObject();
                                jsono.put("tkn", tok + ":" + us.getIdUser().toString());
                                result.put("data", jsono);
                                System.out.println("Success");
                            } else {
                                System.out.println("Pass wrong");
                                result = new JSONObject();
                                result.put("result", "error");
                                result.put("message", "password or email incorrect");
                            }
                        } else {
                            System.out.println("auth incorrect");
                            result = new JSONObject();
                            result.put("result", "error");
                            result.put("message", "password or email incorrect");
                        }
                    } else {
                        if (RegexU.isValidToken(tkn)) {
                            System.out.println("tkn unecesary");
                            result = new JSONObject ();
                            result.put("result", "error");
                            result.put("message", "thank you but not thank you");
                        } else {
                            System.out.println("tkn malformed");
                            result = new JSONObject();
                            result.put("result", "error");
                            result.put("message", "nick, email or tkn malformed");
                        }
                    }
                } else {
                    System.out.println("auth malformed");
                    result = new JSONObject();
                    result.put("result", "error");
                    result.put("message", "nick, email or tkn malformed");
                }

            } catch (JSONException | NullPointerException je) {
                System.err.println(je.toString());
                System.err.println("Json malformed");
                result = new JSONObject();
                jsono = new JSONObject();
                result.put("result", "error");
                result.put("message", "JSON malformed");
                jsono.put("received", sb);
                result.put("data", jsono);
            }
        } else {
            System.out.println("json hasn't received");
            result = new JSONObject();
            result.put("result", "error");
            result.put("message", "json hasn't received");
        }
        System.out.println("Success: " + result.toString()) ;
        result.put("status", "200");
        PrintWriter pw = resp.getWriter();
        pw.print(result);
        pw.flush();
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
