package org.example.benchmark.jdbc;

import org.example.benchmark.SpringAwareBenchmark;
import org.example.domain.SimpleContract;
import org.example.domain.SimplePerson;
import org.openjdk.jmh.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@State(Scope.Benchmark)
public class SimplePersonQueryBenchmark extends SpringAwareBenchmark
{
  private static final String QUERY = "SELECT p.id, p.first_name, p.last_name, c.number FROM contract c, person p WHERE p.id=c.person_id";

  @Autowired
  private DataSource dataSource;

  @Benchmark
  @BenchmarkMode(Mode.SampleTime)
  @Fork(0)
  @Measurement(iterations = 5, timeUnit = TimeUnit.MICROSECONDS)
  @Warmup(iterations = 5)
  public void benchmark() throws Exception
  {
    final Map<Long, SimplePerson> lookup = new HashMap<>();
    final List<SimplePerson> persons = new ArrayList<>(100000);

    try (final Connection connection = dataSource.getConnection();
        final ResultSet resultSet = connection.prepareStatement(QUERY).executeQuery())
    {
      while (resultSet.next())
      {
        SimplePerson person;
        if (lookup.containsKey(resultSet.getLong(1)))
        {
          person = lookup.get(resultSet.getLong(1));
        }
        else
        {
          person = new SimplePerson();
          person.setFirstName(resultSet.getString(2));
          person.setLastName(resultSet.getString(3));
        }

        final SimpleContract contract = new SimpleContract();
        contract.setNumber(resultSet.getString(4));
        person.addContract(contract);

        persons.stream()
            .flatMap(p -> p.getContracts().stream())
            .map(c -> c.getNumber())
            .count();
      }
    }
  }
}
