package solutions.exercise2

fun main() {
    val scenarios = listOf(
        Scenario(
            ID = "1",
            GameMode = "crowd",
            Site = "MLT",
            Game = "1",
            VehicleCategory = "12",
        ),
        Scenario(
            ID = "2",
            GameMode = "logistics",
            Site = "MLF",
            Game = "1",
            VehicleCategory = "11",
        ),
        Scenario(
            ID = "3",
            GameMode = "crowd",
            Site = "MLT",
            Game = "2",
            VehicleCategory = "11",
        ),
        Scenario(
            ID = "1",
            GameMode = "crowd",
            Site = "MLZ",
            Game = "2",
            VehicleCategory = "11",
        ),
    )

    val siteSpec = SiteSpecification(Site = "MLT")
    val modeSpec = ModeSpecification(Mode = "crowd")
    val gameSpec = GameSpecification(Game = "2")
    val catAndSceSpec = CategoryAndScenarioSpecification(Category = "11", Scenario = "2")

    println(scenarios.filter(siteSpec))
    println(scenarios.filter(modeSpec))
    println(scenarios.filter(gameSpec))
    println(scenarios.filter(catAndSceSpec))
}

data class Scenario(
    val ID: ScenarioID,
    val GameMode: GameMode,
    val Site: Site,
    val Game: Game,
    val VehicleCategory: CategoryID
)

typealias Scenarios = List<Scenario>
typealias Site = String
typealias GameMode = String
typealias Game = String
typealias CategoryID = String
typealias ScenarioID = String

interface Specification {
    fun IsSatisfied(p: Scenario): Boolean
}

data class SiteSpecification(val Site: Site) : Specification {
    override fun IsSatisfied(p: Scenario): Boolean {
        return p.Site == Site
    }
}

data class ModeSpecification(val Mode: GameMode) : Specification {
    override fun IsSatisfied(p: Scenario): Boolean {
        return p.GameMode == Mode
    }
}

data class GameSpecification(val Game: Game) : Specification {
    override fun IsSatisfied(p: Scenario): Boolean {
        return p.Game == Game
    }
}

data class CategoryAndScenarioSpecification(val Category: CategoryID, val Scenario: ScenarioID) : Specification {
    override fun IsSatisfied(p: Scenario): Boolean {
        return p.VehicleCategory == Category && p.ID == Scenario
    }
}

fun Scenarios.filter(specification: Specification): Scenarios {
    val result = mutableListOf<Scenario>()
    for (v in this) {
        if (specification.IsSatisfied(v)) {
            result.add(v)
        }
    }
    return result
}
