import org.jetbrains.annotations.NotNull;

import java.util.Objects;

/**
 * Класс содержащий информацию о профессии.
 */

public class Profession implements Comparable {
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
     *
     * @param averageSalary  Средний уровень зарплаты.
     * @param workExperience Трудовой стаж для пенсии.
     * @param name           Название профессии.
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
     *
     * @return averageSalary Средний уровень зарплаты.
     */
    public int getAverageSalary() {
        return averageSalary;
    }

    /**
     * Устанавливает средний уровень зарплаты.
     *
     * @param averageSalary Средний уровень зарплаты.
     */
    public void setAverageSalary(int averageSalary) {
        if (averageSalary >= 0) {
            this.averageSalary = averageSalary;
        }
    }

    /**
     * Возвращает трудовой стаж для пенсии.
     *
     * @return workExperience Трудовой стаж.
     */
    public double getWorkExperience() {
        return workExperience;
    }

    /**
     * Устанавливает трудовой стаж для пенсии.
     *
     * @param workExperience Трудовой стаж.
     */
    public void setWorkExperience(double workExperience) {
        if (workExperience > 0) {
            this.workExperience = workExperience;
        }
    }

    /**
     * Возвращает название профессии.
     *
     * @return name Название профессии.
     */
    public String getName() {
        return name;
    }

    /**
     * Устанавливает название профессии.
     *
     * @param name Название профессии.
     */
    public void setName(String name) {
        if (!name.isEmpty()) {
            this.name = name;
        }
    }

    /**
     * Возвращает уровень образования.
     *
     * @return educationLevel Уровень образования.
     */
    public String getEducationLevel() {
        return educationLevel;
    }

    /**
     * Устанавливает уровень образования.
     *
     * @param educationLevel Уровень образования.
     */
    public void setEducationLevel(String educationLevel) {
        if (!educationLevel.isEmpty()) {
            this.educationLevel = educationLevel;
        }
    }

    /**
     * Возвращает рейтинг профессии (по 5-ой шкале).
     *
     * @return Рейтинг профессии.
     */
    public int getRatingInfo() {
        int highRate = 70000;
        int mediumRate = 35000;
        int lowRate = 15000;
        int zeroRate = 0;

        if (this.averageSalary > highRate) {
            return 5;
        } else if (this.averageSalary > mediumRate) {
            return 4;
        } else if (this.averageSalary > lowRate) {
            return 3;
        } else if (this.averageSalary > zeroRate) {
            return 2;
        } else if (this.averageSalary == zeroRate) {
            return 1;
        } else {
            return 0;
        }
    }

    /**
     * Формирует строку с данными о профессии
     *
     * @return строковое представление профессии
     */
    @Override
    public String toString() {
        return "Профессия: { " +
                "Название профессии: " + name +
                ", Средний уровень зарплаты: " + averageSalary +
                ", Трудовой стаж: " + workExperience +
                ", Уровень образования: " + educationLevel +
                ", Рейтинг профессии: " + getRatingInfo() + " }";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Profession that = (Profession) o;
        return averageSalary == that.averageSalary &&
                Double.compare(that.workExperience, workExperience) == 0 &&
                Objects.equals(name, that.name) &&
                Objects.equals(educationLevel, that.educationLevel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(averageSalary, workExperience, name, educationLevel);
    }

    @Override
    public int compareTo(@NotNull Object o) {
        if (o instanceof Profession profession) {
            int result = getAverageSalary() - profession.getAverageSalary();
            return Integer.compare(result, 0);
        }
        return 0;
    }
}
