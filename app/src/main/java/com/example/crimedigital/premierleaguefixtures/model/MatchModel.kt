package com.example.crimedigital.premierleaguefixtures.model

data class MatchModel(
    val AwayTeam: String,
    val AwayTeamScore: Int,
    val DateUtc: String,
    val Group: Any,
    val HomeTeam: String,
    val HomeTeamScore: Int,
    val Location: String,
    val MatchNumber: Int,
    val RoundNumber: Int
)


//MatchModel представляет данные о матче.
//Используется для хранения информации о матче, такой как команды, счета, дата и т.д.