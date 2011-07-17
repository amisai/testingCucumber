package ninjasurvivalrate;

import cuke4duke.annotation.I18n.EN.Given;
import cuke4duke.annotation.I18n.EN.Then;
import cuke4duke.annotation.I18n.EN.When;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.*;

public class SkillSteps {

    private List<Skill> skills;
    private String opponent;

    @Given("^the following skills are allowed$")
    public void setAllowedSkills(cuke4duke.Table table) {
        skills = new ArrayList<Skill>();

        for (List<String> rows : table.raw()) {
            skills.add(new Skill(rows.get(0)));
        }
    }

    @When("^a ninja faces [a ]*([A-z ]*)$")
    public void aNinjaFaces(String opponent) {
        this.opponent = opponent;
    }

    @Then("^he should expect the following attack techniques$")
    public void checkExpectedTechniques(cuke4duke.Table table) {
        for (List<String> rows : table.raw()) {
            if (!"technique".equalsIgnoreCase(rows.get(0))) {
                String tech = rows.get(0);
                String danger = rows.get(1);

                for (Skill skill : skills) {
                    if (skill.availableTo(opponent)) {
                        assertEquals(skill.getName(), tech);
                        assertEquals(skill.getDanger(opponent), danger);
                    }
                }
            }
        }
    }
}
