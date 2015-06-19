package org.example.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@MappedSuperclass
public class Contract<P extends Person<C, P>, C extends Contract<P, C>> extends Model
{
  @Column(name = "number")
  @NotNull
  @Size(max = 64)
  private String number;

  @JoinColumn(name = "person_id", updatable = false)
  @ManyToOne(fetch = FetchType.LAZY)
  @NotNull
  private P person;

  public Contract()
  {
    super();
  }

  public String getNumber()
  {
    return number;
  }

  public P getPerson()
  {
    return person;
  }

  public void setNumber(String number)
  {
    this.number = number;
  }

  public void setPerson(P person)
  {
    this.person = person;
  }
}
