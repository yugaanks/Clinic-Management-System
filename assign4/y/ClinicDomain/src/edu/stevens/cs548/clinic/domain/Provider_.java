package edu.stevens.cs548.clinic.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-09-29T18:35:12.258-0400")
@StaticMetamodel(Provider.class)
public class Provider_ {
	public static volatile SingularAttribute<Provider, Long> id;
	public static volatile SingularAttribute<Provider, String> name;
	public static volatile SingularAttribute<Provider, Long> ProviderId;
	public static volatile ListAttribute<Provider, Treatment> treatments;
	public static volatile SingularAttribute<Provider, String> specialization;
}
