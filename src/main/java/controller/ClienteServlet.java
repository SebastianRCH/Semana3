package controller;

import dao.ClienteDAO;
import model.Cliente;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@WebServlet("/ClienteServlet")
public class ClienteServlet extends HttpServlet {
    
    private ClienteDAO clienteDAO;
    
    @Override
    public void init(){
        clienteDAO = new ClienteDAO();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            action = "list";
        }

        switch (action) {
            case "list":
                listClientes(request, response);
                break;
            case "add":
                showAddForm(request, response);
                break;
            case "insert":
                insertCliente(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "update":
                updateCliente(request, response);
                break;
            case "delete":
                deleteCliente(request, response);
                break;
            default:
                listClientes(request, response);
                break;
        }
    }
    
    private void listClientes(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Cliente> listaClientes = clienteDAO.getClientes();
        request.setAttribute("listaClientes", listaClientes);
        request.getRequestDispatcher("cliente-list.jsp").forward(request, response);
    }
    
    private void showAddForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("cliente-form.jsp").forward(request, response);
    }
    
    private void insertCliente(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        int identificacion = Integer.parseInt(request.getParameter("identificacion"));
        int id_Tipo_Identificacion = Integer.parseInt(request.getParameter("id_Tipo_Identificacion"));
        String nombre_1 = request.getParameter("nombre_1");
        String nombre_2 = request.getParameter("nombre_2");
        String apellido_1 = request.getParameter("apellido_1");
        String apellido_2 = request.getParameter("apellido_2");
        String domicilio = request.getParameter("domicilio");
        String telefono = request.getParameter("telefono");
        String email = request.getParameter("email");
        boolean estado = Boolean.parseBoolean(request.getParameter("estado"));
        Cliente cliente = new Cliente();
        cliente.setIdentificacion(identificacion);
        cliente.setIdTipoIdentificacion(id_Tipo_Identificacion);
        cliente.setNombre1(nombre_1);
        cliente.setNombre_2(nombre_2);
        cliente.setApellido1(apellido_1);
        cliente.setApellido2(apellido_2);
        cliente.setDomicilio(domicilio);
        cliente.setTelefono(telefono);
        cliente.setEmail(email);
        cliente.setEstado(estado);
        cliente.setFechaRegistro(new java.util.Date());

        clienteDAO.addCliente(cliente);
        response.sendRedirect("ClienteServlet?action=list");
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id_Cliente = Integer.parseInt(request.getParameter("id"));
        Cliente existingCliente = clienteDAO.getClienteById(id_Cliente);
        request.setAttribute("cliente", existingCliente);
        request.getRequestDispatcher("cliente-form.jsp").forward(request, response);
    }
    
    private void updateCliente(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        int id_Cliente = Integer.parseInt(request.getParameter("id_Cliente"));
        int identificacion = Integer.parseInt(request.getParameter("identificacion"));
        int id_Tipo_Identificacion = Integer.parseInt(request.getParameter("id_Tipo_Identificacion"));
        String nombre_1 = request.getParameter("nombre_1");
        String nombre_2 = request.getParameter("nombre_2");
        String apellido_1 = request.getParameter("apellido_1");
        String apellido_2 = request.getParameter("apellido_2");
        String domicilio = request.getParameter("domicilio");
        String telefono = request.getParameter("telefono");
        String email = request.getParameter("email");
        boolean estado = Boolean.parseBoolean(request.getParameter("estado"));
        Date fecha_Registro = java.sql.Date.valueOf(request.getParameter("fecha_Registro"));

        Cliente cliente = new Cliente();
        cliente.setid_Cliente(id_Cliente);
        cliente.setIdentificacion(identificacion);
        cliente.setIdTipoIdentificacion(id_Tipo_Identificacion);
        cliente.setNombre1(nombre_1);
        cliente.setNombre_2(nombre_2);
        cliente.setApellido1(apellido_1);
        cliente.setApellido2(apellido_2);
        cliente.setDomicilio(domicilio);
        cliente.setTelefono(telefono);
        cliente.setEmail(email);
        cliente.setEstado(estado);
        cliente.setFechaRegistro(fecha_Registro);

        clienteDAO.updateCliente(cliente);
        response.sendRedirect("ClienteServlet?action=list");
    }

    private void deleteCliente(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        int id_Cliente = Integer.parseInt(request.getParameter("id"));
        clienteDAO.deleteCliente(id_Cliente);
        response.sendRedirect("ClienteServlet?action=list");
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
