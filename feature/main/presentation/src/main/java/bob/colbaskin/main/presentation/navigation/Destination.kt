package bob.colbaskin.main.presentation.navigation

import kotlinx.serialization.Serializable

sealed interface Graphs {
    @Serializable
    data object Onboarding : Graphs

    @Serializable
    data object Dashboard : Graphs
}

sealed interface Destinations {
    @Serializable
    data object Welcome : Destinations

    @Serializable
    data object Introduction : Destinations

    @Serializable
    data object SignIn : Destinations

    @Serializable
    data object Home : Destinations
}