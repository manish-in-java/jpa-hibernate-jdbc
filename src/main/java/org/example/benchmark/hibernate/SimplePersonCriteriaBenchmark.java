package org.example.benchmark.hibernate;

import org.example.domain.SimpleContract;
import org.example.domain.SimplePerson;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

@State(Scope.Benchmark)
public class SimplePersonCriteriaBenchmark extends PersonCriteriaBenchmark<SimplePerson, SimpleContract>
{
  Class<SimplePerson> getType()
  {
    return SimplePerson.class;
  }
}
