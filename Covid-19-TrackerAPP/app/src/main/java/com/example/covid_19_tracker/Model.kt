package com.example.covid_19_tracker

import org.json.JSONObject

 data class Model(val completeObject :JSONObject) {
 private val deltaCasesObject : JSONObject = completeObject.getJSONObject("delta")
 private val totalCasesObject : JSONObject = completeObject.getJSONObject("total")

 private var totalConfirmed : String = totalCasesObject.getString("confirmed")
 private var totalActive : String = totalCasesObject.getString("active")
 private var totalVaccinated : String = totalCasesObject.getString("vaccinated")

 private var deltaConfirmed : String = if (deltaCasesObject.has("active")){
      deltaCasesObject.getString("confirmed")
     } else {
      ""
     }
 private var deltaActive : String = if (deltaCasesObject.has("active")){
      deltaCasesObject.getString("active")
     } else {
      ""
     }
 private var deltaVaccinated : String = if (deltaCasesObject.has("active")){
      deltaCasesObject.getString("vaccinated")
     } else {
      ""
     }


}
