package com.example.mvpcalc.contract

interface ContractInterface {
    interface Model{
        fun getInfo()
    }
    interface View{
        fun initView()
        fun updateViewData()
    }
    interface Presenter{
        fun showInfo()
    }
}