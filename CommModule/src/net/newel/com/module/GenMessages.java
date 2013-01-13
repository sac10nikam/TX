package net.newel.com.module;

import java.io.IOException;
import java.util.UUID;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.DataTypeException;
import ca.uhn.hl7v2.model.Varies;
import ca.uhn.hl7v2.model.v26.datatype.TX;
import ca.uhn.hl7v2.model.v26.datatype.ST;
import ca.uhn.hl7v2.model.v26.group.ORU_R01_ORDER_OBSERVATION;
import ca.uhn.hl7v2.model.v26.segment.OBR;
import ca.uhn.hl7v2.model.v26.segment.OBX;
import ca.uhn.hl7v2.model.v26.message.ORU_R01;

public class GenMessages {
	/*
	 * Utilisation du type ORU_R01, car c'est le type de message le plus 
	 * addapté pour la remontée de mesures vers le serveur. L'idéale 
	 * serais d'utiliser le type ADT_A28, mais n'est pas encore implanté
	 * dans la version v26 de HAPI
	 */
	private ORU_R01 message = new ORU_R01();
	private ORU_R01_ORDER_OBSERVATION orderObservation;
	private static Integer obsCounter = 0;
	private static Integer txCounter = 0;
	private final UUID id = UUID.randomUUID();

	public GenMessages() throws HL7Exception, IOException {
		this.message.initQuickstart("ORU", "R01", random().toString());
		
		// Observation Request
		this.orderObservation = this.message.getPATIENT_RESULT().getORDER_OBSERVATION();
		OBR obr = orderObservation.getOBR();
		obr.getSetIDOBR().setValue(random(1).toString());
		obr.getFillerOrderNumber().getEntityIdentifier().setValue(id.toString());
		obr.getFillerOrderNumber().getNamespaceID().setValue("MEASUR");
		obr.getUniversalServiceIdentifier().getIdentifier().setValue("E-Care");
	}
	
	private Integer random(int min, int max) {
		Integer random = (int)(Math.random() * (max-min)) + min;
		return random;
	}
	private Integer random (int min) {
		return random(min, 9999);
	}
	private Integer random() {
		return random(0);
	}
	
	public void addMeasur(String addr, Integer[] values) throws DataTypeException {
		/* TODO crée une classe generique "mesure" et passer un tableau de mesure */
		obsCounter++;
		Integer i = 1;
		OBX obx;
		for (Integer measur : values) {
			obx = orderObservation.getOBSERVATION(txCounter).getOBX();
			obx.getSetIDOBX().setValue(obsCounter.toString());
			obx.getObservationSubID().setValue("Pressure"+i);
			Varies value = obx.getObservationValue(0);

			ST observationIdentifier = obx.getObservationIdentifier().getIdentifier();
			observationIdentifier.setValue(addr);
			/*ST extraSubcomponent = new ST(message);
			extraSubcomponent.setValue("MDT");
			observationIdentifier.getExtraComponents().getComponent(0).setData(extraSubcomponent);*/
			obx.getValueType().setValue("TX");	
			TX tx = new TX(message);
			tx.setValue(measur.toString());
			value = obx.getObservationValue(0);
			value.setData(tx);
			i++;
			txCounter++;
		}
	}

	
	public ORU_R01 getMessage() {
		return message;
	}

	public void setMessage(ORU_R01 message) {
		this.message = message;
	}

	public UUID getId() {
		return id;
	}
	
	
}
