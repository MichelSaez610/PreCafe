package com.precafe.precafe

class Provider {
    companion object {

        fun getPlatsNames(): List<String> {
            return Plats.map { it.primerPlat }
        }

        fun getBegudesNames(): List<String> {
            return Begudes.map { it.begudes }
        }

        val Plats: List<PrimerPlatsModel> = listOf(
            PrimerPlatsModel("Macarrones", 10),
            PrimerPlatsModel("Arroz a la cubana", 6),
            PrimerPlatsModel("Ensalada", 5),
            PrimerPlatsModel("Spaghetti",8),
            PrimerPlatsModel("Lentejas",13),
            PrimerPlatsModel("Guisantes",12)
        )

        val Begudes: List<BegudesModel> = listOf(
            BegudesModel("Agua",1.5),
            BegudesModel("Vino", 10),
            BegudesModel("Nestik", 2.5),
            BegudesModel("Cocacola", 2),
            BegudesModel("Fanta", 2.5)
        )
    }
}