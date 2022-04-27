import br.com.fiap.dao.impl.ItemDAOImpl
import br.com.fiap.model.Caso
import br.com.fiap.model.Item
import br.com.fiap.model.Usuario
import javax.persistence.EntityManager
import javax.persistence.EntityManagerFactory
import javax.persistence.Persistence

fun main() {
    val factory : EntityManagerFactory = Persistence.createEntityManagerFactory("ORCL")
    val entityManager : EntityManager = factory.createEntityManager()
    val itemDAO: ItemDAOImpl = ItemDAOImpl(entityManager)

    val usuario: Usuario = Usuario("Usuario")
    val item: Item = Item("primeiro item", Caso("Caso 1", "Primero caso"), arrayListOf(usuario));
    itemDAO.cadastrar(item)
}