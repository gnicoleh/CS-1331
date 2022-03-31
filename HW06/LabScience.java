/**
 * LabScience Class.
 * Extends Course.
 * This class represents a lab science.
 * Contains 1 private instnce variable
 * Contains a 4-args constructor
 * Has a total of 2 methods
 * @author gcanales6
 * @version 1.3
 */

public class LabScience extends Course {
    private boolean labCoatRequired;

    /**
     * 4-args constructor for LabScience.
     * @param courseName String representing the name of the Course
     * @param id int representing the Course id
     * @param professorName String representing the name of the professor
     * @param labCoatRequired boolean representing if the lab requires a coat
     */
    public LabScience(String courseName, int id, String professorName, boolean labCoatRequired) {
        super(courseName, id, professorName);
        this.labCoatRequired = labCoatRequired;
    }

    @Override
    public String toString() {
        return "LabScience," + super.toString() + "," + this.labCoatRequired;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof LabScience) {
            LabScience other = (LabScience) o;
            return super.equals(o) && this.labCoatRequired == other.labCoatRequired;
        } else {
            return false;
        }
    }
}
