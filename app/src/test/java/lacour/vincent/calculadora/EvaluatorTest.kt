package com.example.calculadora

import lacour.vincent.calculadora.Evaluator
import org.junit.Test

import org.junit.Assert.*

class EvaluatorTest {

    @Test
    fun constructor() {
        val evaluator = Evaluator("")
        assertEquals("", evaluator.label)
    }

    @Test
    fun addElement_emptyLabel() {
        val evaluator = Evaluator("")
        assertEquals("1", evaluator.addElement('1'))
    }

    @Test
    fun addElement_notEmptyLabel() {
        val evaluator = Evaluator("1")
        assertEquals("1+", evaluator.addElement('+'))
    }

    @Test
    fun removeLastElement_emptyLabel() {
        val evaluator = Evaluator("")
        assertEquals("", evaluator.removeLastElement())
    }

    @Test
    fun removeLastElement_notEmptyLabel() {
        val evaluator = Evaluator("1+")
        assertEquals("1", evaluator.removeLastElement())
    }

    @Test
    fun clear_emptyLabel() {
        val evaluator = Evaluator("")
        assertEquals("", evaluator.clear())
    }

    @Test
    fun clear_notEmptyLabel() {
        val evaluator = Evaluator("1")
        assertEquals("", evaluator.clear())
    }

    @Test
    fun eval__addition() {
        val evaluator = Evaluator("1+1")
        assertEquals("2.0", evaluator.eval())
    }

    @Test
    fun eval__substraction() {
        val evaluator = Evaluator("2-1")
        assertEquals("1.0", evaluator.eval())
    }

    @Test
    fun eval__multiply() {
        val evaluator = Evaluator("2*3")
        assertEquals("6.0", evaluator.eval())
    }

    @Test
    fun eval__divide() {
        val evaluator = Evaluator("20/5")
        assertEquals("4.0", evaluator.eval())
    }

    @Test
    fun eval__error() {
        val evaluator = Evaluator("1/")
        assertEquals("Error", evaluator.eval())
    }

}