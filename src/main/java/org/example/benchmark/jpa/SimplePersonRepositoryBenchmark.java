package org.example.benchmark.jpa;

import org.example.data.SimplePersonRepository;
import org.example.domain.SimpleContract;
import org.example.domain.SimplePerson;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.springframework.beans.factory.annotation.Autowired;

@State(Scope.Benchmark)
public class SimplePersonRepositoryBenchmark extends PersonRepositoryBenchmark<SimplePerson, SimpleContract>
{
  @Autowired
  private SimplePersonRepository repository;

  SimplePersonRepository getRepository()
  {
    return repository;
  }
}
