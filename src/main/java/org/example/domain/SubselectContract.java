package org.example.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "contract")
public class SubselectContract extends Contract<SubselectPerson, SubselectContract>
{
  public SubselectContract()
  {
    super();
  }
}
