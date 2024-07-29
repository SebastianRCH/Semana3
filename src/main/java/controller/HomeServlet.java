package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import model.Usuario;
import model.Cargo;
import dao.CargoDAO;

@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {
    
    private CargoDAO cargoDAO;

    @Override
    public void init() {
        cargoDAO = new CargoDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Usuario usuario = (Usuario) request.getSession().getAttribute("usuarioLogueado");
        if (usuario != null) {
            Cargo cargo = cargoDAO.getCargoById(usuario.getIdCargo());
            request.setAttribute("usuario", usuario);
            request.setAttribute("cargo", cargo);
            request.getRequestDispatcher("home.jsp").forward(request, response);
        } else {
            response.sendRedirect("login.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
