package entities;

import java.time.LocalDate;

public class Summary {

    private int activeProjects;
    private LocalDate date;
    private int OpenActivities;
    public int ClosedActivities;

    public Summary(int activeProjects, LocalDate date, int OpenActivities, int ClosedActivities) {
        this.activeProjects = activeProjects;
        this.date = date;
        this.OpenActivities = OpenActivities;
        this.ClosedActivities = ClosedActivities;
    }

    public int getActiveProjects() {
        return activeProjects;
    }

    public int getClosedActivities() {
        return ClosedActivities;
    }

    public int getOpenActivities() {
        return OpenActivities;
    }

    public LocalDate getDate() {
        return date;
    }
}
