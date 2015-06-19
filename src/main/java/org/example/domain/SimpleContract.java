package org.example.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "contract")
public class SimpleContract extends Contract<SimplePerson, SimpleContract>
{
  public SimpleContract()
  {
    super();
  }
}
