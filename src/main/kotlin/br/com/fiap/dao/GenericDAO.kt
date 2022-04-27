package br.com.fiap.dao


interface GenericDAO<T,K> {

    fun cadastrar(entity: T)

    fun procurar(id: K): T

    fun atualizar(entity: T)

    fun apagar(id: K)

    fun commit()
}