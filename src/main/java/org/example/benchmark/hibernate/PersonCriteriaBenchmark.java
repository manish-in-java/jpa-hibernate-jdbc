package org.example.benchmark.hibernate;

import org.example.benchmark.SpringAwareBenchmark;
import org.example.domain.Contract;
import org.example.domain.Person;
import org.hibernate.Session;
import org.openjdk.jmh.annotations.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.concurrent.TimeUnit;

abstract class PersonCriteriaBenchmark<P extends Person<C, P>, C extends Contract<P, C>>
    extends SpringAwareBenchmark
{
  @PersistenceContext
  private EntityManager entityManager;

  @Benchmark
  @BenchmarkMode(Mode.SampleTime)
  @Fork(0)
  @Measurement(iterations = 5, timeUnit = TimeUnit.MICROSECONDS)
  @Warmup(iterations = 5)
  public void benchmark()
  {
    List<P> persons = entityManager.getEntityManagerFactory()
        .createEntityManager()
        .unwrap(Session.class)
        .createCriteria(getType()).list();

    persons.stream()
        .flatMap(p -> p.getContracts().stream())
        .map(c -> c.getNumber())
        .count();
  }

  abstract Class<P> getType();
}
