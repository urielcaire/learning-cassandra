package model;

import model.Address;
import java.util.Map;
import java.util.HashMap;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Embedded;
import javax.persistence.ElementCollection;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users", schema = "KunderaExamples@cassandra_pu")
public class User 
{
    @Id
    private String userId;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="city")
    private String city;

    @Column(name="vetor_btes")
    private byte[] b;

    //this will generate the following error in console:
    //'Super Columns not supported by cql, Any operation on supercolumn family will be executed using thrift, returning false.'
    @ElementCollection
    private Map<String, Address> addresses =  new HashMap<String, Address>();

    public User()
    {

    }

    public String getUserId()
    {
        return userId;
    }
    public void setUserId(String userId)
    {
        this.userId = userId;
    }
    public String getFirstName()
    {
        return firstName;
    }
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }
    public String getLastName()
    {
        return lastName;
    }
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }
    public String getCity()
    {
        return city;
    }
    public void setCity(String city)
    {
        this.city = city;
    }
    public byte[] getB(){
	   return b;
    }
    public void setB(byte[] b){
	   this.b = b;
    } 
    public void addAddress(Address address){
        this.addresses.put("Uma String", address);
    }
}
