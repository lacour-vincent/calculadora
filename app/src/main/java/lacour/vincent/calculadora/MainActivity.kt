package lacour.vincent.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AlertDialog

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val evaluator = Evaluator("")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar_activity_main))

        button_zero.setOnClickListener { addElementToScreen('0') }
        button_one.setOnClickListener { addElementToScreen('1') }
        button_two.setOnClickListener { addElementToScreen('2') }
        button_three.setOnClickListener { addElementToScreen('3') }
        button_four.setOnClickListener { addElementToScreen('4') }
        button_five.setOnClickListener { addElementToScreen('5') }
        button_six.setOnClickListener { addElementToScreen('6') }
        button_seven.setOnClickListener { addElementToScreen('7') }
        button_eight.setOnClickListener { addElementToScreen('8') }
        button_nine.setOnClickListener { addElementToScreen('9') }

        button_dot.setOnClickListener { addElementToScreen('.') }
        button_percentage.setOnClickListener { addElementToScreen('%') }

        button_add.setOnClickListener { addElementToScreen('+') }
        button_minus.setOnClickListener { addElementToScreen('-') }
        button_multiply.setOnClickListener { addElementToScreen('×') }
        button_divide.setOnClickListener { addElementToScreen('÷') }

        button_equal.setOnClickListener { performCalculation() }

        button_delete.setOnClickListener { removeLastElementToScreen() }
        button_clear.setOnClickListener { clearScreen() }
    }

    private fun addElementToScreen(element: Char) {
        textview_screen.text = evaluator.addElement(element)
    }

    private fun removeLastElementToScreen() {
        textview_screen.text = evaluator.removeLastElement()
    }

    private fun clearScreen() {
        textview_screen.text = evaluator.clear()
    }

    private fun performCalculation() {
        textview_screen.text = evaluator.eval()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_information -> {
                showInformation()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun showInformation() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle(this.getString(R.string.information_title))
        builder.setMessage(this.getString(R.string.information_description))
        builder.setPositiveButton(android.R.string.yes) { _, _ -> }
        builder.show()
    }

}
