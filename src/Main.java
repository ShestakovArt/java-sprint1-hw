import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PrintMenu printMenu = new PrintMenu();
        StepTracker stepTracker = new StepTracker();

        System.out.println("Доброго времени суток!");
        while (true){
            printMenu.printMenu();
            int action = scanner.nextInt();
            if(action == 1){
                System.out.println("Введите номер месяца (от 0 до 11):");
                int month = scanner.nextInt();
                System.out.println("Введите день (от 0 до 29):");
                int day = scanner.nextInt();
                int steps;
                while (true){
                    System.out.println("Введите количество шагов:");
                    steps = scanner.nextInt();
                    if (steps >= 0){
                        break;
                    }
                    else{
                        System.out.println("Количество шагов не должно быть отрицательным.");
                    }
                }

                stepTracker.inputCountStepDay(month, day, steps);
            }
            else if(action == 2){
                System.out.println("Введите номер месяца (от 0 до 11):");
                int month = scanner.nextInt();
                stepTracker.statisticsMonth(month);
            }
            else if(action == 3){
                int steps;
                while (true){
                    System.out.println("Введите количество шагов:");
                    steps = scanner.nextInt();
                    if (steps >= 0){
                        break;
                    }
                    else{
                        System.out.println("Количество шагов не должно быть отрицательным.");
                    }
                }
                stepTracker.goalStepDay(steps);
            }
            else if (action == 4 ){
                System.out.println("Выход.");
                break;
            }
            else {
                System.out.println("Извините, введена не корректная команда. Попробуйте еще раз");
            }
        }
    }
}
