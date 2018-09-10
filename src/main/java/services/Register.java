/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import com.generation.beans.Users;
import dao.GenericDao;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONException;
import org.json.JSONObject;
import util.Hash256;

/**
 *
 * @author Ismael
 */
@WebServlet(name = "Register", urlPatterns = {"/api/Register"})
public class Register extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
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
        JSONObject jsono = null, result = null;
        Hash256 hash256 = new Hash256();

        String str;
        while ((str = br.readLine()) != null) {
            sb.append(str);
        }
        if (!sb.toString().equals("")) {
            try {
                jsono = new JSONObject(sb.toString());
                Users user = new Users();
                user.setNick((String) jsono.opt("nick"));
                user.setMail((String) jsono.opt("email"));
                String pass = (String) jsono.opt("password");
                String hash = hash256.convertirSHA256(pass);
                user.setPass(hash);
                GenericDao dao = new GenericDao();
                dao.save(user);
                result = new JSONObject();
                jsono = new JSONObject();
                jsono.put("result", "sucsses");
            } catch (NullPointerException | JSONException e) {
                result = new JSONObject();
                jsono = new JSONObject();
                jsono.put("result", "error");
                jsono.put("value", "json hasn't received");
            }

        } else {
            result = new JSONObject();
            jsono = new JSONObject();
            jsono.put("result", "error");
            jsono.put("value", "json hasn't received");
        }
        result.put("status", "200");
        PrintWriter pw = resp.getWriter();
        pw.print(jsono);
        pw.flush();
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
