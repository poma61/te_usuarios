package com.emergentes.dao;

import com.emergentes.modelo.User;
import com.emergentes.utiles.ConexionB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDAOimplents extends ConexionB implements UsuarioDAO {

    @Override
    public void insertar(User user) throws Exception {
        String consulta = "INSERT INTO usuarios(nombre,correo,clave) VALUES(?,?,?)";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(consulta);
        ps.setString(1, user.getNombre());
        ps.setString(2, user.getCorreo());
        ps.setString(3, user.getClave());
        ps.executeUpdate();
        this.desconn();
    }

    @Override
    public void modificar(User user) throws Exception {
        this.conectar();
        String consulta = "UPDATE usuarios set nombre='" + user.getNombre() + "',"
                + "correo='" + user.getCorreo() + "',clave='" + user.getClave() + "'"
                + "where id=" + user.getId();
        PreparedStatement ps = this.conn.prepareStatement(consulta);
        ps.executeUpdate();
        this.desconn();

    }

    @Override
    public void eliminar(int id) throws Exception {
        this.conectar();
        String consulta = "DELETE FROM usuarios WHERE id=?";
        PreparedStatement ps = this.conn.prepareStatement(consulta);
        ps.setInt(1, id);
        ps.executeUpdate();
        this.desconn();

    }

    @Override
    public List<User> getAll() throws Exception {
        List<User> list = null;
        String consulta = "SELECT * FROM usuarios";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(consulta);
        ResultSet rs = ps.executeQuery();
        list = new ArrayList<User>();
        while (rs.next()) {
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setNombre(rs.getString("nombre"));
            user.setCorreo(rs.getString("correo"));
            user.setClave(rs.getString("clave"));
            list.add(user);
        }
        this.desconn();
        return list;
    }

    @Override
    public User getById(int id) throws Exception {
        User user = new User();
        String consulta = "SELECT * FROM usuarios WHERE id=" + id;
        PreparedStatement ps = this.conn.prepareStatement(consulta);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            user.setId(rs.getInt("id"));
            user.setNombre(rs.getString("nombre"));
            user.setCorreo(rs.getString("correo"));
            user.setClave(rs.getString("clave"));
        }
return user;
    }

}//class  DAO
