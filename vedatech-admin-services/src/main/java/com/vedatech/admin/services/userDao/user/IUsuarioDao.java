package com.vedatech.admin.services.userDao.user;

import com.vedatech.admin.data.user.Usuario;
import org.springframework.data.repository.CrudRepository;


public interface IUsuarioDao extends CrudRepository<Usuario, Long> {

	public Usuario findByUsername(String username);
}
