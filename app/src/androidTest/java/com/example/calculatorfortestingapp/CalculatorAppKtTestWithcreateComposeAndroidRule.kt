package com.example.calculatorfortestingapp

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import com.example.calculatorfortestingapp.ui.theme.CalculatorForTestingAppTheme
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class CalculatorAppKtTestWithcreateComposeAndroidRule{
    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    @Before
    fun setUp(){
        composeTestRule.setContent {
            CalculatorForTestingAppTheme {
                CalculatorApp()
            }
        }
    }

    @Test
    fun perhitungan_calculator_menghasilkan_nilai_yang_benar(){
        composeTestRule.onNodeWithText(composeTestRule.activity.getString(R.string.enter_length)).performTextInput("3")
        composeTestRule.onNodeWithText(composeTestRule.activity.getString(R.string.enter_width))
            .performTextInput("4")
        composeTestRule.onNodeWithText(composeTestRule.activity.getString(R.string.count))
            .performClick()
        composeTestRule.onNodeWithText(composeTestRule.activity.getString(R.string.result, 12.0))
            .assertExists()
    }
}