import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;
import java.io.PrintWriter;

/**
 * Classes Class.
 * This class will hold various public static methods that
 * will let you read and write to the database.
 * Has a total of 4 static methods, including a main method
 * @author gcanales6
 * @version 1.3
 */

public class Classes {
    /**
     * Iterates through a file and creates the appropriate Course object for each line.
     * Adds the created Course to a Course list.
     * @param fileName String representing the name of the file to be read
     * @return Course list representing the Course objects present in the file
     * @throws FileNotFoundException thrown if file is null (doesn't exist)
     * @throws InvalidCourseException thrown if invalid Course was found in the file
     */
    public static ArrayList<Course> outputCourses(String fileName)
        throws FileNotFoundException, InvalidCourseException {
        if (fileName == null) {
            throw new FileNotFoundException("File is null.");
        }
        File file = new File(fileName);
        if (!file.exists()) {
            throw new FileNotFoundException("File does not exist.");
        }
        ArrayList<Course> courses = new ArrayList<>();
        try (Scanner input = new Scanner(file).useDelimiter(",|\r\n|\n");) {
            while (input.hasNext()) {
                String courseType = input.next();
                if (courseType.equals("ComputerScience")) {
                    String courseName = input.next();
                    int id = input.nextInt();
                    String professorName = input.next();
                    String language = input.next();
                    courses.add(new ComputerScience(courseName, id, professorName, language));
                } else if (courseType.equals("LabScience")) {
                    String courseName = input.next();
                    int id = input.nextInt();
                    String professorName = input.next();
                    boolean labCoatRequired = input.nextBoolean();
                    courses.add(new LabScience(courseName, id, professorName, labCoatRequired));
                } else {
                    throw new InvalidCourseException();
                }
            }
        }
        return courses;
    }

    /**
     * Iterates through a Course list and writes each Course object to its own line in the file.
     * @param fileName String representing the file to be written
     * @param courses Course list representing the Course objects to add to the file
     * @return boolean representing if the writting was successful
     * @throws FileNotFoundException thrown if file is null (doesn't exist)
     * @throws InvalidCourseException thrown if invalid Course was found in the file
     */
    public static boolean writeCourses(String fileName, ArrayList<Course> courses)
        throws FileNotFoundException, InvalidCourseException {
        PrintWriter output = null;
        boolean written;
        try {
            File file = new File(fileName);
            if (!file.exists()) {
                output = new PrintWriter(file);
                output.close();
            }
            ArrayList<Course> totalCourses = Classes.outputCourses(fileName);
            output = new PrintWriter(file);
            totalCourses.addAll(courses);
            for (int i = 0; i < totalCourses.size(); i++) {
                if (totalCourses.get(i) == null) {
                    continue;
                }
                try {
                    output.println(totalCourses.get(i).toString());
                } catch (InvalidCourseException icex) {
                    output.flush();
                    throw new InvalidCourseException();
                }
            }
            output.close();
        } catch (FileNotFoundException fnfex) {
            throw new FileNotFoundException("Writing to the file was not successful.");
        } finally {
            written = output != null ? true : false;
        }
        return written;
    }

    /**
     * Searches a file for the inputted Course object, adding its line number to an Integer list.
     * @param fileName String representing the name of the file to be read
     * @param course Course representing the course to be found in the file
     * @return Integer list containing the line numbers where the course if found in the file
     * @throws FileNotFoundException thrown if file is null (doesn't exist)
     * @throws InvalidCourseException thrown if invalid Course was found in the file
     */
    public static ArrayList<Integer> readCourses(String fileName, Course course)
        throws FileNotFoundException, InvalidCourseException {
        try {
            File file = new File(fileName);
            ArrayList<Integer> linesOfCourse = new ArrayList<>();
            try (Scanner input = new Scanner(file).useDelimiter(",|\r\n|\n");) {
                int lineNumber = 1;
                while (input.hasNext()) {
                    String courseType = input.next();
                    if (courseType.equals("ComputerScience")) {
                        String courseName = input.next();
                        int id = input.nextInt();
                        String professorName = input.next();
                        String language = input.next();
                        if (course.equals(new ComputerScience(courseName, id, professorName, language))) {
                            linesOfCourse.add((Integer) lineNumber);
                        }
                    } else if (courseType.equals("LabScience")) {
                        String courseName = input.next();
                        int id = input.nextInt();
                        String professorName = input.next();
                        boolean labCoatRequired = input.nextBoolean();
                        if (course.equals(new LabScience(courseName, id, professorName, labCoatRequired))) {
                            linesOfCourse.add((Integer) lineNumber);
                        }
                    } else {
                        throw new InvalidCourseException();
                    }
                    lineNumber++;
                }
                return linesOfCourse;
            }
        } catch (FileNotFoundException fnfex) {
            throw new FileNotFoundException("Could not read the Courses from the file.");
        }
    }

    /**
     * main method.
     * @param args String[] representing the contents of the main method
     * @throws FileNotFoundException thrown if file doesn't exist
     */
    public static void main(String[] args) throws FileNotFoundException {
        ComputerScience cs1331 = new ComputerScience("CS1331", 32138, "Landry", "Java");
        ComputerScience cs1332 = new ComputerScience("CS1332", 54321, "Not Landry", "Java");
        ComputerScience cs1301 = new ComputerScience("CS1301", 19204, "Different Prof", "Python");
        LabScience eas = new LabScience("EAS2600", 31032, "Naif", false);
        LabScience phys = new LabScience("PHYS2211", 80392, "Greco", false);
        LabScience chem = new LabScience("CHEM2380", 29302, "Howitz", true);
        ArrayList<Course> courses = new ArrayList<>() {
            {
                add(cs1331);
                add(cs1332);
                add(cs1301);
                add(eas);
                add(phys);
                add(chem);
            }
        };
        try {
            Classes.writeCourses("TestCourses.csv", courses);
        } catch (FileNotFoundException fnfex) {
            throw new FileNotFoundException(fnfex.getMessage());
        } catch (InvalidCourseException icex) {
            throw new InvalidCourseException();
        }
        ComputerScience cs2050 = new ComputerScience("CS2050", 21392, "Some Prof", "Math");
        ArrayList<Course> moreCourses = new ArrayList<>() {
            {
                add(cs2050);
            }
        };
        try {
            boolean written = Classes.writeCourses("TestCourses.csv", moreCourses);
            System.out.println("writeCourses returns: " + written);
        } catch (FileNotFoundException fnfex) {
            throw new FileNotFoundException(fnfex.getMessage());
        } catch (InvalidCourseException icex) {
            throw new InvalidCourseException();
        }
        Classes.outputCourses("TestCourses.csv").forEach((c) -> System.out.println(c.toString()));
        System.out.println("");
        Classes.readCourses("Courses.csv", cs1331).forEach((c) -> System.out.println(c.toString()));
    }
}
