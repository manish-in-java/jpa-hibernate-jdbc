package org.example.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "person")
public class SubselectPerson extends Person<SubselectContract, SubselectPerson>
{
  public SubselectPerson()
  {
    super();
  }
}
