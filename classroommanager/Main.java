package classroommanager;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        VirtualClassroomManager manager = new VirtualClassroomManager();
        Scanner scanner = new Scanner(System.in);

        boolean isRunning = true;

        System.out.println("Welcome to the Virtual Classroom Manager!");

        while (isRunning) {
            displayMenu();
            String input = scanner.nextLine().trim();
            String[] commandParts = input.split(" ", 4);

            switch (commandParts[0].toLowerCase()) {
                case "add_classroom":
                    if (commandParts.length > 1) {
                        manager.addClassroom(commandParts[1]);
                    } else {
                        System.out.println("Usage: add_classroom <ClassName>");
                    }
                    break;

                case "remove_classroom":
                    if (commandParts.length > 1) {
                        manager.removeClassroom(commandParts[1]);
                    } else {
                        System.out.println("Usage: remove_classroom <ClassName>");
                    }
                    break;

                case "add_student":
                    if (commandParts.length > 3) {
                        manager.addStudent(commandParts[1], commandParts[2], commandParts[3]);
                    } else {
                        System.out.println("Usage: add_student <StudentID> <StudentName> <ClassName>");
                    }
                    break;

                case "remove_student":
                    if (commandParts.length > 2) {
                        manager.removeStudent(commandParts[1], commandParts[2]);
                    } else {
                        System.out.println("Usage: remove_student <StudentID> <ClassName>");
                    }
                    break;

                case "schedule_assignment":
                    if (commandParts.length > 2) {
                        manager.scheduleAssignment(commandParts[1], commandParts[2]);
                    } else {
                        System.out.println("Usage: schedule_assignment <ClassName> <AssignmentDetails>");
                    }
                    break;

                case "submit_assignment":
                    if (commandParts.length > 3) {
                        manager.submitAssignment(commandParts[1], commandParts[2], commandParts[3]);
                    } else {
                        System.out.println("Usage: submit_assignment <StudentID> <ClassName> <AssignmentDetails>");
                    }
                    break;

                case "list_classrooms":
                    manager.listClassrooms();
                    break;

                case "list_students":
                    if (commandParts.length > 1) {
                        manager.listStudentsInClassroom(commandParts[1]);
                    } else {
                        System.out.println("Usage: list_students <ClassName>");
                    }
                    break;
                case "list_assignments":
                    if (commandParts.length > 1) {
                        manager.listAssignmentsInClassroom(commandParts[1]);
                    } else {
                        System.out.println("Usage: list_assignments <ClassName>");
                    }
                    break;

                case "exit":
                    isRunning = false;
                    System.out.println("Exiting the application. Goodbye!");
                    break;

                default:
                    System.out.println("Unknown command. Please try again.");
            }
        }

        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("\nCommands:");
        System.out.println("1. add_classroom <ClassName>");
        System.out.println("2. remove_classroom <ClassName>");
        System.out.println("3. add_student <StudentID> <StudentName> <ClassName>");
        System.out.println("4. remove_student <StudentID> <ClassName>");
        System.out.println("5. schedule_assignment <ClassName> <AssignmentDetails>");
        System.out.println("6. submit_assignment <StudentID> <ClassName> <AssignmentDetails>");
        System.out.println("7. list_classrooms");
        System.out.println("8. list_students <ClassName>");
        System.out.println("9. list_assignments <ClassName>");
        System.out.println("10. exit");
        System.out.print("Enter your command: ");
    }
}


                
