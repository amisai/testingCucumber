package ninjasurvivalrate;

import java.util.List;
import java.util.Map;
import cuke4duke.annotation.I18n.EN.Given;
import cuke4duke.annotation.I18n.EN.Then;
import cuke4duke.annotation.I18n.EN.When;

import java.util.Collection;

import static junit.framework.Assert.*;

public class NinjaSurvivalSteps {

    private Ninja ninja;
    private Collection<String> actions;
    private NinjaContext ninjaContext;

    public NinjaSurvivalSteps(NinjaContext ninjaContext) {
        this.ninjaContext = ninjaContext;
    }

    @Given("^the ninja has a ([a-z]*) level black\\-belt$")
    public void theNinjaHasABlackbelt(String level) {
        ninjaContext.setNinja(new Ninja(level));
    }

    @Given("^a ninja with the following experience$")
    public void ninjaWithExperience(cuke4duke.Table table) {
        List<Map<String, String>> hashes = table.hashes();
        Map<String, String> ninjaProperties = hashes.get(0);
        ninjaContext.setNinja(new Ninja(ninjaProperties.get("belt_level")));
    }

    @When("^attacked by [a\\s]*(.*)$")
    public void attackedBy(String opponent) {
        actions = ninjaContext.getNinja().attackedBy(opponent);
    }

    @Then("^the ninja should (.*)$")
    public void theNinjaShould(String action) {
        assertTrue(actions.contains(action));
    }
}