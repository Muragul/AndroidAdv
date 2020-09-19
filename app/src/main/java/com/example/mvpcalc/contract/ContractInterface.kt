package com.example.mvpcalc.contract

interface ContractInterface {
    interface Model{
        fun delete()
        fun clear()
        fun dot()
        fun buttonClicked(n: Int)
        fun getResult(): Double
        fun monoFunction(s: String)
        fun biFunction(s: String)
        fun monoFunctionClicked(s: String)
        fun biFunctionClicked(s: String)
        fun getOperation(): String
    }
    interface View{
        fun initView()
        fun updateView()
    }
    interface Presenter{
        fun delete()
        fun clear()
        fun dot()
        fun buttonClicked(n: Int)
        fun getResult(): String
        fun monoFunctionClicked(s: String)
        fun biFunctionClicked(s: String)
        fun getOperation(): String
    }
}