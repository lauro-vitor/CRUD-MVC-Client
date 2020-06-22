package webapp.ica02.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import webapp.ica02.model.State;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-06-21T20:42:36")
@StaticMetamodel(Address.class)
public class Address_ { 

    public static volatile SingularAttribute<Address, String> city;
    public static volatile SingularAttribute<Address, String> postalCode;
    public static volatile SingularAttribute<Address, Integer> id;
    public static volatile SingularAttribute<Address, State> state;
    public static volatile SingularAttribute<Address, String> addessName;

}