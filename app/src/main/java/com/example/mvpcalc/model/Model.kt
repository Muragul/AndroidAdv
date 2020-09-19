package com.example.mvpcalc.model

import com.example.mvpcalc.contract.ContractInterface
import kotlin.math.*

class Model : ContractInterface.Model {
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
    var input: String = "0"
    var oper: String = ""

    override fun delete() {
        if (isWord()) {
            input = "0"
        } else {
            if (input.contains("-") && input.length == 2) {
                input = "0"
            } else if (input.length != 1) {
                val s = input.toString()
                val s1 = s.substring(0, s.length - 1)
                input = s1
            } else {
                input = "0"
                oper = ""
            }
        }
        if (entermode == 1)
            a = input.toDouble()
        else
            b = input.toDouble()
    }

    override fun clear() {
        input = "0"
        a = 0.0
        b = 0.0
        res = 0.0
        error = ""
        sec = false
        complete = false
        mono = ""
        bi = ""
        oper = ""
        entermode = 1
    }

    override fun dot() {
        if (input == "")
            input = "0."
        else {
            if (!input.contains(".") && !isWord()) {
                val s = "$input."
                input = s
            }
        }
    }

    override fun buttonClicked(n: Int) {
        val s: String = n.toString()
        if (n == 0 && input == "0") {
        } else {
            if (input == "0" || isWord() || complete) {
                input = s
                complete = false
            } else {
                val k: String = input
                input = k + s
            }
            if (bi != "") {
                sec = true
            }
            if (entermode == 1) {
                a = input.toDouble()
            } else {
                b = input.toDouble()
            }
        }
    }

    override fun getResult(): Double {
        if (entermode == 1 && input.contains(".")) {
            if (input == "0.0")
                input = "0"
            else
                while (input[input.length - 1] == '0') {
                    val s: String = input.toString()
                    var s1: String = s.substring(0, s.length - 1)
                    if (s1[s1.length - 1] == '.')
                        s1 = s1.substring(0, s1.length - 1)
                    input = s1
                }
        }
        if (bi != "") {
            biFunction(bi)
            if (error != "") {
                input = error
                error = ""
            } else {
                input = if (isPossibleToConvert(res)) {
                    val s = res.toString().substring(0, res.toString().length - 2)
                    s
                } else
                    res.toString()
            }
            a = res
            entermode = 1
            complete = true
            sec = false
        }
        return res
    }

    override fun monoFunction(operation: String) {
        val k: Double = if (entermode == 1) {
            a
        } else {
            b
        }
        when (operation) {
            "sqr" -> res = k * k
            "sqrt" -> if (k > 0) {
                res = sqrt(k)
            } else {
                error = "impossible"
                oper = ""
            }
            "per" -> res = k / 100
            "!" -> if (k < 0) {
                error = "impossible"
            } else {
                try {
                    if (isPossibleToConvert(k)) {
                        f = k.toInt()
                        res = findFact(f).toString().toDouble()
                    }
                } finally {
                }
            }
            "ln" -> if (k > 0) {
                res = ln(k)
            } else {
                error = "impossible"
            }
            "sin" -> res = sin(k)
            "cos" -> res = cos(k)
            "tan" -> res = tan(k)
        }
        if (entermode == 1) {
            a = res
        } else {
            b = res
        }
    }

    override fun biFunction(operation: String) {
        when (operation) {
            "sum" -> res = a + b
            "dif" -> res = a - b
            "mult" -> res = a * b
            "div" -> if (b != 0.0) {
                res = a / b
            } else {
                error = "impossible"
                oper = ""
            }
            "a^n" -> res = a.pow(b)
            "log" -> res = log10(b) / log10(a)
            "sqrtn" -> if (a % 2 == 0.0 && b < 0) {
                error = "impossible"
            } else {
                res = a.pow((1 / b))
            }
        }
    }

    override fun getOperation(): String = oper

    private fun findFact(x: Int): Int {
        return if (x != 0) {
            x * findFact(x - 1)
        } else {
            1
        }
    }

    private fun isPossibleToConvert(res: Double): Boolean {
        if (res % 1 == 0.0) return true
        return false
    }

    private fun isWord(): Boolean {
        when (input) {
            "" -> return true
            "impossible" -> return true
            "NaN" -> return true
            "Infinity" -> return true
        }
        if (input.contains('E'))
            return true
        return false
    }

    override fun monoFunctionClicked(operation: String) {
        if (isWord()) {
            input = "0"
        }
        monoFunction(operation)
        if (error != "") {
            input = error
            error = ""
        } else {
            if (isPossibleToConvert(res)) {
                var s: String = res.toString().substring(0, res.toString().length - 2)
                input = s
            } else
                input = res.toString()
        }
        complete = true
    }

    override fun biFunctionClicked(operation: String) {
        if (isWord()) {
            input = "0"
        }
        if (entermode == 1 && input.contains(".")) {
            if (input == "0.0") {
                input = "0"
            } else
                while (input[input.length - 1] == '0') {
                    val s = input
                    val s1 = s.substring(0, s.length - 1)
                    input = s1
                }
        }
        entermode = 2
        b = input.toDouble()
        if (bi != "" && sec) {
            biFunction(bi)
            if (error != "") {
                input = error
                error = ""
            } else {
                if (isPossibleToConvert(res)) {
                    var s: String = res.toString().substring(0, res.toString().length - 2)
                    input = s
                } else {
                    input = res.toString()
                }
            }
            a = res
            b = res
        }
        bi = operation
        complete = true
        sec = false
    }
}