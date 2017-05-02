/* 
 * Drug Treatment Class
 */
package edu.stevens.cs548.clinic.domain;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;



@Entity
@DiscriminatorValue("DT")
public class DrugTreatment extends Treatment implements Serializable {

	private static final long serialVersionUID = 1L;

	private String drug;
	private float dosage;

	public String getDrug() {
		return drug;
	}

	public void setDrug(String drug) {
		this.drug = drug;
	}

	public float getDosage() {
		return dosage;
	}

	public void setDosage(float dosage) {
		this.dosage = dosage;
	}
	public void visit(ITreatmentVisitor visitor){
		visitor.visitDrugTreatment( this.getId(),
									this.getDiagnosis(),
									this.drug, 
									this.dosage);
	}

	public DrugTreatment() {
		super();
		this.setTreatmentType("DT");
	}

}
