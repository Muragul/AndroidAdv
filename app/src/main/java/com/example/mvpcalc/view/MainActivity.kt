package com.example.mvpcalc.view

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.mvpcalc.R
import com.example.mvpcalc.contract.ContractInterface
import com.example.mvpcalc.presenter.Presenter


class MainActivity : AppCompatActivity(), ContractInterface.View {
    private lateinit var presenter: Presenter
    private lateinit var input: TextView
    private lateinit var oper: TextView
    private lateinit var b0: Button
    private lateinit var b1: Button
    private lateinit var b2: Button
    private lateinit var b3: Button
    private lateinit var b4: Button
    private lateinit var b5: Button
    private lateinit var b6: Button
    private lateinit var b7: Button
    private lateinit var b8: Button
    private lateinit var b9: Button
    private lateinit var bsqrt: Button
    private lateinit var bsqr: Button
    private lateinit var bper: Button
    private lateinit var bclear: Button
    private lateinit var bsum: Button
    private lateinit var bdif: Button
    private lateinit var bmult: Button
    private lateinit var bdiv: Button
    private lateinit var bdel: Button
    private lateinit var bdot: Button
    private lateinit var bres: Button
    private lateinit var bsqrn: Button
    private lateinit var bsqrtn: Button
    private lateinit var blog: Button
    private lateinit var bln: Button
    private lateinit var bfact: Button
    private lateinit var bsin: Button
    private lateinit var bcos: Button
    private lateinit var btan: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter = Presenter(this)
        initView()
    }

    override fun initView() {
        input = findViewById(R.id.input)
        oper = findViewById(R.id.oper)
        b0 = findViewById(R.id.b0)
        b1 = findViewById(R.id.b1)
        b2 = findViewById(R.id.b2)
        b3 = findViewById(R.id.b3)
        b4 = findViewById(R.id.b4)
        b5 = findViewById(R.id.b5)
        b6 = findViewById(R.id.b6)
        b7 = findViewById(R.id.b7)
        b8 = findViewById(R.id.b8)
        b9 = findViewById(R.id.b9)
        bsqrt = findViewById(R.id.bsqrt)
        bsqr = findViewById(R.id.bsqr)
        bper = findViewById(R.id.bper)
        bclear = findViewById(R.id.bclear)
        bsum = findViewById(R.id.bsum)
        bdif = findViewById(R.id.bdif)
        bmult = findViewById(R.id.bmult)
        bdiv = findViewById(R.id.bdiv)
        bdel = findViewById(R.id.bdel)
        bdot = findViewById(R.id.bdot)
        bres = findViewById(R.id.bres)
        if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            bsqrn = findViewById(R.id.bsqrn)
            bsqrtn = findViewById(R.id.bsqrtn)
            blog = findViewById(R.id.blog)
            bln = findViewById(R.id.bln)
            bfact = findViewById(R.id.bfact)
            bsin = findViewById(R.id.bsin)
            bcos = findViewById(R.id.bcos)
            btan = findViewById(R.id.btan)
            bsqrn.setOnClickListener{
                presenter.biFunctionClicked("a^n")
            }
            bsqrtn.setOnClickListener {
                presenter.biFunctionClicked("sqrtn")
            }
            bsin.setOnClickListener {
                presenter.monoFunctionClicked("sin")
            }
            bcos.setOnClickListener {
                presenter.monoFunctionClicked("cos")
            }
            btan.setOnClickListener {
                presenter.monoFunctionClicked("tan")
            }
            bln.setOnClickListener {
                presenter.monoFunctionClicked("ln")
            }
            bfact.setOnClickListener {
                presenter.monoFunctionClicked("!")
            }
            blog.setOnClickListener {
                presenter.biFunctionClicked("log")
            }
        }
        b0.setOnClickListener {
            presenter.buttonClicked(0)
        }
        b1.setOnClickListener{
            presenter.buttonClicked(1)
        }
        b2.setOnClickListener{
            presenter.buttonClicked(2)
        }
        b3.setOnClickListener{
            presenter.buttonClicked(3)
        }
        b4.setOnClickListener {
            presenter.buttonClicked(4)
        }
        b5.setOnClickListener {
            presenter.buttonClicked(5)
        }
        b6.setOnClickListener {
            presenter.buttonClicked(6)
        }
        b7.setOnClickListener {
            presenter.buttonClicked(7)
        }
        b8.setOnClickListener {
            presenter.buttonClicked(8)
        }
        b9.setOnClickListener {
            presenter.buttonClicked(9)
        }
        bsqrt.setOnClickListener {
            presenter.monoFunctionClicked("sqrt")
        }
        bsqr.setOnClickListener {
            presenter.monoFunctionClicked("sqr")
        }
        bper.setOnClickListener {
            presenter.monoFunctionClicked("per")
        }
        bsum.setOnClickListener {
            presenter.biFunctionClicked("sum")
        }
        bdif.setOnClickListener {
            presenter.biFunctionClicked("dif")
        }
        bmult.setOnClickListener {
            presenter.biFunctionClicked("mult")
        }
        bdiv.setOnClickListener {
            presenter.biFunctionClicked("div")
        }
        bclear.setOnClickListener {
            presenter.clear()
        }
        bdel.setOnClickListener {
            presenter.delete()
        }
        bdot.setOnClickListener {
            presenter.dot()
        }
        bres.setOnClickListener {
            presenter.getResult()
        }
    }

    override fun updateView() {
        input.text = presenter.getResult()
        oper.text = presenter.getOperation()
    }
}
