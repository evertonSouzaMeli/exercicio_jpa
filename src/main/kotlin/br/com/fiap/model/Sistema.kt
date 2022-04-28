package br.com.fiap.model

import javax.persistence.*

@Entity
@Table(name = "TAB_SISTEMA")
@SequenceGenerator(name="sistema", sequenceName = "SQ_TB_SISTEMA", allocationSize = 1)
class Sistema( nome: String) {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sistema")
    var codigo : Int? = null

    @Column(name = "NOM_SISTEMA", nullable = false)
    var nome : String? = null

    @OneToMany(mappedBy = "sistema", cascade = [CascadeType.PERSIST, CascadeType.MERGE])
    var casoList: List<Caso> = ArrayList()

    constructor(nome: String, casoList: List<Caso>) : this(nome){
        this.nome = nome
        this.casoList = casoList
    }

    override fun toString(): String {
        return "Sistema(codigo=$codigo, nome='$nome')"
    }


}