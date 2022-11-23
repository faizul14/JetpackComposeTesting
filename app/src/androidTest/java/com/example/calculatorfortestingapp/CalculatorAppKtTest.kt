package com.example.calculatorfortestingapp

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import com.example.calculatorfortestingapp.ui.theme.CalculatorForTestingAppTheme
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class CalculatorAppKtTest{
    @get:Rule
    val composeTestRule = createComposeRule()

    /*
    NOTE
    Annotation @Before digunakan supaya fungsi ini dipanggil terlebih dahulu sebelum setiap
    fungsi lainnya dipanggil secara otomatis
    */
    @Before
    fun setUp() {
        composeTestRule.setContent {
            CalculatorForTestingAppTheme() {
                CalculatorApp()
            }
        }
    }


    /*
    NOTE
    onNodeWithText: mencari elemen dengan teks tertentu.
    performTextInput: melakukan aksi untuk memasukkan input pada TextField.
    performClick: melakukan aksi untuk menekan elemen yang dipilih.
    assertExists: memastikan suatu elemen eksis atau ada.
    */
    @Test
    fun perhitungan_calculator_menghasilkan_nilai_yang_benar() {
        composeTestRule.onNodeWithText("Masukkan panjang").performTextInput("3")
        composeTestRule.onNodeWithText("Masukkan lebar").performTextInput("4")
        composeTestRule.onNodeWithText("Hitung!").performClick()
        composeTestRule.onNodeWithText("Hasil: 12.0").assertExists()
    }
}