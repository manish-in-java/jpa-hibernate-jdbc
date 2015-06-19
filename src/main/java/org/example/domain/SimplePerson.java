package org.example.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "person")
public class SimplePerson extends Person<SimpleContract, SimplePerson>
{
  public SimplePerson()
  {
    super();
  }
}
