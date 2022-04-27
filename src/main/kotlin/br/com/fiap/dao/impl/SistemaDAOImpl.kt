package br.com.fiap.dao.impl

import br.com.fiap.model.Sistema
import javax.persistence.EntityManager

class SistemaDAOImpl(em: EntityManager) : GenericDAOImpl<Sistema, Int>(em) {
}