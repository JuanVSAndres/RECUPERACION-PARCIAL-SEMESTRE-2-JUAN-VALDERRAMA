package entities;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class NormalActivity extends Activity {

    private List<Step> steps;

    public NormalActivity(String name, String state, Iteration iteration) {
        super(name, state, iteration);
        this.steps = new ArrayList<>();
    }

    public void addStep(Step step) {
        this.steps.add(step);
    }
    /**
     * Obtiene la duración de la Actividad normal
     * @return la duracion en dias del Actividad normal
     * @throws SabanaResearchException
     */
    @Override
    public Duration getDuration() throws SabanaResearchException{

        Duration d = Duration.ofDays(0);
        if(steps.size() == 0)
        {
            throw new SabanaResearchException(SabanaResearchException.BAD_FORMED_NORMAL_ACTIVITY);
        }
        for(Step s: this.steps)
        {
           d=d.plus(s.getDuration());
        }


        return d;
    }
}
