import java.util.stream.Stream;

public class Exercise8 {
    public static void main(String[] args) {
        Stream<Character> characters = Stream.of('e', 'f', 'g');

        concatenateCharsToString(characters);
    }

    public static void concatenateCharsToString(Stream<Character> characters) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("a").append("b").append("c");

        characters.forEach(stringBuilder::append);

        System.out.println(stringBuilder);

    }
}
