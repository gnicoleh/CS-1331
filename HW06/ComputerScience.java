/**
 * ComputerScience Class.
 * Extends Course.
 * This class describes a computer science course.
 * Contains 1 private instance variable
 * Contains a 4-args constructor
 * Has a total of 3 methods, including a private setter
 * @author gcanales6
 * @version 1.3
 */

public class ComputerScience extends Course {
    private String language;

    /**
     * 4-args constructor for ComputerScience.
     * @param courseName String representing the name of the Course
     * @param id int representing the Course id
     * @param professorName String representing the name of the professor
     * @param language String representing the programming language used on the course
     */
    public ComputerScience(String courseName, int id, String professorName, String language) {
        super(courseName, id, professorName);
        setLanguage(language);
    }

    @Override
    public String toString() {
        return "ComputerScience," + super.toString() + "," + this.language;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof ComputerScience) {
            ComputerScience other = (ComputerScience) o;
            return super.equals(o) && this.language.equals(other.language);
        } else {
            return false;
        }
    }

    /**
     * Setter for language.
     * @param language String representing the new value of language
     */
    private void setLanguage(String language) {
        if (language == null || language.equals("")) {
            throw new IllegalArgumentException();
        } else {
            this.language = language;
        }
    }
}
