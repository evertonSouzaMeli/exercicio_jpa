package br.com.fiap.model

import javax.persistence.*

@Entity
@Table(name = "TAB_SISTEMA")
@SequenceGenerator(name="sistema", sequenceName = "SQ_TB_SISTEMA", allocationSize = 1)
class Sistema() {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sistema")
    lateinit var codigo : Integer

    @Column(name = "NOM_SISTEMA", nullable = false)
    lateinit var nome : String

    @OneToMany(mappedBy = "sistema", cascade = [CascadeType.PERSIST, CascadeType.MERGE])
    lateinit var casoList: List<Caso>

    constructor(nome: String, casoList: List<Caso>?) : this(){
        this.nome = nome
        this.casoList = casoList ?: ArrayList()
    }

    override fun toString(): String {
        return "Sistema(codigo=$codigo, nome='$nome')"
    }


}