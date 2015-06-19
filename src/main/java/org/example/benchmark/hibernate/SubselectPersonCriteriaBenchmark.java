package org.example.benchmark.hibernate;

import org.example.domain.SubselectContract;
import org.example.domain.SubselectPerson;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

@State(Scope.Benchmark)
public class SubselectPersonCriteriaBenchmark
    extends PersonCriteriaBenchmark<SubselectPerson, SubselectContract>
{
  Class<SubselectPerson> getType()
  {
    return SubselectPerson.class;
  }
}
