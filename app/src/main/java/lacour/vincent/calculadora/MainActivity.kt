package lacour.vincent.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AlertDialog
import lacour.vincent.calculadora.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val evaluator = Evaluator("")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(findViewById(R.id.toolbar_activity_main))

        binding.buttonZero.setOnClickListener { addElementToScreen('0') }
        binding.buttonOne.setOnClickListener { addElementToScreen('1') }
        binding.buttonTwo.setOnClickListener { addElementToScreen('2') }
        binding.buttonThree.setOnClickListener { addElementToScreen('3') }
        binding.buttonFour.setOnClickListener { addElementToScreen('4') }
        binding.buttonFive.setOnClickListener { addElementToScreen('5') }
        binding.buttonSix.setOnClickListener { addElementToScreen('6') }
        binding.buttonSeven.setOnClickListener { addElementToScreen('7') }
        binding.buttonEight.setOnClickListener { addElementToScreen('8') }
        binding.buttonNine.setOnClickListener { addElementToScreen('9') }

        binding.buttonDot.setOnClickListener { addElementToScreen('.') }
        binding.buttonPercentage.setOnClickListener { addElementToScreen('%') }

        binding.buttonAdd.setOnClickListener { addElementToScreen('+') }
        binding.buttonMinus.setOnClickListener { addElementToScreen('-') }
        binding.buttonMultiply.setOnClickListener { addElementToScreen('×') }
        binding.buttonDivide.setOnClickListener { addElementToScreen('÷') }

        binding.buttonEqual.setOnClickListener { performCalculation() }

        binding.buttonDelete.setOnClickListener { removeLastElementToScreen() }
        binding.buttonClear.setOnClickListener { clearScreen() }
    }

    private fun addElementToScreen(element: Char) {
        binding.textviewScreen.text = evaluator.addElement(element)
    }

    private fun removeLastElementToScreen() {
        binding.textviewScreen.text = evaluator.removeLastElement()
    }

    private fun clearScreen() {
        binding.textviewScreen.text = evaluator.clear()
    }

    private fun performCalculation() {
        binding.textviewScreen.text = evaluator.eval()
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
        builder.setPositiveButton(this.getString(R.string.information_yes)) { _, _ -> }
        builder.show()
    }

}
