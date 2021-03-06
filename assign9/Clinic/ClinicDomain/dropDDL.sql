ALTER TABLE TREATMENT DROP CONSTRAINT FK_TREATMENT_provider_fk
ALTER TABLE TREATMENT DROP CONSTRAINT FK_TREATMENT_patient_fk
ALTER TABLE DrugTreatment DROP CONSTRAINT FK_DrugTreatment_ID
ALTER TABLE Radiology DROP CONSTRAINT FK_Radiology_ID
ALTER TABLE Surgery DROP CONSTRAINT FK_Surgery_ID
ALTER TABLE DrugTreatmentRecord DROP CONSTRAINT FK_DrugTreatmentRecord_SUBJECT_ID
ALTER TABLE DrugTreatmentRecord_DrugTreatment DROP CONSTRAINT FK_DrugTreatmentRecord_DrugTreatment_treatments_ID
ALTER TABLE DrugTreatmentRecord_DrugTreatment DROP CONSTRAINT FK_DrugTreatmentRecord_DrugTreatment_DrugTreatmentRecord_ID
DROP TABLE PATIENT CASCADE
DROP TABLE TREATMENT CASCADE
DROP TABLE DrugTreatment CASCADE
DROP TABLE PROVIDER CASCADE
DROP TABLE Radiology CASCADE
DROP TABLE Surgery CASCADE
DROP TABLE BillingRecord CASCADE
DROP TABLE DrugTreatmentRecord CASCADE
DROP TABLE SUBJECT CASCADE
DROP TABLE DrugTreatmentRecord_DrugTreatment CASCADE
DELETE FROM SEQUENCE WHERE SEQ_NAME = 'SEQ_GEN'
