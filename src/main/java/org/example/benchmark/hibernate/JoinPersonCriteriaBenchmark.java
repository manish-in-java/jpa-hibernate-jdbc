package org.example.benchmark.hibernate;

import org.example.domain.JoinContract;
import org.example.domain.JoinPerson;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

@State(Scope.Benchmark)
public class JoinPersonCriteriaBenchmark extends PersonCriteriaBenchmark<JoinPerson, JoinContract>
{
  Class<JoinPerson> getType()
  {
    return JoinPerson.class;
  }
}
