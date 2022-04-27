package br.com.fiap.dao.impl

import br.com.fiap.model.Caso
import javax.persistence.EntityManager

class CasoDAOImpl(em: EntityManager) : GenericDAOImpl<Caso, Int>(em)