// Терентьев Никита Александрович КИ21-16/1Б
// Вариант 18
// Профессия
// Необходимо реализовать класс согласно варианту.
// Необходимо придумать поля: числовые и текстовые.

import java.util.*;

/**
 * Класс используется для работы программы, управления объектами.
 */

public class Main {

    /**
     * Функция выводит меню программы.
     */
    public static void printMenu() {

        System.out.println("""
                    ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓
                    ┃            Меню программы             ┃
                    ┣━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┫
                    ┃ 1. Добавление профессии по умолчанию  ┃
                    ┃ 2. Добавление профессии с информацией ┃
                    ┃ 3. Редактирование профессии           ┃
                    ┃ 4. Удаление профессии                 ┃
                    ┃ 5. Вывод информации о профессиях      ┃
                    ┃ 6. Сортировка списка профессий        ┃
                    ┃ 7. Выход                              ┃
                    ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛""");
    }

    /**
     * Функция выводит меню параметров.
     */
    public static void printMenuEdit() {
        System.out.println("""
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
     * @param choice Выбор сообщения.
     */
    public static void printError(int choice) {
        if (choice == 1) {
            System.out.println("""
                    ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓
                    ┃      Профессии ещё не добавлены       ┃
                    ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛""");
        }

        if (choice == 2) {
            System.out.println("""
                    ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓
                    ┃  Неверный номер профессии.  ┃
                    ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛""");
        }

        if (choice == 3) {
            System.out.println("""
                    ┏━━━━━━━━━━━━━━━━━━━━━━━━━━┓
                    ┃  Новое значение задано.  ┃
                    ┗━━━━━━━━━━━━━━━━━━━━━━━━━━┛""");
        }

        if (choice == 4) {
            System.out.println("""
                    ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓
                    ┃  Такого пункта нет в меню.  ┃
                    ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛""");
        }

    }

    /**
     * Функция для проверки, что ввод - целое число.
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
                    System.out.print("┃ Число должно быть больше нуля. Введите число: ");
                    userInput = scanner.nextLine();
                }
                else {
                    correctInput = true;
                }

            } catch (NumberFormatException ex) {
                System.out.print("┃ Неверный ввод. Введите число: ");
                userInput = scanner.nextLine();
            }
        } while (!correctInput);
        return userInt;
    }

    /**
     * Функция для проверки, что ввод - вещественное число.
     * @return userDouble Вещественное число.
     */
    public static double checkDouble() {
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        double userDouble = 0.0;
        boolean correctInput = false;

        do {
            try {
                userDouble = Double.parseDouble(userInput);
                if (userDouble <= 0) {
                    System.out.print("┃ Число должно быть больше нуля. Введите число: ");
                    userInput = scanner.nextLine();
                }
                else {
                    correctInput = true;
                }
            } catch (NumberFormatException ex) {
                System.out.print("┃ Неверный ввод. Введите число: ");
                userInput = scanner.nextLine();
            }
        } while (!correctInput);

        return userDouble;
    }

    /**
     * Добавление профессии по-умолчанию.
     * @param professions Список объектов.
     */
    public static void addDefaultProfession(ArrayList<Profession> professions) {
        professions.add(new Profession());
        System.out.println("""
                    ┏━━━━━━━━━━━━━━━━━━━━━━━━┓
                    ┃  Профессия добавлена   ┃
                    ┗━━━━━━━━━━━━━━━━━━━━━━━━┛""");
    }

    /**
     * Добавление профессии с данными, введённые пользователем.
     * @param professions Список объектов.
     */
    public static void addCustomProfession(ArrayList<Profession> professions) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.print("┃ Введите название профессии: ");
        String name = scanner.next();

        System.out.print("┃ Введите средний уровень зарплаты (целое число): ");
        int averageSalary = checkInt();

        System.out.print("┃ Введите трудовой стаж для пенсии (вещественное число): ");
        double workExperience = checkDouble();

        System.out.print("┃ Введите требуемый уровень образования: ");
        String educationLevel = scanner.next();

        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");

        professions.add(new Profession(averageSalary, workExperience, name, educationLevel));
    }

    /**
     * Вывод всех профессий с параметрами.
     * @param professions Список объектов.
     */
    public static void printProfessions(ArrayList<Profession> professions) {
        int count = 1;

        if (professions.isEmpty()) {
            printError(1);
        }
        else {
            for (Profession p : professions) {
                System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
                System.out.println("┃                     Профессия "+"№"+count+"                    ┃");
                System.out.println("┣━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
                System.out.println("┃ Название профессии: " + p.getName());
                System.out.println("┃ Средний уровень зарплаты: " + p.getAverageSalary());
                System.out.println("┃ Трудовой стаж необходимый для выхода на пенсию: "
                + p.getWorkExperience());
                System.out.println("┃ Требуемый уровень образования: " + p.getEducationLevel());
                System.out.println("┣━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
                System.out.println("┃ Рейтинг профессии: " + p.getRatingInfo());
                System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
                count++;
            }
        }
    }

    /**
     * Удаление профессии.
     * @param professions Список объектов.
     */
    public static void deleteProfession(ArrayList<Profession> professions) {
        if (professions.isEmpty()) {
            printError(1);
        }
        else {
            printProfessions(professions);
            System.out.print("┃ Введите номер профессии для удаления: ");
            int index = checkInt();

            if (index < 1 || index > professions.size()) {
                printError(2);
            }

            else {
                professions.remove(index - 1);
                System.out.println("┃ Профессия №" + index + " удалена.");
            }
        }
    }

    /**
     * Редактирование профессии.
     * @param professions Список объектов.
     */
    public static void editProfession(ArrayList<Profession> professions) {
        Scanner scanner = new Scanner(System.in);

        if (professions.isEmpty()) {
            printError(1);
        }
        else {
            printProfessions(professions);
            System.out.print("┃ Введите номер профессии, которую хотите изменить: ");
            int indexEdit = checkInt();

            if (indexEdit < 1 || indexEdit > professions.size()) {
                printError(2);
            }

            else {
                printMenuEdit();
                System.out.print("┃ Введите номер пункта: ");
                int numberParameter = checkInt();

                switch(numberParameter) {
                    case 1:
                        System.out.print("┃ Введите новое значение: ");
                        String newName = scanner.nextLine();
                        while (newName.isEmpty()) {
                            System.out.print("┃ Неверный ввод. Введите новое название: ");
                            newName = scanner.nextLine();
                        }
                        professions.get(indexEdit - 1).setName(newName);
                        printError(3);
                        break;

                    case 2:
                        System.out.print("┃ Введите новое значение: ");
                        int newAverageSalary = checkInt();
                        professions.get(indexEdit - 1).setAverageSalary(newAverageSalary);
                        printError(3);
                        break;

                    case 3:
                        System.out.print("┃ Введите новое значение: ");
                        double newWorkExperience = checkDouble();
                        professions.get(indexEdit - 1).setWorkExperience(newWorkExperience);
                        printError(3);
                        break;

                    case 4:
                        System.out.print("┃ Введите новое значение: ");
                        String newEducationLevel = scanner.nextLine();
                        while (newEducationLevel.isEmpty()) {
                            System.out.print("┃ Неверный ввод. Введите новое название: ");
                            newEducationLevel = scanner.nextLine();
                        }
                        professions.get(indexEdit - 1).setEducationLevel(newEducationLevel);
                        printError(3);
                        break;

                    default:
                        printError(4);
                }
            }
        }
    }

    /**
     * Сортировка профессий по их полям.
     * @param professions Список объектов.
     */
    public static void sortProfessions(ArrayList<Profession> professions) {

        if (professions.isEmpty()) {
            printError(1);
        }
        else {
            printMenuEdit();

            System.out.print("┃ Введите номер пункта, по которому нужно отсортировать: ");
            int numToSort = checkInt();

            switch (numToSort) {
                case 1:
                    Comparator<Profession> nameComparator = Comparator.comparing(Profession::getName);
                    professions.sort(nameComparator);
                    break;

                case 2:
                    Comparator<Profession> averageSalaryComparator = Comparator.comparing(Profession::getAverageSalary);
                    professions.sort(averageSalaryComparator);
                    break;

                case 3:
                    Comparator<Profession> workExperienceComparator =
                            Comparator.comparing(Profession::getWorkExperience);
                    professions.sort(workExperienceComparator);
                    break;

                case 4:
                    Comparator<Profession> educationLevelComparator =
                            Comparator.comparing(Profession::getEducationLevel);
                    professions.sort(educationLevelComparator);
                    break;

                default:
                    printError(4);
            }

            System.out.println("""
                            ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━┓
                            ┃  Профессии отсортированы  ┃
                            ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━┛""");
        }


    }

    /**
     * Основная функция программы, в которой происходит
     * ввод и вывод данных, выполнение алгоритма.
     * @param args массив переменных, введённых при запуске
     *             основной функции.
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String userChoice;
        ArrayList<Profession> professions = new ArrayList<>();

        do {
            printMenu();
            System.out.print("┃ Введите номер пункта: ");
            userChoice = scanner.nextLine();

            switch (userChoice) {

                case "1":
                    addDefaultProfession(professions);
                    break;

                case "2":
                    addCustomProfession(professions);
                    break;

                case "3":
                    editProfession(professions);
                    break;

                case "4":
                    deleteProfession(professions);
                    break;

                case "5":
                    printProfessions(professions);
                    break;

                case "6":
                    sortProfessions(professions);
                    break;

                // Выход
                case "7":
                    System.out.println("""
                    ┏━━━━━━━━━━━━━━━━━━━━━━━━━┓
                    ┃ Завершение программы... ┃
                    ┗━━━━━━━━━━━━━━━━━━━━━━━━━┛
                    """);
                    break;

                default:
                    printError(4);
            }

        } while (!userChoice.equals("7"));
    }
}
