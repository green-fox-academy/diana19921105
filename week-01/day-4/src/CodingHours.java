public class CodingHours {
    public static void main(String[] args) {
        int dailyCodingHours = 6;
        int semesterPeriodInWeeks = 17;
        int semesterPeriodWorkDays = semesterPeriodInWeeks * 5;

        int codingHoursPerSemester = dailyCodingHours * semesterPeriodWorkDays;

        System.out.println(codingHoursPerSemester);

        int averageWorkHours = 52;
        int totalWorkingHours = semesterPeriodInWeeks * averageWorkHours;
        double percentageOfCodingHours = ((double) codingHoursPerSemester / totalWorkingHours) * 100;

        System.out.println(percentageOfCodingHours);
    }
}
