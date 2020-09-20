package com.example.mvpcalc.presenter

import com.example.mvpcalc.contract.ContractInterface
import com.example.mvpcalc.model.Model

class Presenter(_view: ContractInterface.View) : ContractInterface.Presenter {

    private var view: ContractInterface.View = _view
    private var model: ContractInterface.Model = Model()

    init {
        view.initView()
    }

    override fun delete() {
        model.delete()
        view.updateView()
    }

    override fun clear() {
        model.clear()
        view.updateView()
    }

    override fun dot() {
        model.dot()
        view.updateView()
    }

    override fun buttonClicked(n: Int) {
        model.buttonClicked(n)
        view.updateView()
    }

    override fun getInput(): String = model.getInput()

    override fun monoFunctionClicked(s: String) {
        model.monoFunctionClicked(s)
        view.updateView()
    }

    override fun biFunctionClicked(s: String) {
        model.biFunctionClicked(s)
        view.updateView()
    }

    override fun getOperation(): String = model.getOperation()

}