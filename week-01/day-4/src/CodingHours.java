public class CodingHours {
    public static void main(String[] args) {
        int dailyCodingHours = 6;
        int semesterPeriodInWeeks = 17;
        int semesterPeriodWorkDays = semesterPeriodInWeeks * 5;

        //System.out.println(semesterPeriodWorkDays);

        int codingHoursPerSemester = dailyCodingHours * semesterPeriodWorkDays;

        System.out.println(codingHoursPerSemester);

        int averageWorkHours = 52;
        int totalWorkingHours = semesterPeriodInWeeks * averageWorkHours;
        double percentageOfCodingHours = (double) codingHoursPerSemester / averageWorkHours ;

        System.out.println(percentageOfCodingHours);

    }
}
