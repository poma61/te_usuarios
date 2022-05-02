
package com.emergentes.dao;

import com.emergentes.modelo.User;
import java.util.List;

public interface UsuarioDAO {
   
  public void insertar (User user) throws Exception;
  public void modificar (User user) throws Exception;
  public void eliminar (int id) throws Exception;
  public List<User> getAll() throws Exception;
  public User getById (int id) throws Exception;
    
}
