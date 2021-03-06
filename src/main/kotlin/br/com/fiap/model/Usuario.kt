package br.com.fiap.model

import javax.persistence.*

@Entity
@Table(name = "TAB_USUARIO")
@SequenceGenerator(name="usuario", sequenceName = "SQ_TB_USUARIO", allocationSize = 1)
class Usuario() {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario")
    @Column(name = "COD_USUARIO")
    lateinit var codigo : Integer

    @Column(name = "NOM_USUARIO", nullable = false)
    lateinit var nome: String

    @ManyToMany(mappedBy = "usuarioList", cascade = [CascadeType.ALL])
    lateinit var itemList: List<Item>

    constructor(nome: String, itemList: List<Item>?): this(){
        this.nome = nome
        this.itemList = itemList ?: ArrayList()
    }

    override fun toString(): String {
        return "Usuario(codigo=$codigo, nome='$nome')"
    }


}
