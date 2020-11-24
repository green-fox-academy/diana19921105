//String todoText = " - Buy milk\n";
//// Add "My todo:" to the beginning of the todoText
//// Add " - Download games" to the end of the todoText
//// Add " - Diablo" to the end of the todoText but with indention
//
//// Expected output:
//
//// My todo
////  - Buy milk
////  - Download games
////      - Diablo

public class ToDoList {
    public static void main(String[] args) {

        String todoText = "My todo\n";
        String buyMilk = "- Buy milk\n";
        String game = "- Download games\n";
        String diablo = "- Diablo\n";
        todoText += buyMilk + game + diablo.replace('-', '\t');

        System.out.println(todoText);

    }
}
