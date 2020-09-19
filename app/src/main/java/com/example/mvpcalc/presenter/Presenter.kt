package com.example.mvpcalc.presenter

import com.example.mvpcalc.contract.ContractInterface
import com.example.mvpcalc.model.Model

public class Presenter(_view: ContractInterface.View) : ContractInterface.Presenter {

    private var view: ContractInterface.View = _view
    private var model: ContractInterface.Model = Model()

    init {
        view.initView()
    }
}