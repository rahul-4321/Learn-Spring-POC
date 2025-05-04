# Hibernate
- a popular Java ORM (Object-Relational Mapping) framework. Hibernate is used to interact with relational databases using Java objects. Instead of writing SQL queries manually, Hibernate lets you perform database operations using Java classes and objects.

# Key Features of Hibernate:
- ORM (Object-Relational Mapping) – Maps Java classes to database tables.
- HQL (Hibernate Query Language) – A more object-oriented query language than SQL.
- Automatic Table Creation – Can generate tables from Java entities.
- Caching – Improves performance by reducing database calls.
- Lazy and Eager Loading – Controls how data is fetched from the database.
- Transaction Management – Works well with frameworks like Spring for handling transactions.

Why Use Hibernate?
- Reduces boilerplate SQL code (avoids writing raw SQL).
- Portable across different databases (supports MySQL, PostgreSQL, Oracle, etc.).
- Handles complex relationships between entities (One-to-Many, Many-to-Many).
- Supports JPA (Java Persistence API) for better integration with Java EE applications.


# Embeddable

- In Hibernate, @Embeddable and @Embedded are used to define and reuse value-type objects inside an entity. They help you group
    multiple fields into a single reusable class without creating a separate entity table.

- Why Use @Embeddable?
    - Avoids creating a separate table for related fields.
    - Encourages code reusability (use the same structure in multiple entities).
    - Simplifies data modeling when a group of fields is always used together.

Example Usage:
Let's say you have a User entity with an Address field that consists of street, city, and zipcode. Instead of adding these fields directly, you can use an embeddable class.

    1. Create an Embeddable Class

    import jakarta.persistence.Embeddable;

    @Embeddable
    public class Address {
        private String street;
        private String city;
        private String zipcode;

        // Getters and Setters
    }

    2. Use @Embedded in an Entity

    import jakarta.persistence.*;

    @Entity
    @Table(name = "users")
    public class User {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        private String name;

        @Embedded
        private Address address;  // Using embeddable object

        // Getters and Setters
    }

- How It Works in the Database
Hibernate will embed the Address fields into the users table instead of creating a separate table.

        id	name	street	city	zipcode
        1	John	Main St	NYC	10001
This avoids unnecessary table joins while maintaining a structured design.


# However, one person can have many addresses so @Embeddables will lead to creation of many columns
 - To overcome this issue, we will use the concept of mapping, in DBMS concept- we will make use of foreign key linkage to a separate table 



# Mapping in Hibernate 
- refers to how Java classes and their fields are linked (mapped) to database tables and columns. It’s the heart of what makes Hibernate an ORM (Object-Relational Mapping) tool.

🧩 Types of Mapping in Hibernate:

1. Basic Mapping
Maps simple fields (like int, String, boolean) to table columns using annotations like:


@Entity
@Table(name = "alien_table")
public class Alien {
    @Id
    @Column(name = "alien_id")
    private int id;

    private String name; // mapped to "name" column
    private String domain; // mapped to "domain" column
}

2. One-to-One Mapping
Each entity has exactly one related entity.

@OneToOne
private Passport passport;
You use this when, say, one person has one passport.

3. One-to-Many Mapping
One entity is related to many others.

@OneToMany(mappedBy = "alien")
private List<Laptop> laptops;
In your case: One Alien has many Laptops.

4. Many-to-One Mapping
Many entities are associated with one.

@ManyToOne
private Alien alien;
In your case: Many Laptops belong to one Alien.

5. Many-to-Many Mapping
Entities on both sides can relate to multiple others.

@ManyToMany
private List<Student> students;
Example: Many students can enroll in many courses.

🔧 Mapping Annotations Summary:
Annotation	                Purpose
@Entity	                    Marks a class as an entity
@Table	                    Maps class to a specific table
@Id	Marks                   primary key field
@Column	                    Maps field to column (optional if name matches)
@OneToOne	                One-to-one relationship
@OneToMany	                One-to-many relationship
@ManyToOne	                Many-to-one relationship
@ManyToMany	                Many-to-many relationship
@JoinColumn	                Custom foreign key column name
@JoinTable	                For many-to-many join tables
@Embeddable / @Embedded	    For embedding value types

#  Eager and Lazy fetching in Hibernate control when related data is loaded from the database. It’s all about performance and how much data gets pulled when you load an entity.

🔁 Quick Comparison:
Fetch Type	        When Related Data is Loaded	                        Use Case
Lazy (default)	    Only when the related data is accessed (on demand)	Better for performance, avoids overfetching
Eager	            Immediately when the parent entity is loaded	    Good when you always need the related data

🧠 Think of it Like:
Imagine you open a YouTube channel page.

Lazy Fetching: You only load the video descriptions when you click on each video.
Eager Fetching: Everything loads immediately — all thumbnails, descriptions, comments, etc. — whether you view them or not.

🔍 Code Example

@OneToMany(mappedBy = "alien", fetch = FetchType.LAZY)
private List<Laptop> laptops;
This means: Hibernate will not load laptops until you actually call alien.getLaptops().

@OneToMany(mappedBy = "alien", fetch = FetchType.EAGER)
private List<Laptop> laptops;
This means: Hibernate loads laptops immediately when you fetch the Alien entity.

⚠️ Caution:
Lazy fetching is more efficient, but if you're outside a session (like after session.close()), it throws a LazyInitializationException if you try to access the data.

Eager fetching avoids that, but might load a lot of unnecessary data, slowing things down.

✅ Rule of Thumb:
Use LAZY by default for collections.

Use EAGER if the related data is always required and small in size.

# 🚀 What Is Caching in Hibernate?
Caching means storing frequently accessed data in memory so that Hibernate doesn't need to repeatedly hit the database for the same data.

This reduces:

Database round-trips 🐢

Load on the DB

Query execution time ⚡

🔄 Types of Caching in Hibernate
🧠 1. First-Level Cache (Session Cache)
Built-in, always enabled.

Works within a single Hibernate Session.

If you fetch the same object twice in one session, Hibernate will use the cache for the second time.

Session session = sessionFactory.openSession();
Alien alien1 = session.get(Alien.class, 1); // hits DB
Alien alien2 = session.get(Alien.class, 1); // comes from cache
💡 Hibernate won't go to the DB again for the same id in the same session.

🌍 2. Second-Level Cache
Optional, must be configured.

Works across multiple sessions.

Caches objects at the SessionFactory level.

🧰 You need to integrate a cache provider like:

Ehcache

Infinispan

Caffeine

To use it:

@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
@Entity
public class Alien {
    // fields
}
In hibernate.cfg.xml:

<property name="hibernate.cache.use_second_level_cache">true</property>
<property name="hibernate.cache.region.factory_class">org.hibernate.cache.ehcache.EhCacheRegionFactory</property>

📊 3. Query Cache (Optional)
Caches results of HQL or Criteria queries.

Needs second-level cache enabled.

Query query = session.createQuery("from Alien");
query.setCacheable(true);
📌 Summary Table:
Cache Level	    Scope	        Default	    Needs Config	Caches
1st Level	    Per Session	    ✅ Yes	    ❌ No	    Entities by ID
2nd Level	    App-wide	    ❌ No	    ✅ Yes	    Entities, collections
Query Cache	    App-wide	    ❌ No	    ✅ Yes	    Query results

⚠️ Things to Keep in Mind
Invalidation: If data is updated elsewhere (e.g., in DB directly), stale data can appear in cache.

Consistency: Use proper cache strategies (READ_ONLY, NONSTRICT_READ_WRITE, etc.).

Size: Don’t cache everything blindly — memory usage matters.