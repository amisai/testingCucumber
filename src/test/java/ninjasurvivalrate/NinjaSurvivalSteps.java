package ninjasurvivalrate;

import cuke4duke.annotation.I18n.EN.Given;
import cuke4duke.annotation.I18n.EN.Then;
import cuke4duke.annotation.I18n.EN.When;

import java.util.Collection;

import static junit.framework.Assert.*;

public class NinjaSurvivalSteps {

    private Ninja ninja;
    private Collection<String> actions;

    @Given("^the ninja has a ([a-z]*) level black\\-belt$")
    public void theNinjaHasABlackbelt(String level) {
        ninja = new Ninja(level);
    }

    @When("^attacked by [a\\s]*(.*)$")
    public void attackedBy(String opponent) {
        actions = ninja.attackedBy(opponent);
    }

    @Then("^the ninja should (.*)$")
    public void theNinjaShould(String action) {
        assertTrue(actions.contains(action));
    }
}