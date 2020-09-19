package com.example.mvpcalc.contract

interface ContractInterface {
    interface Model{
        fun delete()
        fun clear()
        fun dot()
        fun buttonClicked(n: Int)
        fun getResult()
        fun monoFunction(s: String)
        fun biFunction(s: String)
        fun monoFunctionClicked(s: String)
        fun biFunctionClicked(s: String)
        fun getOperation(): String
        fun getInput(): String
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
        fun monoFunctionClicked(s: String)
        fun biFunctionClicked(s: String)
        fun getOperation(): String
        fun getInput(): String
    }
}