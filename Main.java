// Терентьев Никита Александрович КИ21-16/1Б
// Вариант 18
// Профессия
// Необходимо реализовать класс согласно варианту.
// Необходимо придумать поля: числовые и текстовые.

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static java.util.stream.Collectors.counting;

/**
 * Класс используется для работы программы, управления объектами.
 */

public class Main {

    /**
     * Список профессий
     */
    private static List<Profession> professionsArray = new ArrayList<>();

    private final static PrintStream out = new PrintStream(System.out, true, StandardCharsets.UTF_8);

    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Функция выводит меню программы.
     */
    public static void printMenu() {

        out.println("""
                ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓
                ┃                 Меню программы                 ┃
                ┣━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┫
                ┃ 1. Добавление профессии по умолчанию           ┃
                ┃ 2. Добавление профессии с информацией          ┃
                ┃ 3. Редактирование профессии                    ┃
                ┃ 4. Удаление профессии                          ┃
                ┃ 5. Вывод информации о профессиях               ┃
                ┃ 6. Сортировка списка профессий                 ┃
                ┃ 7. Фильтрация профессий по трудовому стажу     ┃
                ┃ 8. Удаление повторяющихся профессий            ┃
                ┃ 9. Группировка по уровню образования           ┃
                ┃ 10. Получение информации о рейтингах профессий ┃
                ┃ 11. Сумма всех зарплат                         ┃
                ┃ 12. Найти самую высокооплачиваемую профессию   ┃
                ┃ 13. Выход                                      ┃
                ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛""");
    }

    /**
     * Функция выводит меню параметров.
     */
    public static void printMenuEdit() {
        out.println("""
                ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓
                ┃          Параметры профессии          ┃
                ┣━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┫
                ┃ 1. Название профессии                 ┃
                ┃ 2. Средний уровень зарплаты           ┃
                ┃ 3. Трудовой стаж для пенсии           ┃
                ┃ 4. Требуемый уровень образования      ┃
                ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛""");
    }

    /**
     * Функция для вывода предупреждения.
     *
     * @param choice Выбор сообщения.
     */
    public static void printError(int choice) {
        if (choice == 1) {
            out.println("""
                    ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓
                    ┃      Профессии ещё не добавлены       ┃
                    ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛""");
        }

        if (choice == 2) {
            out.println("""
                    ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓
                    ┃  Неверный номер профессии.  ┃
                    ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛""");
        }

        if (choice == 3) {
            out.println("""
                    ┏━━━━━━━━━━━━━━━━━━━━━━━━━━┓
                    ┃  Новое значение задано.  ┃
                    ┗━━━━━━━━━━━━━━━━━━━━━━━━━━┛""");
        }

        if (choice == 4) {
            out.println("""
                    ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓
                    ┃  Такого пункта нет в меню.  ┃
                    ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛""");
        }

    }

    /**
     * Функция для проверки, что ввод - целое число.
     *
     * @return userInt Целое число.
     */
    public static int checkInt() {
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        int userInt = 0;
        boolean correctInput = false;

        do {
            try {
                userInt = Integer.parseInt(userInput);
                if (userInt <= 0) {
                    out.print("┃ Число должно быть больше нуля. Введите число: ");
                    userInput = scanner.nextLine();
                } else {
                    correctInput = true;
                }

            } catch (NumberFormatException ex) {
                out.print("┃ Неверный ввод. Введите число: ");
                userInput = scanner.nextLine();
            }
        } while (!correctInput);
        return userInt;
    }

    /**
     * Функция для проверки, что ввод - вещественное число.
     *
     * @return userDouble Вещественное число.
     */
    public static double checkDouble() {
        String userInput = scanner.nextLine();
        double userDouble = 0.0;
        boolean correctInput = false;

        do {
            try {
                userDouble = Double.parseDouble(userInput);
                if (userDouble <= 0) {
                    out.print("┃ Число должно быть больше нуля. Введите число: ");
                    userInput = scanner.nextLine();
                } else {
                    correctInput = true;
                }
            } catch (NumberFormatException ex) {
                out.print("┃ Неверный ввод. Введите число: ");
                userInput = scanner.nextLine();
            }
        } while (!correctInput);

        return userDouble;
    }

    /**
     * Добавление профессии по-умолчанию.
     */
    public static void addDefaultProfession() {
        professionsArray.add(new Profession());
        out.println("""
                ┏━━━━━━━━━━━━━━━━━━━━━━━━┓
                ┃  Профессия добавлена   ┃
                ┗━━━━━━━━━━━━━━━━━━━━━━━━┛""");
    }

