package org.example.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "contract")
public class JoinContract extends Contract<JoinPerson, JoinContract>
{
  public JoinContract()
  {
    super();
  }
}
