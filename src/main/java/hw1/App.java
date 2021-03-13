package hw1;

import com.epam.tat.module4.Calculator;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Calculator calc = new Calculator();
        System.out.println(calc.div(81.0,0.0));
        System.out.println(calc.sub(0,0));
    }
}
