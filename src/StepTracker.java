public class StepTracker {
    Converter converter = new Converter();
    MonthData[] monthData;
    int goalStep = 10000;

    public StepTracker() {
        monthData = new MonthData[12];
        for (int i = 0; i < monthData.length; i++) {
            monthData[i] = new MonthData();
        }
    }

    public void inputCountStepDay(int month, int day, int steps){
        monthData[month].daySteps[day] = steps;
    }

    public void statisticsMonth (int month){
        printStepDay(month);
        System.out.println("\nОбщее количество шагов за месяц: " + sumStepMonth(month));
        System.out.println("Максимальное пройденное количество шагов в месяце: " + maxStepsPerDay(month));
        System.out.println("Среднее количество шагов: " + sumStepMonth(month)/monthData[month].daySteps.length);
        System.out.println("Пройденная дистанция (в км): " + converter.passedDistance(sumStepMonth(month)));
        System.out.println("Количество сожжённых килокалорий: " + converter.burnCalories(sumStepMonth(month)));
        System.out.println("Лучшая серия: " + bestSeries(month));
    }

    private void printStepDay (int month){
        for (int i = 0; i < monthData[month].daySteps.length; i++){
            System.out.print(String.format("%d день: %d, ", i+1, monthData[month].daySteps[i]));
        }
    }

    private int sumStepMonth(int month){
        int stepSum = 0;
        for(int i = 0; i < monthData[month].daySteps.length; i++){
            stepSum = stepSum + monthData[month].daySteps[i];
        }
        return stepSum;
    }

    private int maxStepsPerDay(int month){
        int maxSteps = 0;
        for(int i = 0; i < monthData[month].daySteps.length; i++){
            if(maxSteps < monthData[month].daySteps[i]){
                maxSteps = monthData[month].daySteps[i];
            }
        }
        return maxSteps;
    }

    private int bestSeries(int month){
        int contDayBestSeries = 0;
        int seriesDay = 0;
        for (int i = 0; i < monthData[month].daySteps.length; i++){
            if(monthData[month].daySteps[i] >= goalStep){
                seriesDay++;
                if (seriesDay > contDayBestSeries){
                    contDayBestSeries = seriesDay;
                }
            }
            else{
                seriesDay = 0;
            }
        }
        return  contDayBestSeries;
    }

    public void goalStepDay(int goal){
        goalStep = goal;
    }

    class MonthData {
        int[] daySteps = new int[30];

        public MonthData() {
            for (int i = 0; i < daySteps.length; i++) {
                daySteps[i] = 0;
            }
        }
    }
}
