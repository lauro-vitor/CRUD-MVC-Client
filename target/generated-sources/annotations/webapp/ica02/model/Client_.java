package webapp.ica02.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import webapp.ica02.model.Address;
import webapp.ica02.model.Contact;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-06-21T20:42:36")
@StaticMetamodel(Client.class)
public class Client_ { 

    public static volatile SingularAttribute<Client, String> firstName;
    public static volatile SingularAttribute<Client, String> lastName;
    public static volatile SingularAttribute<Client, Address> address;
    public static volatile SingularAttribute<Client, Contact> contact;
    public static volatile SingularAttribute<Client, String> cpf;
    public static volatile SingularAttribute<Client, Integer> id;

}