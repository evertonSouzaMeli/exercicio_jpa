package br.com.fiap.model

import javax.persistence.*

@Entity
@Table(name = "TAB_CASO_TESTE")
@SequenceGenerator(name="caso", sequenceName = "SQ_TB_CASO", allocationSize = 1)
class Caso(){
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "caso")
    @Column(name = "COD_CASO_TESTE")
    var codigo : Int? = null

    @Column(name = "NOM_CASO_TESTE", nullable = false)
    var nome : String? = null

    @Column(name = "DES_CASO_TESTE", nullable = false)
    var descricao: String? = null

    @ManyToOne
    @JoinColumn(name = "", referencedColumnName = "codigo")
    var sistema: Sistema? = null

    constructor(nome: String, descricao: String, sistema: Sistema): this(){
        this.nome = nome
        this.descricao = descricao
        this.sistema = sistema
    }

    override fun toString(): String {
        return "Caso(codigo=$codigo, nome='$nome', descricao='$descricao', sistema=$sistema)"
    }


}