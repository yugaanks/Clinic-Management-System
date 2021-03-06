/*
 *  Patient Main Class
 */
package edu.stevens.cs548.clinic.domain;

import static javax.persistence.CascadeType.REMOVE;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import edu.stevens.cs548.clinic.domain.ITreatmentDAO.TreatmentExn;

/**
 * Entity implementation class for Entity: Patient
 *
 */
/*
 * TODO
 */
@NamedQueries({
	@NamedQuery(
		name="SearchPatientByPatientID",
		query="select p from Patient p where p.patientId = :pid"),
	@NamedQuery(
		name="CountPatientByPatientID",
		query="select count(p) from Patient p where p.patientId = :pid"),
	@NamedQuery(
		name = "RemoveAllPatients", 
		query = "delete from Patient p"),
	@NamedQuery(
		name = "SearchPatientByNameDob",
		query = "select p from Patient p where p.name= :name and p.birthDate= :dob")
})

@Entity
@Table(name="PATIENT")
public class Patient implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private long id;
	
	private long patientId;
	
	private String name;
	
	
	@Temporal(TemporalType.DATE)
	private Date birthDate;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getPatientId() {
		return patientId;
	}

	public void setPatientId(long patientId) {
		this.patientId = patientId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	@OneToMany(mappedBy = "patient", cascade = REMOVE)
	@OrderBy
	private List<Treatment> treatments;

	protected List<Treatment> getTreatments() {
		return treatments;
	}

	protected void setTreatments(List<Treatment> treatments) {
		this.treatments = treatments;
	}
	@Transient
	private ITreatmentDAO treatmentDAO;
	public void setTreatmentDAO(ITreatmentDAO tdao){
		this.treatmentDAO=tdao;
	}
	/*
	 * Addition and deletion of treatments should be done in the provider aggregate.
	  public void addTreatment (Treatment t)
	  {
		  this.treatmentDAO.addTreatment(t);
	  		this.getTreatments().add(t);
	  		if(t.getPatient()!=this)
	  		 t.setPatient(this);
	  }
	 public void addDrugTreatment (String diagnosis,String drug, float dosage){
 		 
	
		 DrugTreatment treatment =new DrugTreatment();
		 treatment.setDiagnosis(diagnosis);
		 treatment.setDrug(drug);
		 treatment.setDosage(dosage);
		 this.addTreatment(treatment);
	 }

	 public List<Long> getTreatmentIds(){
		 List<Long> tids=new ArrayList<Long>();
		 for(Treatment t:this.getTreatments()){
			 tids.add(t.getId());
		 }
		 return tids;
	 }
	public void deleteTreatment(long tid) throws TreatmentExn{
		Treatment t=treatmentDAO.getTreatmentById(tid);
		 if(t.getPatient()==this){
			 throw new TreatmentExn("Inappropriate treatment access: patient = "+id+",treatment = "+tid);
		 }
		 treatmentDAO.deleteTreatments(t);
	}
	
	*/
	 public void visitTreatment(long tid, ITreatmentVisitor visitor	) throws TreatmentExn{
		
			 Treatment t=treatmentDAO.getTreatmentById(tid);
			 if(t.getPatient()==this){
				 throw new TreatmentExn("Inappropriate treatment access: patient = "+id+",treatment = "+tid);
			 }
			 t.visit(visitor);
		}
	 
	public Patient() {
		super();
		treatments=new ArrayList<Treatment>();
	}
   
}
