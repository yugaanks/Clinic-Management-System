package edu.stevens.cs548.clinic.domain;

import java.util.Date;
import java.util.List;

public interface ITreatmentExporter<T> {
	
	public T exportDrugTreatment (long tid,
									 String diagnosis,
							   		 String drug,
							   		 float dosage);
	
	public T exportRadiology (long tid,
								 String diagnosis,
								 List<Date> dates);
	
	public T exportSurgery (long tid,
						 	   String diagnosis,
			                   Date date);

}
