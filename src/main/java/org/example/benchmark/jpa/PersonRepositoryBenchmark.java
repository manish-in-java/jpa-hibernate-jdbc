package org.example.benchmark.jpa;

import org.example.benchmark.SpringAwareBenchmark;
import org.example.data.PersonRepository;
import org.example.domain.Contract;
import org.example.domain.Person;
import org.openjdk.jmh.annotations.*;

abstract class PersonRepositoryBenchmark<P extends Person<C, P>, C extends Contract<P, C>> extends SpringAwareBenchmark
{
  @Benchmark
  @BenchmarkMode(Mode.SampleTime)
  @Fork(0)
  @Measurement(iterations = 5)
  @Warmup(iterations = 5)
  public void benchmark()
  {
    getRepository().findAll().stream()
        .flatMap(p -> p.getContracts().stream())
        .map(c -> c.getNumber())
        .count();
  }

  abstract PersonRepository<P> getRepository();
}
