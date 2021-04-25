package entities;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
/**
 *  La clase Proyect representa a una interaccion del poryecto
 */
public class Iteration {

    private String goal;
    private Project project;
    private List<Activity> activities;

    public Iteration(String goal, Project project) {
        this.goal = goal;
        this.project = project;
        this.activities = new ArrayList<>();

        project.addIteration(this);
    }

    public void addActivity(Activity activity) {
        this.activities.add(activity);
    }
    /**
     * Obtiene la duración de la interacción
     * @return la duracion en dias del interacción
     * @throws SabanaResearchException
     */
    public Duration getDuration() throws SabanaResearchException{

        Duration d = Duration.ofDays(0);
        if(activities.size() == 0)
        {
            throw new SabanaResearchException(SabanaResearchException.BAD_FORMED_ITERATION);
        }
        for (Activity a: this.activities)
        {
            Duration v = a.getDuration();
            d=d.plus(v);
        }
        return d;
    }

    public String getGoal() {
        return goal;
    }

    public int CountOpenActivities()
    {
        int d=0;
        for (Activity a: this.activities)
        {
            if(a.isActive())
            {
                d++;
            }
        }

        return d;
    }
    /**
     * Devuelve el numero de planes cerrados
     * @return d
     */
    public int CountClosedActivities()
    {
        int d=0;
        for (Activity a: this.activities)
        {
            if(!a.isActive())
            {
                d++;
            }
        }

        return d;
    }
}
