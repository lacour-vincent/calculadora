package lacour.vincent.calculadora

import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

class Evaluator(var label: String) {

    fun addElement(element: Char): String {
        this.label += element
        return this.label
    }

    fun removeLastElement(): String {
        this.label = label.dropLast(1)
        return this.label
    }

    fun clear(): String {
        this.label = ""
        return this.label
    }

    fun eval(): String {
        try {
            val convertedLabel = this.label
                .replace("÷", "/")
                .replace("×", "*")
                .replace("%", "*0.01")
            val expression = ExpressionBuilder(convertedLabel).build()
            val res: Double = expression.evaluate()
            return res.toString()
        } catch (e: Exception) {
            return "Error"
        } finally {
            this.label = ""
        }
    }

}