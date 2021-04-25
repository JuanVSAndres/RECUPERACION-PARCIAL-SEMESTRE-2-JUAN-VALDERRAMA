package entities;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class DocumentedActivity extends Activity {

    private NormalActivity activity;
    private ISynthesizer synthesizer;
    private List<Question> questions;

    public DocumentedActivity(String name, String state, Iteration iteration, NormalActivity activity) {
        super(name, state, iteration);
        this.activity = activity;
        this.questions = new ArrayList<>();
    }

    public void addQuestion(Question question) {
        this.questions.add(question);
    }
    /**
     * Obtiene la duración de la Actividad documentada
     * @return la duracion en dias del Actividad documentada
     * @throws SabanaResearchException
     */
    @Override
    public Duration getDuration() throws SabanaResearchException{

        Duration d = Duration.ofDays(0);
        if(questions.size() == 0)
        {
            throw new SabanaResearchException(SabanaResearchException.BAD_FORMED_DOCUMENTED_ACTIVITY);
        }
        if(activity == null)
        {
            throw new SabanaResearchException(SabanaResearchException.BAD_FORMED_DOCUMENTED_ACTIVITY_WITHOUT_NORMAL_QUESTION);
        }
        for(Question q: this.questions)
        {
            d=d.plus(q.getDedication());
        }
        d=d.plus(activity.getDuration());

        return d;
    }
}
