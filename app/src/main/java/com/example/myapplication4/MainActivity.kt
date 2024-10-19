package com.example.myapplication4

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

                // Ana Yemekler (RadioGroup ve RadioButton)
                val radioGroupMainCourse: RadioGroup = findViewById(R.id.radioGroupMainCourse)
                val radioButtonIcliKofte: RadioButton = findViewById(R.id.radioButtonIcliKofte)
                val radioButtonKusbasiDurum: RadioButton = findViewById(R.id.radioButtonKusbasiDurum)
                val radioButtonKuruFasulye: RadioButton = findViewById(R.id.radioButtonKuruFasulye)

                // Ekstralar (CheckBox)
                val checkBoxKizartmaTabagi: CheckBox = findViewById(R.id.checkBoxKizartmaTabagi)
                val checkBoxCigKofte: CheckBox = findViewById(R.id.checkBoxCigKofte)
                val checkBoxCorba: CheckBox = findViewById(R.id.checkBoxCorba)

                // İçecekler (CheckBox)
                val checkBoxKola: CheckBox = findViewById(R.id.checkBoxKola)
                val checkBoxAyran: CheckBox = findViewById(R.id.checkBoxAyran)
                val checkBoxSalgam: CheckBox = findViewById(R.id.checkBoxSalgam)

                // Sipariş Ver butonu
                val buttonSiparisVer: Button = findViewById(R.id.buttonSiparisVer)

                buttonSiparisVer.setOnClickListener {
                    // Ana yemek seçimi (Sadece bir tane seçilecek)
                    val selectedMainCourseId = radioGroupMainCourse.checkedRadioButtonId
                    val selectedMainCourse = when (selectedMainCourseId) {
                        R.id.radioButtonIcliKofte -> "İçli Köfte"
                        R.id.radioButtonKusbasiDurum -> "Kuşbaşı Dürüm"
                        R.id.radioButtonKuruFasulye -> "Kuru Fasulye"
                        else -> ""
                    }

                    // Ekstra seçimi (Birden fazla seçilebilir)
                    val extras = mutableListOf<String>()
                    if (checkBoxKizartmaTabagi.isChecked) extras.add("Kızartma Tabağı")
                    if (checkBoxCigKofte.isChecked) extras.add("Çiğköfte")
                    if (checkBoxCorba.isChecked) extras.add("Çorba")

                    // İçecek seçimi (Birden fazla seçilebilir)
                    val drinks = mutableListOf<String>()
                    if (checkBoxKola.isChecked) drinks.add("Kola")
                    if (checkBoxAyran.isChecked) drinks.add("Ayran")
                    if (checkBoxSalgam.isChecked) drinks.add("Şalgam")

                    // Seçimleri Toast ile göster
                    val orderSummary = StringBuilder()
                    orderSummary.append("Ana Yemek: $selectedMainCourse\n")
                    orderSummary.append("Ekstralar: ${extras.joinToString(", ")}\n")
                    orderSummary.append("İçecekler: ${drinks.joinToString(", ")}")

                    Toast.makeText(this, orderSummary.toString(), Toast.LENGTH_LONG).show()
                }
            }
        }





