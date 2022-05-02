package com.emergentes.controlador;

import com.emergentes.dao.UserDAOimplents;
import com.emergentes.dao.UsuarioDAO;
import com.emergentes.modelo.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

@WebServlet(name = "UserController", urlPatterns = {"/UserController"})
public class UserController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UsuarioDAO dao = new UserDAOimplents();
        User u = new User();
        String opcion = (request.getParameter("op") != null) ? request.getParameter("op") : "view";

        if (opcion.equals("nuevo")) {
            request.setAttribute("op", "add");
            request.setAttribute("users", u);
            request.getRequestDispatcher("edit-Usuarios.jsp").forward(request, response);

        }
        if (opcion.equals("modificar")) {
            int id = Integer.parseInt(request.getParameter("id"));
            try {
                u = dao.getById(id);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error al buscar el registro " + ex.getMessage());
            }
            request.setAttribute("op", "editar");
            request.setAttribute("users", u);
            request.getRequestDispatcher("edit-Usuarios.jsp").forward(request, response);
        }
        if (opcion.equals("eliminar")) {
            int id = Integer.parseInt(request.getParameter("id"));
            try {
                dao.eliminar(id);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error al eliminar:" + ex.getMessage());
            }
            response.sendRedirect("UserController");
        }

        if (opcion.equals("view")) {
            List<User> list = new ArrayList<User>();
            try {
                list = dao.getAll();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error al listar " + ex.getMessage());
            }
          
            request.setAttribute("lis", list);
            request.getRequestDispatcher("Usuario.jsp").forward(request, response);
          
          
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id;
         User u = new User();
      
         id = Integer.parseInt(request.getParameter("id"));
        String nombre = request.getParameter("nombre");
        String correo = request.getParameter("correo");
        String clave = request.getParameter("clave");
       
        u.setId(id);
        u.setNombre(nombre);
        u.setCorreo(correo);
        u.setClave(clave);
        
        UsuarioDAO dao = new UserDAOimplents();

        if (id == 0) {
          try{
           //nuevo
           dao.insertar(u);
          }  catch(Exception ex){                    
              JOptionPane.showMessageDialog(null,"Error al insertar regisltro "+ex.getMessage());
          }
        }
        else {
            //edicion
            try{
                dao.modificar(u);
            }catch (Exception ex){
                JOptionPane.showMessageDialog(null,"Error al modificar registro "+ex.getMessage());
            }
        }
        response.sendRedirect("UserController");
    }
}
