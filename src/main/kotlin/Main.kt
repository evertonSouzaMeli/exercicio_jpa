import br.com.fiap.dao.impl.ItemDAOImpl
import br.com.fiap.model.Item
import javax.persistence.EntityManager
import javax.persistence.EntityManagerFactory
import javax.persistence.Persistence

fun main() {
    val factory : EntityManagerFactory = Persistence.createEntityManagerFactory("ORCL")
    val entityManager : EntityManager = factory.createEntityManager()

    val itemDAOImpl: ItemDAOImpl = ItemDAOImpl(entityManager)
    val item = Item()

    item.descricao = "Item 1"
    itemDAOImpl.cadastrar(item)
}