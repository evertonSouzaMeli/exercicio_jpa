package br.com.fiap.model

import javax.persistence.*

@Entity
@Table(name = "TAB_CASO_TESTE")
@SequenceGenerator(name="caso", sequenceName = "SQ_TB_CASO", allocationSize = 1)
class Caso(nome: String, descricao: String){
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "caso")
    @Column(name = "COD_CASO_TESTE")
    var codigo : Int? = null

    @Column(name = "NOM_CASO_TESTE", nullable = false)
    lateinit var nome : String

    @Column(name = "DES_CASO_TESTE", nullable = false)
    lateinit var descricao: String

    @ManyToOne
    lateinit var sistema: Sistema

    constructor(nome: String, descricao: String, sistema: Sistema): this(nome, descricao){
        this.nome = nome
        this.descricao = descricao
        this.sistema = sistema
    }
}