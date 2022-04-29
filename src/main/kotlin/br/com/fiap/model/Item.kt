package br.com.fiap.model

import javax.persistence.*

@Entity
@Table(name = "TAB_ITEM_TESTE")
@SequenceGenerator(name = "item", sequenceName = "SQ_TB_ITEM", allocationSize = 1)
class Item() {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "item")
    @Column(name = "COD_ITEM_TESTE")
    var codigo: Int = 0

    @Column(name = "DES_ITEM_TESTE")
    lateinit var descricao: String

    @ManyToOne
    lateinit var caso: Caso

    @ManyToMany(cascade = [CascadeType.ALL])
    @JoinTable(name = "TAB_ITEM_TESTE_USUARIO")
    lateinit var usuarioList: List<Usuario>

    constructor(descricao: String, caso: Caso, usuarioList: List<Usuario>?) : this() {
        this.descricao = descricao
        this.caso = caso
        this.usuarioList = usuarioList ?: ArrayList()
    }

    override fun toString(): String {
        return "Item(codigo=$codigo, descricao='$descricao', caso=$caso, usuarioList=$usuarioList)"
    }
}