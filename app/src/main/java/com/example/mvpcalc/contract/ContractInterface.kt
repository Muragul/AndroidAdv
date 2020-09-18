package com.example.mvpcalc.contract

interface ContractInterface {
    interface Model{
    }
    interface View{
        fun initView()
        fun updateViewData()
    }
    interface Presenter{
    }
}