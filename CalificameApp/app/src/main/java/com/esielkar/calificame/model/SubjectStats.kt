package com.esielkar.calificame.model

/**
 * Representa las estisticas de una materia de la aplicación Califícame!
 * @constructor Crea las estadisticas de una materia dadas la facilidad, claridad, recomendación
 * dominio, complejidad, evaluación justa, si aplica examenes y la cantidad de examenes
 * @throws StatsOutOfRangeException si facility, clarity, recommendation, domain, complexity
 * fairEvaluation, applyExams, no están en el rango de valores de 1 - 100.
 */
class SubjectStats//Range
    (facility: Double = 0.0,
     clarity: Double = 0.0,
     recommendation: Double = 0.0,//Stats
     var domain: Double = 0.0,
     var complexity: Double = 0.0,
     var fairEvaluation: Double = 0.0,
     var applyExams: Double = 0.0,
     var examsCount: Int = 0
) : Stats(facility, clarity, recommendation) {

    init {
        val range = 0.0..100.0 //Range
        when {
            domain !in range -> throw StatsOutOfRangeException("Domain out of range. Range: from 0 up to 100")
            complexity !in range -> throw StatsOutOfRangeException("Complexity out of range. Range: from 0 up to 100")
            fairEvaluation !in range -> throw StatsOutOfRangeException("FairEvaluatiob out of range. Range: from 0 up to 100")
            applyExams !in range -> throw StatsOutOfRangeException("ApplyExams out of range. Range: from 0 up to 100")
        }
    }
}