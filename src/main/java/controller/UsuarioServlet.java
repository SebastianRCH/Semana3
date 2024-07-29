package controller;

import dao.UsuarioDAO;
import model.Usuario;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@WebServlet("/UsuarioServlet")
public class UsuarioServlet extends HttpServlet {
    
    private UsuarioDAO usuarioDAO;
    
    @Override
    public void init(){
        usuarioDAO = new UsuarioDAO();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            action = "login";
        }

        switch (action) {
            case "login":
                login(request, response);
                break;
            default:
                response.sendRedirect("login.jsp");
                break;
        }
    }
    
     private void login(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String identificacion = request.getParameter("identificacion");
        String password = request.getParameter("password");

        Usuario usuario = usuarioDAO.getUsuarioByEmailAndPassword(identificacion, password);

        if (usuario != null) {
            HttpSession session = request.getSession();
            session.setAttribute("usuario", usuario);
            request.getSession().setAttribute("usuarioLogueado", usuario);
            response.sendRedirect("HomeServlet");
        } else {
            response.sendRedirect("login.jsp?error=true"); // Redirigir de nuevo al login con un mensaje de error
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
    
}
