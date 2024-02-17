import cova.assingment.firstexercise.Operations;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FibonacciTests {

   @Test
   public void fibonacciTest(){
//       Operations.fibonacci(5);
       Assertions.assertEquals(2, Operations.fibonacci(3));
   }

    @Test
    public void fibonacciOptimalTest(){
//       Operations.fibonacci(5);
        Assertions.assertEquals(5, Operations.fibonacciOptimal(5)[0]);
    }
}
