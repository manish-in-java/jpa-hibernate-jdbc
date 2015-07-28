package org.example.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "category")
public class Category extends Model
{
  @Column(name = "name")
  @NotNull
  private String name;

  @JoinColumn(name = "parent_id")
  @ManyToOne
  private Category parent;

  Category()
  {
    super();
  }

  public Category(final String name)
  {
    this(null, name);
  }

  public Category(final Category parent, final String name)
  {
    this();

    this.name = name;
    this.parent = parent;
  }

  public String getName()
  {
    return name;
  }

  public Category getParent()
  {
    return parent;
  }
}
