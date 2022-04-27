package br.com.fiap.model

import javax.persistence.*

@Entity
@Table(name = "TAB_USUARIO")
@SequenceGenerator(name="usuario", sequenceName = "SQ_TB_USUARIO", allocationSize = 1)
class Usuario( nome: String ) {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario")
    @Column(name = "COD_USUARIO")
    var codigo : Int? = null

    @Column(name = "NOM_USUARIO", nullable = false)
    lateinit var nome: String

    @ManyToMany(mappedBy = "usuarioList", cascade = [CascadeType.MERGE])
    var itemList : List<Item> = ArrayList()

    constructor(nome: String, itemList: List<Item>): this(nome){
        this.nome = nome
        this.itemList = itemList
    }
}
