//  From now on, create the usual class wrapper
//  and main method on your own.

// - Create a string variable named `al` and assign the value `Green Fox` to it
// - Create a function called `greet` that greets it's input parameter
//     - Greeting is printing e.g. `Greetings dear, Green Fox`
// - Greet `al`

public class Greeting {

    public static String greet(String greeting, String al){
        greeting = "Greetings dear, ";
        al = "Green Fox";
        
        return greeting;
    }

    public static void main(String[] args){

        System.out.println( greet("heelo", "hhhh"));
    }


}
