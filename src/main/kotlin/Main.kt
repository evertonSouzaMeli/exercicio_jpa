import br.com.fiap.dao.impl.CasoDAOImpl
import br.com.fiap.dao.impl.ItemDAOImpl
import br.com.fiap.dao.impl.SistemaDAOImpl
import br.com.fiap.dao.impl.UsuarioDAOImpl
import br.com.fiap.model.Caso
import br.com.fiap.model.Item
import br.com.fiap.model.Sistema
import javax.persistence.EntityManager
import javax.persistence.EntityManagerFactory
import javax.persistence.Persistence

fun main() {
    val factory : EntityManagerFactory = Persistence.createEntityManagerFactory("ORCL")
    val entityManager : EntityManager = factory.createEntityManager()

    val sistemaDAOImpl = SistemaDAOImpl(entityManager)
    val itemDAOImpl = ItemDAOImpl(entityManager)
    val usuarioDAOImpl = UsuarioDAOImpl(entityManager)
    val casoDAOImpl = CasoDAOImpl(entityManager)


    var caso: Caso = Caso("Cadastro usuario", "Cadastrar usuario com sucesso", Sistema("Minduim", null))
    casoDAOImpl.cadastrar(caso)
}