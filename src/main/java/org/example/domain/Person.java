package org.example.domain;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@MappedSuperclass
public class Person<C extends Contract<P, C>, P extends Person<C, P>> extends Model
{
  @Fetch(FetchMode.JOIN)
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "person")
  List<C> contracts;

  @Column(name = "first_name")
  @NotNull
  @Size(max = 50)
  private String firstName;

  @Column(name = "last_name")
  @NotNull
  @Size(max = 50)
  private String lastName;

  public Person()
  {
    super();
  }

  public void addContract(C contract)
  {
    contract.setPerson((P) this);

    if (contracts == null)
    {
      contracts = new ArrayList<>(3);
    }

    contracts.add(contract);
  }

  public List<C> getContracts()
  {
    return contracts;
  }

  public String getFirstName()
  {
    return firstName;
  }

  public String getLastName()
  {
    return lastName;
  }

  public void setFirstName(String firstName)
  {
    this.firstName = firstName;
  }

  public void setLastName(String lastName)
  {
    this.lastName = lastName;
  }
}
