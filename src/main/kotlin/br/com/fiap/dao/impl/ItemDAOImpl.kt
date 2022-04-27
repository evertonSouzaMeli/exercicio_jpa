package br.com.fiap.dao.impl

import br.com.fiap.model.Item
import javax.persistence.EntityManager

class ItemDAOImpl(em: EntityManager) : GenericDAOImpl<Item, Int>(em) {
}