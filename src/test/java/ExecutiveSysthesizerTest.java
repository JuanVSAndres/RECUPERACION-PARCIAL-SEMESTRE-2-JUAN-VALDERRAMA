import com.github.javafaker.Faker;
import entities.*;
import org.junit.Assert.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

public class ExecutiveSysthesizerTest {

    private static Faker faker;

    private Project wellFormedProject;

    public ExecutiveSysthesizerTest() {

        faker = new Faker(new Locale("en-US"));
    }

    @BeforeEach
    public void setup() {
        setupWellFormedProject();
    }

    @Test
    public void MakethesummarizeIterations()
    {
        ExecutiveSynthesizer s = new ExecutiveSynthesizer();
        assertTrue(s.SynthetizerProject(wellFormedProject).contains("Protect, 3"));
    }
    private void setupWellFormedProject() {

        Group group = new Group(faker.team().name());
        wellFormedProject = new Project(faker.team().name(), LocalDate.now().minusDays(10), LocalDate.now().plusDays(10), group);
        Iteration iteration = new Iteration("Protect", wellFormedProject);

        // Create a Normal Activity
        NormalActivity normalActivity = new NormalActivity(faker.team().name(), Activity.ACTIVE_STATE, iteration);
        normalActivity.addStep(new Step(faker.team().name(), Duration.ofDays(1)));

        // Create a Documented Activity
        NormalActivity activity = new NormalActivity(faker.team().name(), Activity.ACTIVE_STATE, null);
        activity.addStep(new Step(faker.team().name(), Duration.ofDays(1)));
        DocumentedActivity documentedActivity = new DocumentedActivity(faker.team().name(), Activity.ACTIVE_STATE, iteration, activity);
        documentedActivity.addQuestion(new Question(Question.EASY_QUESTION, faker.team().name(), Duration.ofDays(1)));
    }



}
