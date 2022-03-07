

import junit.framework.TestCase;

public class CalculadoraTest extends TestCase {
    
    public void testCalculadora(){
        Calculadora miCalculadora = new Calculadora();
        StackFactory s = new StackFactory();
        String expressionInfix = "(1+2)*9";
        assertEquals(27, miCalculadora.Evaluate(miCalculadora.infixToPostfix(s.createStack("ArrayList", null), expressionInfix)));
        assertEquals(19, miCalculadora.Evaluate(miCalculadora.infixToPostfix(s.createStack("ArrayList", null), "1+2*9")));
    }
    
    public void testInfixtoPostfix(){
    	Calculadora miCalculadora = new Calculadora();
    	StackFactory s = new StackFactory();
    	String expressionInfix = "(1+2)*9";
    	assertEquals("1 2 + 9 * ", miCalculadora.infixToPostfix(s.createStack("ArrayList", null), expressionInfix));
    	assertEquals("1 2 9 * + ", miCalculadora.infixToPostfix(s.createStack("ArrayList", null), "1+2*9"));
    }
    
    
}