    /**
     * Получение уровня образования
     * @return уровень образования
     */
    public static String getEducationLevel() {
        String[] array = {
                "Начальное", "Среднее", "Высшее", "Профессиональное"
        };
        ArrayList<String> arrayOfEduLevel = new ArrayList<>(Arrays.asList(array));

        out.print("┃ Доступные для ввода значения: ");
        out.println(arrayOfEduLevel);
        String userInput;
        boolean correctInput = false;
        out.print("┃ Введите значение: ");

        do {
            userInput = scanner.nextLine();

            if (arrayOfEduLevel.contains(userInput)) {
                correctInput = true;
            }

            else {
                out.print("┃ Неверный ввод. Введите значение: ");
            }

        } while (!correctInput);

        return userInput;
    }

    /**
     * Добавление профессии с данными, введённые пользователем.
     */
    public static void addCustomProfession() {

        out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        out.print("┃ Введите название профессии: ");
        String name = scanner.next();

        out.print("┃ Введите средний уровень зарплаты (целое число): ");
        int averageSalary = checkInt();
        scanner.nextLine();

        out.print("┃ Введите трудовой стаж для пенсии (вещественное число): ");
        double workExperience = checkDouble();

        out.println("┃ Введите требуемый уровень образования: ");
        String educationLevel = getEducationLevel();

        out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");

        professionsArray.add(new Profession(averageSalary, workExperience, name, educationLevel));
    }

    /**
     * Вывод всех профессий с параметрами.
     */
    public static void printProfessions(List<Profession> professions) {
        Stream<Profession> stream = professions.stream();
        stream.forEach(out::println);
    }

    /**
     * Удаление профессии.
     */
    public static void deleteProfession() {
        if (professionsArray.isEmpty()) {
            printError(1);
        } else {
            printProfessions(professionsArray);
            out.print("┃ Введите номер профессии для удаления: ");
            int index = checkInt();

            if (index < 1 || index > professionsArray.size()) {
                printError(2);
            } else {
                professionsArray.remove(index - 1);
                out.println("┃ Профессия №" + index + " удалена.");
            }
        }
    }

    /**
     * Редактирование профессии.
     */
    public static void editProfession() {


        if (professionsArray.isEmpty()) {
            printError(1);
        } else {
            printProfessions(professionsArray);
            out.print("┃ Введите номер профессии, которую хотите изменить: ");
            int indexEdit = checkInt();

            if (indexEdit < 1 || indexEdit > professionsArray.size()) {
                printError(2);
            } else {
                printMenuEdit();
                out.print("┃ Введите номер пункта: ");
                int numberParameter = checkInt();

                switch (numberParameter) {
                    case 1 -> {
                        out.print("┃ Введите новое значение: ");
                        String newName = scanner.nextLine();
                        while (newName.isEmpty()) {
                            out.print("┃ Неверный ввод. Введите новое название: ");
                            newName = scanner.nextLine();
                        }
                        professionsArray.get(indexEdit - 1).setName(newName);
                        printError(3);
                    }
                    case 2 -> {
                        out.print("┃ Введите новое значение: ");
                        int newAverageSalary = checkInt();
                        professionsArray.get(indexEdit - 1).setAverageSalary(newAverageSalary);
                        printError(3);
                    }
                    case 3 -> {
                        out.print("┃ Введите новое значение: ");
                        double newWorkExperience = checkDouble();
                        professionsArray.get(indexEdit - 1).setWorkExperience(newWorkExperience);
                        printError(3);
                    }
                    case 4 -> {
                        out.print("┃ Введите новое значение: ");
                        String newEducationLevel = scanner.nextLine();
                        while (newEducationLevel.isEmpty()) {
                            out.print("┃ Неверный ввод. Введите новое название: ");
                            newEducationLevel = scanner.nextLine();
                        }
                        professionsArray.get(indexEdit - 1).setEducationLevel(newEducationLevel);
                        printError(3);
                    }
                    default -> printError(4);
                }
            }
        }
    }

    /**
     * Получение различных параметров о рейтинге профессии.
     * (Демонстрация умения работать с SummaryStatistics)
     */
    public static void getRatingStatistic() {
        IntSummaryStatistics ratingStatistic = professionsArray.stream().mapToInt(Profession::getRatingInfo).summaryStatistics();
        out.println("┃ " + ratingStatistic.getCount() + " профессии/й");
        out.println("┃ Средний уровень рейтинга профессий: " + ratingStatistic.getAverage());
        out.println("┃ Максимальный уровень рейтинга профессии: " + ratingStatistic.getMax());
        out.println("┃ Минимальный уровень рейтинга профессии: " + ratingStatistic.getMin());
    }


