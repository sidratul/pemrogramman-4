package belajar.web;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WebServlet extends HttpServlet{
    public void doPost(HttpServletRequest req,HttpServletResponse res){
        try{
            String nama=req.getParameter("nama");
            nama = nama.toUpperCase();
            
            String output ="<html>";
            output += "<body>";
            output += "<h1>Halo "+nama+"</h1>";
            output += "</body>";
            output += "</html>";
            
            res.setContentType("text/html");
            res.getWriter().print(output);
        }catch(IOException ie){
            Logger.getLogger(WebServlet.class.getName()).log(Level.SEVERE,null,ie);
        }
    }
}
