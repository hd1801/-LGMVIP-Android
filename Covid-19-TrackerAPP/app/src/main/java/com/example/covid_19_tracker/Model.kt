package com.example.covid_19_tracker

import org.json.JSONObject

 data class Model(val completeObject :JSONObject,val stateCode : String){

private val deltaCasesObject : JSONObject? =  completeObject.optJSONObject("delta")
private val totalCasesObject : JSONObject = completeObject.getJSONObject("total")

 var totalConfirmed : String = if (totalCasesObject.has("confirmed") ){
     totalCasesObject.getString("confirmed")
 } else {
     ""
 }

 var totalRecovered : String = if (totalCasesObject.has("recovered") ){
     totalCasesObject.getString("recovered")
 } else {
     ""
 }
 var totalVaccinated : String = if (totalCasesObject.has("vaccinated1") ){
     totalCasesObject.getString("vaccinated1")
 } else {
     ""
 }

 var deltaConfirmed : String = if (deltaCasesObject!=null && deltaCasesObject.has("confirmed")){
      deltaCasesObject.getString("confirmed")
     } else {
      ""
     }
 var deltaRecovered : String = if (deltaCasesObject!=null && deltaCasesObject.has("recovered")){
      deltaCasesObject.getString("recovered")
     } else {
      ""
     }
 var deltaVaccinated : String = if (deltaCasesObject!=null && deltaCasesObject.has("vaccinated1")){
      deltaCasesObject.getString("vaccinated1")
     } else {
      ""
     }


}
