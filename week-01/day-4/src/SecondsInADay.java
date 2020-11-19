public class SecondsInADay {
    public static void main(String[] args) {
        int currentHours = 14;
        int currentMinutes = 34;
        int currentSeconds = 42;

        int secondsInADay = 24 * 60 * 60;
        int currentMinuteOfTheDay = currentHours * 60 + currentMinutes;
        int currentSecondsOfTheDay = currentMinuteOfTheDay * 60 + currentSeconds;
        int remainSeconds = secondsInADay - currentSecondsOfTheDay;

        System.out.println(remainSeconds);
    }
}
