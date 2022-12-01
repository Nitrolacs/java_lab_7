/**
 * Класс содержащий информацию о профессии.
 */

public class Profession {
    // Числовые поля
    /**
     * Средний уровень зарплаты.
     */
    private int averageSalary;
    /**
     * Стаж работы для пенсии.
     */
    private double workExperience;

    // Текстовые поля
    /**
     * Название профессии.
     */
    private String name;
    /**
     * Уровень образования.
     */
    private String educationLevel;

    /**
     * Конструктор по-умолчанию.
     */
    public Profession() {
        averageSalary = 0;
        workExperience = 0;
        name = "Default";
        educationLevel = "Default";
    }

    /**
     * Конструктор с параметрами.
     * @param averageSalary Средний уровень зарплаты.
     * @param workExperience Трудовой стаж для пенсии.
     * @param name Название профессии.
     * @param educationLevel Уровень образования.
     */
    public Profession(int averageSalary, double workExperience,
                      String name, String educationLevel) {

        this.averageSalary = averageSalary;
        this.workExperience = workExperience;
        this.name = name;
        this.educationLevel = educationLevel;

    }

    /**
     * Возвращает средний уровень зарплаты.
     * @return averageSalary Средний уровень зарплаты.
     */
    public int getAverageSalary() {
        return averageSalary;
    }

    /**
     * Устанавливает средний уровень зарплаты.
     * @param averageSalary Средний уровень зарплаты.
     */
    public void setAverageSalary(int averageSalary) {
        if (averageSalary >= 0) {
            this.averageSalary = averageSalary;
        }
    }

    /**
     * Возвращает трудовой стаж для пенсии.
     * @return workExperience Трудовой стаж.
     */
    public double getWorkExperience() {
        return workExperience;
    }

    /**
     * Устанавливает трудовой стаж для пенсии.
     * @param workExperience Трудовой стаж.
     */
    public void setWorkExperience(double workExperience) {
        if (workExperience > 0)
        {
            this.workExperience = workExperience;
        }
    }

    /**
     * Возвращает название профессии.
     * @return name Название профессии.
     */
    public String getName() {
        return name;
    }

    /**
     * Устанавливает название профессии.
     * @param name Название профессии.
     */
    public void setName(String name) {
        if (!name.isEmpty())
        {
            this.name = name;
        }
    }

    /**
     * Возвращает уровень образования.
     * @return educationLevel Уровень образования.
     */
    public String getEducationLevel() {
        return educationLevel;
    }

    /**
     * Устанавливает уровень образования.
     * @param educationLevel Уровень образования.
     */
    public void setEducationLevel(String educationLevel) {
        if (!educationLevel.isEmpty())
        {
            this.educationLevel = educationLevel;
        }
    }

    /**
     * Возвращает рейтинг профессии.
     * @return Рейтинг профессии.
     */
    public String getRatingInfo()
    {
        int highRate = 70000;
        int mediumRate = 35000;
        int lowRate = 0;

        if (this.averageSalary > highRate) {
            return "Высокий рейтинг профессии";
        }
        else if (this.averageSalary > mediumRate) {
            return "Средний рейтинг профессии";
        }
        else if (this.averageSalary >= lowRate) {
            return "Низкий рейтинг профессии";
        }
        else {
            return "Параметр не задан";
        }
    }
}
