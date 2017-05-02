package edu.stevens.cs548.clinic.service.web.soap;

import javax.jms.JMSException;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import edu.stevens.cs548.clinic.service.dto.provider.ProviderDto;
import edu.stevens.cs548.clinic.service.dto.treatment.TreatmentDto;
import edu.stevens.cs548.clinic.service.ejb.IPatientService.PatientNotFoundExn;
import edu.stevens.cs548.clinic.service.ejb.IPatientService.TreatmentNotFoundExn;
import edu.stevens.cs548.clinic.service.ejb.IProviderService.ProviderServiceExn;

@WebService(name = "IProviderWebPort", targetNamespace = "http://cs548.stevens.edu/clinic/service/web/soap")

@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, use = SOAPBinding.Use.LITERAL, parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
public interface IProviderWebService {

	@WebMethod
	public long addProvider(
			@WebParam(name = "provider-dto", targetNamespace = "http://cs548.stevens.edu/clinic/dto") ProviderDto prov)
			throws ProviderServiceExn;

	@WebMethod
	@WebResult(name = "provider-dto", targetNamespace = "http://cs548.stevens.edu/clinic/dto")
	public ProviderDto getProvider(long id) throws ProviderServiceExn;

	@WebMethod
	@WebResult(name = "provider-dto", targetNamespace = "http://cs548.stevens.edu/clinic/dto")
	public ProviderDto getProviderByNPI(long npi) throws ProviderServiceExn;

	@WebMethod
	@WebResult(name = "provider-dto", targetNamespace = "http://cs548.stevens.edu/clinic/dto")
	public long addTreatmentForPat(TreatmentDto treatment, long pid, long npi)
			throws TreatmentNotFoundExn, PatientNotFoundExn, ProviderServiceExn, JMSException;

	@WebMethod
	@WebResult(name = "treatment-dto", targetNamespace = "http://cs548.stevens.edu/clinic/dto")
	public TreatmentDto getTreatment(long id, long tid) throws TreatmentNotFoundExn, ProviderServiceExn;

	@WebMethod
	public String siteInfo();
}
