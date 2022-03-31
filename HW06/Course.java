/**
 * Course Class.
 * Abstract class.
 * Contains 3 protected instance variables
 * Contains a 3-args constructor
 * Has a total of 5 methods, including 3 private setters
 * @author gcanales6
 * @version 1.3
 */

public abstract class Course {
    protected String courseName;
    protected int id;
    protected String professorName;

    /**
     * 3-args constructor to be used as a super constructor by a child.
     * @param courseName String representing the name of the Course
     * @param id int representing the Course id
     * @param professorName String representing the name of the professor
     */
    public Course(String courseName, int id, String professorName) {
        setCourseName(courseName);
        setId(id);
        setProfessorName(professorName);
    }

    @Override
    public String toString() {
        return String.format("%s,%d,%s", this.courseName, this.id, this.professorName);
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Course) {
            Course other = (Course) o;
            return this.courseName.equals(other.courseName) && this.id == other.id
                && this.professorName.equals(other.professorName);
        } else {
            return false;
        }
    }

    /**
     * Setter for courseName.
     * @param courseName String representing the new value of courseName
     */
    private void setCourseName(String courseName) {
        if (courseName == null || courseName.equals("")) {
            throw new IllegalArgumentException();
        } else {
            this.courseName = courseName;
        }
    }

    /**
     * Setter for Course id.
     * @param id in representing the new value of the id
     */
    private void setId(int id) {
        String length = Integer.toString(id);
        if (id < 0 || length.length() != 5) {
            throw new IllegalArgumentException();
        } else {
            this.id = id;
        }
    }

    /**
     * Setter for professorName.
     * @param professorName String representing the new value of professorName
     */
    private void setProfessorName(String professorName) {
        if (professorName == null || professorName.equals("")) {
            throw new IllegalArgumentException();
        } else {
            this.professorName = professorName;
        }
    }
}