    /**
     * Сортировка профессий по их полям.
     */
    public static void sortProfessions() {

        if (professionsArray.isEmpty()) {
            printError(1);
        } else {
            printMenuEdit();

            out.print("┃ Введите номер пункта, по которому нужно отсортировать: ");
            int numToSort = checkInt();

            switch (numToSort) {
                case 1 -> {
                    Comparator<Profession> nameComparator = Comparator.comparing(Profession::getName);
                    professionsArray.sort(nameComparator);
                }
                case 2 -> {
                    Comparator<Profession> averageSalaryComparator = Comparator.comparing(Profession::getAverageSalary);
                    professionsArray.sort(averageSalaryComparator);
                }
                case 3 -> {
                    Comparator<Profession> workExperienceComparator =
                            Comparator.comparing(Profession::getWorkExperience);
                    professionsArray.sort(workExperienceComparator);
                }
                case 4 -> {
                    Comparator<Profession> educationLevelComparator =
                            Comparator.comparing(Profession::getEducationLevel);
                    professionsArray.sort(educationLevelComparator);
                }
                default -> printError(4);
            }

            out.println("""
                    ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━┓
                    ┃  Профессии отсортированы  ┃
                    ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━┛""");
        }
    }

    /**
     * Фильтрация профессий по трудовому стажу
     */
    public static void filterByWorkExperience() {
        out.print("┃ Введите трудовой стаж для пенсии (найдутся профессии, значение которых больше или равно): ");
        double workExperience = checkDouble();
        Stream<Profession> professions = professionsArray.stream().filter(profession -> profession.getWorkExperience() >= workExperience);
        List<Profession> newProfessionsList = professions.collect(Collectors.toCollection(ArrayList::new));
        printProfessions(newProfessionsList);
    }

    /**
     * Изъятие из массива/списка дубликатов.
     */
    public static void deleteDuplicates() {
        Stream<Profession> stream = professionsArray.stream().distinct();
        int oldLength = professionsArray.size();
        professionsArray = stream.collect(Collectors.toCollection(ArrayList::new));
        long deletedLength = oldLength - professionsArray.size();
        if (deletedLength > 0){
            out.printf("┃ %d повторяющаяся/ихся профессия/ий была/о удалена/о.\n", deletedLength);
        }
        else{
            out.println("┃ Повторяющиеся профессии не были найдены.");
        }
    }

    /**
     * Группировка профессий по уровню образования
     */
    public static void groupByEducationLevel() {
        Map<String, List<Profession>> professionByLevOfEdu = professionsArray.stream().collect(Collectors.groupingBy(Profession::getEducationLevel));
        Map<String, Long> professionByLevOfEduCounts = professionsArray.stream().collect(
                Collectors.groupingBy(Profession::getEducationLevel, counting()));

        for(String key : professionByLevOfEdu.keySet()){
            out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
            out.println("┃ Уровень образования: " + key + ", количество: " + professionByLevOfEduCounts.get(key));
            out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
            for (Profession profession : professionByLevOfEdu.get(key)){
                out.println(profession);
            }
        }
    }

    /**
     * Вычисление суммы всех зарплат.
     * (Демонстрация умения работать с операциями сведения с накоплением).
     */
    public static void calculateTheSalary() {
        long start = 0;
        long result = professionsArray.stream().reduce(start, (value, profession) -> value + profession.getAverageSalary(), Long::sum);

        out.println("┃ Сумма всех зарплат: " + result);
    }


    /**
     * Нахождение самой высокооплачиваемой профессии.
     * (Демонстрация умения работать с типом Optional)
     */
    public static void findHighestSalary() {
        Optional<Profession> largest = professionsArray.stream().max(Profession::compareTo);
        largest.ifPresent(profession -> System.out.println("| Самая высокооплачиваемая профессия: " + profession));
    }


    /**
     * Основная функция программы, в которой происходит
     * ввод и вывод данных, выполнение алгоритма.
     *
     * @param args массив переменных, введённых при запуске
     *             основной функции.
     */
    public static void main(String[] args) {

        professionsArray.add(new Profession(30000, 5.5, "Слесарь", "Среднее"));
        professionsArray.add(new Profession(45000, 10.2, "Учитель", "Высшее"));
        professionsArray.add(new Profession(70000, 7, "Программист", "Бакалавриат"));
        professionsArray.add(new Profession(45000, 10.2, "Учитель", "Высшее"));

        String userChoice;

        do {
            printMenu();
            out.print("┃ Введите номер пункта: ");
            userChoice = scanner.nextLine();

            switch (userChoice) {
                case "1" -> addDefaultProfession();
                case "2" -> addCustomProfession();
                case "3" -> editProfession();
                case "4" -> deleteProfession();
                case "5" -> printProfessions(professionsArray);
                case "6" -> sortProfessions();
                case "7" -> filterByWorkExperience();
                case "8" -> deleteDuplicates();
                case "9" -> groupByEducationLevel();
                case "10" -> getRatingStatistic();
                case "11" -> calculateTheSalary();
                case "12" -> findHighestSalary();
                // Выход
                case "13" -> out.println("""
                        ┏━━━━━━━━━━━━━━━━━━━━━━━━━┓
                        ┃ Завершение программы... ┃
                        ┗━━━━━━━━━━━━━━━━━━━━━━━━━┛
                        """);
                default -> printError(4);
            }

        } while (!userChoice.equals("13"));
    }
}
