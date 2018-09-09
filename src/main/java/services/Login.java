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
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONException;
import org.json.JSONObject;


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
        JSONObject jsono;
        String str;
        while ((str = br.readLine()) != null) {
            sb.append(str);
        }
        System.out.println(sb.toString());
        if (!sb.toString().equals("")) {
            try {
                jsono = new JSONObject(sb.toString());
                String name = (String) jsono.opt("user");
                String pass = (String) jsono.opt("pass");
                GenericDao dao = new GenericDao();
                List<Users> list = dao.getAll(Users.class.getSimpleName());
                jsono = new JSONObject();
                jsono.put("result", "unsuccess");
                jsono.put("value", "wrong user or pass");
                for (Users user : list) {
                    if (name.equals(user.getNick()) && pass.equals(user.getPass())) {

                        jsono = new JSONObject();
                        jsono.put("result", "success");
                        jsono.put("tk", "FFFF");
                        break;
                    }
                }
            } catch (JSONException | NullPointerException je) {
                System.err.println(je.toString());
                jsono = new JSONObject();
                jsono.put("result", "unsuccess");
                jsono.put("value", "JSON malformed");
                jsono.put("received", sb);
            }
        } else {
            jsono = new JSONObject();
            jsono.put("result", "unsuccess");
            jsono.put("value", "json hasn't received");
        }
        PrintWriter pw = resp.getWriter();
        pw.print(jsono);
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
