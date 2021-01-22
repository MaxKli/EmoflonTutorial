package HospitalTransformRules;

import org.emoflon.ibex.common.operational.PushoutApproach;
import org.moflon.core.utilities.eMoflonEMFUtil;

import HospitalExample.Carelevel;
import HospitalExample.Hospital;
import HospitalTransformRules.api.HospitalTransformRulesAPI;

public class HospitalRules {
 private HospitalTransformRulesAPI api;
 
 public HospitalRules(){
 api = new HospitalValidator().initAPI(); 
}
 
 public static void main(String[]args) {
	 HospitalRules hospitalrules = new HospitalRules();
	 
	 hospitalrules.createHospital();
	 hospitalrules.validateHospital();
	 
 }

 public void createHospital() {
	 
	 api.hospital().apply();
	 api.reception().apply();
	 api.nurse(0).apply();
	 api.nurse(2).apply();
	 api.nurse(3).apply();
	 api.doctor(1).apply();
	 api.patient().apply();
	 api.patient().apply();
	 api.patient().apply();
	 api.patient().apply();
	 api.patient().apply();
	 api.assignPatienttoRoom().apply();
	 api.assignNursetoRoom().apply();
	 //api.department(0).apply();
	 
	
	 
	 
	 
	 
	 
	 
 }
 
 public  void validateHospital() {
	 
	 PushoutApproach rulepushout = api.getDefaultPushoutApproach();
	 System.out.println(rulepushout);
	 
	 boolean checkhospitalrule = api.hospital().isApplicable();
	 System.out.println(checkhospitalrule);
	 
	 boolean checkreception = api.reception().isApplicable();
	 System.out.println(checkreception);
	 
	 long counthospital = api.findPatient().countMatches();
	 System.out.println("Aktuell sind "+ counthospital+ " Patienten im Krankenhaus");
	 
	 long countpatientsinroom = api.findPatientinRoom().countMatches();
	 System.out.println("Aktuell sind "+ countpatientsinroom+ " Patienten in einem Raum");
	 
	 int counthospitalruleapplications = api.patient().countRuleApplications();
	 System.out.println(counthospitalruleapplications);
	 
	 
	 if (api.findHospital().countMatches() == 1) {
		 System.out.println( "Es existiert genau ein Hospital");
	 }
	 else System.out.println( "Error, the hospital was not created");
	 
	 if(api.findReception().countMatches() == 1) {
		 System.out.println( "Es existiert genau eine Rezeption");
	 }
	 else System.out.println( "Error, the reception was not created");
	 
	 if(api.findDepartment().countMatches() > 0) {
		 System.out.println( "Es existiert genau ein Department");
	 }
	 else System.out.println( "Error, there are no departments in the hospital");
	 
	 if(api.findNurse().countMatches() > 0) {
		 long nursecount = api.findNurse().countMatches();
		 long busyNurse = api.findNurseinRoom().countMatches();
		 System.out.println( "Es sind "+ nursecount +" Nurses im Krankenhaus und aktuell sind "+ busyNurse +" Nurses beschäftigt");
	 }
	 else System.out.println( "Error, there are no nurses in the hospital");
	 
	 if(api.findDoctor().countMatches() > 0) {
		 System.out.println( "Es existiert mindestens ein Doktor");
	 }
	 else System.out.println( "Error, there are no doctors in the hospital");
	 
	 if(api.findPatient().countMatches() > 0) {
		 System.out.println( "Es existiert mindestens ein Patient");
	 }
	 else System.out.println( "Error, there are no patients in the hospital");
	 
	 if(api.findRoom().countMatches() > 0) {
		 System.out.println( "Es existiert genau ein Raum");
	 }
	 else System.out.println( "Error, there are no rooms in the hospital\"");
	 
	

}
 

}
	