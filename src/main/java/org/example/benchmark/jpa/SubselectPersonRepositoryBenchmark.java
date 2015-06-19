package org.example.benchmark.jpa;

import org.example.data.SubselectPersonRepository;
import org.example.domain.SubselectContract;
import org.example.domain.SubselectPerson;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.springframework.beans.factory.annotation.Autowired;

@State(Scope.Benchmark)
public class SubselectPersonRepositoryBenchmark extends PersonRepositoryBenchmark<SubselectPerson, SubselectContract>
{
  @Autowired
  private SubselectPersonRepository repository;

  SubselectPersonRepository getRepository()
  {
    return repository;
  }
}
