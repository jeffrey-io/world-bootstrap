package io.jeffrey.world.document;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Pattern;

import io.jeffrey.world.things.core.Thing;
import io.jeffrey.zer.edits.Edit;

/**
 * defines the basics of the query language
 *
 * @author jeffrey
 */
public class Query {

  /**
   * defines the various forms of queries
   *
   * @author jeffrey
   */
  public static enum QueryType {
    All(false), //
    ByClass(false), //
    ById(true), //
    FieldFilter(true);

    public final boolean singletonPossible;

    /**
     * @param singletonPossible
     *          is this query expected to return a singleton at some point
     */
    private QueryType(final boolean singletonPossible) {
      this.singletonPossible = singletonPossible;
    }
  }

  private static final String COLON = Pattern.quote(":");

  private static final String COMMA = Pattern.quote(",");

  /**
   * parse the query
   *
   * @param query
   *          the raw query to parse
   * @return a list of queries to apply
   */
  public static List<Query> parse(final String query) {
    final ArrayList<Query> parts = new ArrayList<>();
    for (String queryPart : query.split(COLON)) {
      queryPart = queryPart.trim();
      if (queryPart.startsWith("#")) {
        parts.add(new Query(QueryType.ById, queryPart.substring(1).split(COMMA)));
      } else if (queryPart.startsWith(".")) {
        parts.add(new Query(QueryType.ByClass, queryPart.substring(1).split(COMMA)));
      } else if (queryPart.equals("*")) {
        parts.add(new Query(QueryType.All, ""));
      } else {
        parts.add(new Query(QueryType.FieldFilter, queryPart.split(COMMA)));
      }
    }
    return parts;
  }

  /**
   * the various arguments to the query
   */
  public final String[]  args;

  /**
   * is this query a singleton (i.e. produce exactly one element)
   */
  public final boolean   singleton;

  /**
   * the type of the query
   */
  public final QueryType typ;

  private Query(final QueryType typ, final String... args) {
    this.typ = typ;
    this.args = args;
    singleton = args.length == 1 && typ.singletonPossible;
  }

  /**
   * apply the query as a filter on a collection of things
   */
  public Collection<Thing> applyAsFilter(final Collection<Thing> old) {
    final HashSet<Thing> result = new HashSet<>();

    switch (typ) {
      case All:
        // NO-OP
        break;
      case ByClass:
        for (final Thing thing : old) {
          boolean found = false;
          final String currentClass = thing.getMetaclass();
          for (final String wantedClass : args) {
            if (currentClass.equals(wantedClass)) {
              found = true;
            }
          }
          if (found) {
            result.add(thing);
          }
        }
        break;
      case ById:
        for (final Thing thing : old) {
          boolean found = false;
          final String currentId = thing.id();
          for (final String wantedId : args) {
            if (currentId.equals(wantedId)) {
              found = true;
            }
          }
          if (found) {
            result.add(thing);
          }
        }
        break;
      case FieldFilter:
        // NO-OP
        break;
    }
    return result;
  }

  /**
   * Reduce the given state by applying the query as a filter
   *
   * @param oactionOpenld
   *          the old state
   * @return the new state that has been reduced to elements that apply
   */
  public Map<String, Map<String, Edit>> applyAsFilter(final Map<String, Map<String, Edit>> old) {
    final HashMap<String, Map<String, Edit>> result = new HashMap<String, Map<String, Edit>>();

    switch (typ) {
      case All:
        // NO-OP
        break;
      case ByClass:
        for (final Entry<String, Map<String, Edit>> entry : old.entrySet()) {
          final Edit mc = entry.getValue().get("metaclass");
          boolean found = false;
          if (mc != null) {
            final String currentClass = mc.getAsText();
            for (final String wantedClass : args) {
              if (currentClass.equals(wantedClass)) {
                found = true;
              }
            }
          }
          if (found) {
            result.put(entry.getKey(), entry.getValue());
          }
        }
        break;
      case ById:
        for (final String id : args) {
          final Map<String, Edit> existing = old.get(id);
          if (existing != null) {
            result.put(id, existing);
          }
        }
        break;
      case FieldFilter:
        for (final Entry<String, Map<String, Edit>> entry : old.entrySet()) {
          final Map<String, Edit> next = new HashMap<String, Edit>();
          for (final String nk : args) {
            final Edit prev = entry.getValue().get(nk);
            if (prev != null) {
              next.put(nk, prev);
            }
          }
          result.put(entry.getKey(), next);
        }
        break;
    }
    return result;
  }
}
