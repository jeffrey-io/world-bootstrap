package io.jeffrey.world.document;

import io.jeffrey.zer.edits.Edit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Pattern;

/**
 * defines the basics of the query language
 * 
 * @author jeffrey
 */
public class Query {

    private static final String COLON = Pattern.quote(":");
    private static final String COMMA = Pattern.quote(",");

    /**
     * defines the various forms of queries
     * 
     * @author jeffrey
     */
    public static enum QueryType {
        ById(true), //
        ByClass(false), //
        FieldFilter(true), //
        All(false);

        public final boolean singletonPossible;

        /**
         * @param singletonPossible
         *            is this query expected to return a singleton at some point
         */
        private QueryType(boolean singletonPossible) {
            this.singletonPossible = singletonPossible;
        }
    }

    /**
     * the type of the query
     */
    public final QueryType typ;

    /**
     * the various arguments to the query
     */
    public final String[]  args;

    /**
     * is this query a singleton (i.e. produce exactly one element)
     */
    public final boolean   singleton;

    private Query(final QueryType typ, String... args) {
        this.typ = typ;
        this.args = args;
        this.singleton = args.length == 1 && typ.singletonPossible;
    }

    /**
     * parse the query
     * 
     * @param query
     *            the raw query to parse
     * @return a list of queries to apply
     */
    public static List<Query> parse(final String query) {
        ArrayList<Query> parts = new ArrayList<>();
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
     * Reduce the given state by applying the query as a filter
     * @param old the old state
     * @return the new state that has been reduced to elements that apply
     */
    public Map<String, Map<String, Edit>> applyAsFilter(Map<String, Map<String, Edit>> old) {
        HashMap<String, Map<String, Edit>> result = new HashMap<String, Map<String, Edit>>();

        switch (typ) {
            case All:
                // NO-OP
                break;
            case ByClass:
                for (Entry<String, Map<String, Edit>> entry : old.entrySet()) {
                    Edit mc = entry.getValue().get("metaclass");
                    boolean found = false;
                    if (mc != null) {
                        String currentClass = mc.getAsText();
                        for (String wantedClass : args) {
                            if (currentClass.equals(wantedClass))
                                found = true;
                        }
                    }
                    if (found) {
                        result.put(entry.getKey(), entry.getValue());
                    }
                }
                break;
            case ById:
                for (String id : args) {
                    Map<String, Edit> existing = old.get(id);
                    if (existing != null) {
                        result.put(id, existing);
                    }
                }
                break;
            case FieldFilter:
                for (Entry<String, Map<String, Edit>> entry : old.entrySet()) {
                    Map<String, Edit> next = new HashMap<String, Edit>();
                    for (String nk : args) {
                        Edit prev = entry.getValue().get(nk);
                        if (prev != null)
                            next.put(nk, prev);
                    }
                    result.put(entry.getKey(), next);
                }
                break;
        }
        return result;
    }
}
