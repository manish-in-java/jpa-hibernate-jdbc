package org.example.data;

import org.example.domain.Person;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface PersonRepository<T extends Person> extends ModelRepository<T>
{
}
