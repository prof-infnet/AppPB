package br.edu.infnet.apppb

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
@LargeTest
class InstrumentedTest {
    @JvmField
    @Rule
    var activityActivityTestRule = ActivityScenarioRule<MainActivity>(MainActivity::class.java)

    @Test
    fun rightPassword_should_startActivity() {

        //Click send button
        onView(withId(R.id.btn_skip)).perform(click())

        onView(withId(R.id.etEmailAddress)).perform(
            typeText("ads@ads.com"),
            ViewActions.closeSoftKeyboard()
        )

        onView(withId(R.id.etPassword)).perform(
            typeText("123456"),
            ViewActions.closeSoftKeyboard()
        )

        onView(withId(R.id.btnLogin)).perform(click())

    }


    @Test
    fun inputRightRegisterData() {


        onView(withId(R.id.btn_skip)).perform(click())

        onView(withId(R.id.tvRedirectSignUp)).perform(click())

        onView(withId(R.id.etSEmailAddress)).perform(typeText("teste@teste.com"), ViewActions.closeSoftKeyboard())
        onView(withId(R.id.etSPassword)).perform(typeText("a11111"), ViewActions.closeSoftKeyboard())
        onView(withId(R.id.etSConfPassword)).perform(typeText("a11111"), ViewActions.closeSoftKeyboard())



    }
}



