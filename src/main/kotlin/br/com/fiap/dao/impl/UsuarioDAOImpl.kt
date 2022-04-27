package br.com.fiap.dao.impl

import br.com.fiap.model.Usuario
import javax.persistence.EntityManager

class UsuarioDAOImpl(em: EntityManager) : GenericDAOImpl<Usuario, Int>(em) {
}