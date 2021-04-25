package entities;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class ExecutiveSynthesizer implements ISynthesizer{

    @Override
    public List<String> SynthetizerProject(Project p) {

        List<String> iterationsData = new ArrayList<>();

        for(Iteration s: p.getIterations())
        {
            String name = s.getGoal();
            Duration WorkedHours;
            try {
                 WorkedHours = s.getDuration();

            }
            catch (SabanaResearchException e)
            {
                WorkedHours = Duration.ofDays(0);
            }
            iterationsData.add(name+", "+WorkedHours.toDays());
        }
        System.out.println(iterationsData);
        return iterationsData;
    }
}
