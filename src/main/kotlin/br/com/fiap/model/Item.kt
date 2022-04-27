package br.com.fiap.model

import javax.persistence.*

@Entity
@Table(name = "TAB_ITEM_TESTE")
@SequenceGenerator(name="item", sequenceName = "SQ_TB_ITEM", allocationSize = 1)
class Item( descricao: String ) {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "item")
    @Column(name = "COD_ITEM_TESTE")
    var codigo : Int? = null

    @Column(name = "DES_ITEM_TESTE", nullable = false)
    lateinit var descricao: String

    @ManyToOne
    lateinit var caso : Caso

    @ManyToMany(cascade = [CascadeType.MERGE])
    @JoinTable(name = "TAB_ITEM_TESTE_USUARIO")
    var usuarioList: List<Usuario> = ArrayList()

    constructor(descricao: String, caso: Caso, usuarioList: List<Usuario>) : this(descricao){
        this.descricao = descricao
        this.caso = caso
        this.usuarioList = usuarioList
    }
}