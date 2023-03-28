package exercise2

fun main() {
    val scenarios = Scenarios(
        Scenario(
            "1",
            "crowd",
            "MLT",
            "1",
            "12"
        ),
        Scenario(
            "2",
            "logistics",
            "MLF",
            "1",
            "11"
        ),
        Scenario(
            "3",
            "crowd",
            "MLT",
            "2",
            "11"
        ),
        Scenario(
            "1",
            "crowd",
            "MLZ",
            "2",
            "11"
        )
    )

    val bySite = scenarios.filterBySite("MLT")
    println(bySite)
}

data class Scenario(
    val id: String,
    val gameMode: String,
    val site: String,
    val game: String,
    val vehicleCategory: String
)

class Scenarios(vararg scenarios: Scenario) : ArrayList<Scenario>(scenarios.toList()) {

    // FilterBySite returns only the scenarios that match the site criteria.
    fun filterBySite(site: String): Scenarios {
        val filteredScenarios = Scenarios()

        for (scenario in this) {
            if (scenario.site == site) {
                filteredScenarios.add(scenario)
            }
        }

        return filteredScenarios
    }

    // FilterByMode returns only the scenarios that match the game mode.
    fun filterByMode(mode: String): Scenarios {
        val filteredScenarios = Scenarios()

        for (scenario in this) {
            if (scenario.gameMode == mode) {
                filteredScenarios.add(scenario)
            }
        }

        return filteredScenarios
    }

    // FilterByGame returns only the scenarios that match the game.
    fun filterByGame(game: String): Scenarios {
        val filteredScenarios = Scenarios()

        for (scenario in this) {
            if (scenario.game == game) {
                filteredScenarios.add(scenario)
            }
        }

        return filteredScenarios
    }
}
