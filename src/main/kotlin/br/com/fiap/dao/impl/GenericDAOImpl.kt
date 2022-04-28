package br.com.fiap.dao.impl

import br.com.fiap.dao.GenericDAO
import java.lang.RuntimeException
import java.lang.reflect.ParameterizedType
import javax.persistence.EntityManager

open class GenericDAOImpl<T, K>(private val em: EntityManager?) : GenericDAO<T, K> {
    private val clazz : Class<T> = (javaClass.genericSuperclass as ParameterizedType)
        .actualTypeArguments[0] as Class<T>

    override fun cadastrar(entity: T) {
        em?.persist(entity)
    }

    override fun procurar(id: K): T {
        return em?.find(clazz, id) ?: throw RuntimeException()
    }

    override fun atualizar(entity: T) {
        em?.merge(entity)
    }

    override fun apagar(id: K) {
        em?.remove(procurar(id))
    }

    override fun procurarTodos(): MutableList<Any?>? {
        return em?.createQuery("Select t from " + clazz.simpleName + " t")?.resultList;
    }

    override fun commit() {
        try {
            em?.transaction?.begin()
            em?.transaction?.commit()
        } catch (e: Exception) {
            em?.transaction?.rollback()
            throw RuntimeException()
        }
    }
}