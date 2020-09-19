package com.example.mvpcalc.model

import com.example.mvpcalc.contract.ContractInterface

public class Model : ContractInterface.Model {
    var a: Double = 0.0
    var b: Double = 0.0
    var res: Double = 0.0
    var error: String = ""
    var mono: String = ""
    var bi: String = ""
    var sec: Boolean = false
    var complete: Boolean = false
    var entermode: Int = 1
    var f: Int = 0
    var input: Double = 0.0
    var oper: String = ""

    override fun getResult(): Double {
        return res
    }
}