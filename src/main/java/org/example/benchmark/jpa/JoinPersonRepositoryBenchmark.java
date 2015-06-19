package org.example.benchmark.jpa;

import org.example.data.JoinPersonRepository;
import org.example.domain.JoinContract;
import org.example.domain.JoinPerson;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.springframework.beans.factory.annotation.Autowired;

@State(Scope.Benchmark)
public class JoinPersonRepositoryBenchmark extends PersonRepositoryBenchmark<JoinPerson, JoinContract>
{
  @Autowired
  private JoinPersonRepository repository;

  JoinPersonRepository getRepository()
  {
    return repository;
  }
}
