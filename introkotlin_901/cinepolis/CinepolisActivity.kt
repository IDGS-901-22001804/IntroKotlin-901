package com.negabytes.introkotlin_901.cinepolis

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.negabytes.introkotlin_901.R

class CinepolisActivity : AppCompatActivity() {

    private lateinit var nameEditText: EditText
    private lateinit var buyersEditText: EditText
    private lateinit var ticketsEditText: EditText
    private lateinit var yesRadioButton: RadioButton
    private lateinit var totalTextView: TextView
    private lateinit var calculateButton: Button

    private val TICKET_PRICE = 12.0
    private val MAX_TICKETS_PER_PERSON = 7

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cinepolis)

        initViews()

        calculateButton.setOnClickListener {
            calculateTotal()
        }
    }

    private fun initViews() {
        nameEditText = findViewById(R.id.nameEditText)
        buyersEditText = findViewById(R.id.buyersEditText)
        ticketsEditText = findViewById(R.id.ticketsEditText)
        yesRadioButton = findViewById(R.id.yesRadioButton)
        totalTextView = findViewById(R.id.totalTextView)
        calculateButton = findViewById(R.id.calculateButton)
    }

    private fun calculateTotal() {
        val name = nameEditText.text.toString().trim()
        if (name.isEmpty()) {
            nameEditText.error = "Ingrese su nombre"
            return
        }

        val buyersText = buyersEditText.text.toString()
        val ticketsText = ticketsEditText.text.toString()

        if (buyersText.isEmpty() || ticketsText.isEmpty()) {
            Toast.makeText(this, "Complete todos los campos", Toast.LENGTH_SHORT).show()
            return
        }

        try {
            val buyers = buyersText.toInt()
            val tickets = ticketsText.toInt()

            if (tickets < 1) {
                ticketsEditText.error = "Mínimo 1 boleto"
                return
            }

            val maxTickets = buyers * MAX_TICKETS_PER_PERSON
            if (tickets > maxTickets) {
                ticketsEditText.error = "Máximo $maxTickets boletos"
                return
            }

            var total = tickets * TICKET_PRICE

            total = when {
                tickets > 5 -> total * 0.85
                tickets >= 3 -> total * 0.90
                else -> total
            }

            if (yesRadioButton.isChecked) {
                total *= 0.90
            }

            totalTextView.text = "$${"%.2f".format(total)}"

            Toast.makeText(this,
                "Nombre: $name\nBoletos: $tickets\nTotal: $${"%.2f".format(total)}",
                Toast.LENGTH_LONG).show()

        } catch (e: NumberFormatException) {
            Toast.makeText(this, "Ingrese valores válidos", Toast.LENGTH_SHORT).show()
        }
    }
}