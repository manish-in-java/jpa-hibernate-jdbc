package org.example.hibernate;

import org.example.domain.Category;
import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

@ContextConfiguration(locations = "classpath:springContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class CategoryTest
{
  @PersistenceContext
  private EntityManager entityManager;

  private Collection<Category> categories = new LinkedList<>();

  @Before
  public void setup()
  {
    final Category events = new Category("Events");
    final Category deals = new Category("Deals");
    final Category movies = new Category("Movies");
    final Category restaurants = new Category("Restaurants");
    final Category outdoor = new Category("outdoor");

    categories.add(events);
    categories.add(deals);
    categories.add(movies);
    categories.add(restaurants);
    categories.add(outdoor);

    categories.add(new Category(events, "Infotech"));
    categories.add(new Category(events, "Socia"));
    categories.add(new Category(events, "Health"));
    categories.add(new Category(events, "Shopping"));
    categories.add(new Category(events, "Music Night"));

    categories.add(new Category(deals, "Infotech"));
    categories.add(new Category(deals, "Fashion4u"));
    categories.add(new Category(deals, "Buy1Get2"));

    categories.add(new Category(movies, "New Release"));
    categories.add(new Category(movies, "Adventure"));
    categories.add(new Category(movies, "Horror"));
    categories.add(new Category(movies, "Kids"));

    categories.add(new Category(restaurants, "Chinese"));
    categories.add(new Category(restaurants, "Thai dishes"));
    categories.add(new Category(restaurants, "Indian Cuisine"));

    categories.add(new Category(outdoor, "Adventure Sports"));
    categories.add(new Category(outdoor, "Trekking"));
    categories.add(new Category(outdoor, "Skiing"));

    categories.forEach(category -> entityManager.persist(category));
    entityManager.flush();
  }

  @Test
  public void testFindSubCategories()
  {
    final List<Category> subCategories = entityManager
        .unwrap(Session.class)
        .createQuery("from Category where parent is not null order by parent.name, name")
        .list();

    assertNotNull(subCategories);
    assertEquals(categories.stream().filter(category -> category.getParent() != null).count(), subCategories.size());
    subCategories.forEach(subCategory -> {
      assertNotNull(subCategory);
      assertNotNull(subCategory.getName());
      assertNotNull(subCategory.getParent());
    });
  }
}
