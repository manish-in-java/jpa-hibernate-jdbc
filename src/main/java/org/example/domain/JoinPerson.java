package org.example.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "person")
public class JoinPerson extends Person<JoinContract, JoinPerson>
{
  public JoinPerson()
  {
    super();
  }
}
