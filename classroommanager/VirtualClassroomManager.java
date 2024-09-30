package classroommanager;

import java.util.ArrayList;
import java.util.List;

public class VirtualClassroomManager {
    private List<Classroom> classrooms;

    public VirtualClassroomManager() {
        this.classrooms = new ArrayList<>();
    }

    // Add a new classroom
    public void addClassroom(String className) {
        classrooms.add(new Classroom(className));
        System.out.println("Classroom " + className + " has been created.");
    }

    // Remove a classroom
    public void removeClassroom(String className) {
        boolean removed = classrooms.removeIf(c -> c.getName().equalsIgnoreCase(className));
        if (removed) {
            System.out.println("Classroom " + className + " has been removed.");
        } else {
            System.out.println("Error: Classroom " + className + " not found.");
        }
    }

    // Find a classroom by name
    public Classroom getClassroomByName(String className) {
        return classrooms.stream()
                .filter(c -> c.getName().equalsIgnoreCase(className))
                .findFirst()
                .orElse(null);
    }

    // Enroll a student in a classroom
    public void addStudent(String studentId, String studentName, String className) {
        Classroom classroom = getClassroomByName(className);
        if (classroom != null) {
            classroom.addStudent(new Student(studentId, studentName));
            System.out.println("Student " + studentId + " (" + studentName + ") has been enrolled in " + className + ".");
        } else {
            System.out.println("Error: Classroom " + className + " not found.");
        }
    }

    // Remove a student from a classroom
    public void removeStudent(String studentId, String className) {
        Classroom classroom = getClassroomByName(className);
        if (classroom != null) {
            boolean removed = classroom.removeStudent(studentId);
            if (removed) {
                System.out.println("Student " + studentId + " has been removed from " + className + ".");
            } else {
                System.out.println("Error: Student " + studentId + " not found in " + className + ".");
            }
        } else {
            System.out.println("Error: Classroom " + className + " not found.");
        }
    }

    // Schedule an assignment for a classroom
    public void scheduleAssignment(String className, String assignmentDetails) {
        Classroom classroom = getClassroomByName(className);
        if (classroom != null) {
            classroom.addAssignment(new Assignment(assignmentDetails));
            System.out.println("Assignment for " + className + " has been scheduled.");
        } else {
            System.out.println("Error: Classroom " + className + " not found.");
        }
    }

    // Submit an assignment for a student in a classroom
    public void submitAssignment(String studentId, String className, String assignmentDetails) {
        Classroom classroom = getClassroomByName(className);
        if (classroom != null) {
            for (Assignment assignment : classroom.getAssignments()) {
                if (assignment.getDetails().equalsIgnoreCase(assignmentDetails) && !assignment.isSubmitted()) {
                    assignment.markAsSubmitted();
                    System.out.println("Assignment submitted by Student " + studentId + " in " + className + ".");
                    return;
                }
            }
            System.out.println("Error: Assignment not found or already submitted.");
        } else {
            System.out.println("Error: Classroom " + className + " not found.");
        }
    }

    // List all classrooms
    public void listClassrooms() {
        if (classrooms.isEmpty()) {
            System.out.println("No classrooms available.");
        } else {
            classrooms.forEach(c -> System.out.println(c.toString()));
        }
    }

    // List all students in a classroom
    public void listStudentsInClassroom(String className) {
        Classroom classroom = getClassroomByName(className);
        if (classroom != null) {
            if (classroom.getStudents().isEmpty()) {
                System.out.println("No students enrolled in " + className + ".");
            } else {
                classroom.getStudents().forEach(s -> System.out.println(s.toString()));
            }
        } else {
            System.out.println("Error: Classroom " + className + " not found.");
        }
    }

    // List all assignments in a classroom
    public void listAssignmentsInClassroom(String className) {
        Classroom classroom = getClassroomByName(className);
        if (classroom != null) {
            if (classroom.getAssignments().isEmpty()) {
                System.out.println("No assignments scheduled for " + className + ".");
            } else {
                classroom.getAssignments().forEach(a -> System.out.println(a.toString()));
            }
        } else {
            System.out.println("Error: Classroom " + className + " not found.");
        }
    }
}
