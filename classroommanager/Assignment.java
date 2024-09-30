package classroommanager;

public class Assignment {
    private String details;
    private boolean isSubmitted;

    public Assignment(String details) {
        this.details = details;
        this.isSubmitted = false;
    }

    public String getDetails() {
        return details;
    }

    public boolean isSubmitted() {
        return isSubmitted;
    }

    public void markAsSubmitted() {
        this.isSubmitted = true;
    }

    @Override
    public String toString() {
        return "Assignment: " + details + " | Submitted: " + isSubmitted;
    }
}
