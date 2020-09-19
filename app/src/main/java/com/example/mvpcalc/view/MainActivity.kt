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
    private var presenter: Presenter? = null
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
        }
    }

    override fun updateView() {
        TODO("Not yet implemented")
    }
}
