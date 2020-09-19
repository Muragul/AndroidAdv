package com.example.mvpcalc.contract

interface ContractInterface {
    interface Model{
        fun getResult(): Double
    }
    interface View{
        fun initView()
        fun updateView()
    }
    interface Presenter{
    }
}