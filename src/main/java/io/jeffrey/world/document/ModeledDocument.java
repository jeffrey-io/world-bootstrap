package io.jeffrey.world.document;

import io.jeffrey.world.things.core.Thing;
import io.jeffrey.zer.edits.Edit;
import io.jeffrey.zer.meta.LayerProperties;
import io.jeffrey.zer.meta.MetaClass;
import io.jeffrey.zer.plugin.Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.codehaus.jackson.map.ObjectMapper;

/**
 * Stores all the data for the document, and provides mechanisms for interacting with the data for scripting
 * 
 * @author jeffrey
 *
 */
public class ModeledDocument implements Model {
    public final Map<String, MetaClass>          classes;
    public final Map<String, LayerProperties>    layers;
    protected final ArrayList<Thing>             things;
    protected final ObjectMapper                 mapper = new ObjectMapper();
    public final History                         history;

    private final Map<String, Map<String, Edit>> cachedModel;

    public ModeledDocument() {
        history = new History();
        classes = new TreeMap<>();
        things = new ArrayList<>();
        layers = new TreeMap<>();
        layers.put("_", new LayerProperties("_", "Foreground"));
        classes.put("_", new MetaClass("_", "Default"));
        this.cachedModel = new HashMap<String, Map<String, Edit>>();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void begin() {
        cachedModel.clear();
        for (Thing thing : things) {
            history.register(thing);
            cachedModel.put(thing.id(), thing.getLinks(false));
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void end() {
        cachedModel.clear();
        history.capture();
    }

    /**
     * Helper function to convert the state of the filter into a JSON string 
     */
    private String jsonify(Map<String, Map<String, Edit>> data, boolean expectingSingleton) throws Exception {
        Map<String, Map<String, String>> resolved = new HashMap<String, Map<String, String>>();
        for (Entry<String, Map<String, Edit>> entry : data.entrySet()) {
            HashMap<String, String> newValue = new HashMap<String, String>();
            for (Entry<String, Edit> entry2 : entry.getValue().entrySet()) {
                newValue.put(entry2.getKey(), entry2.getValue().getAsText());
            }
            resolved.put(entry.getKey(), newValue);
        }
        

        if (resolved.size() == 0) {
            return "null";
        }

        if (resolved.size() == 1 && expectingSingleton) {
            Map<String, String> singleton = resolved.values().iterator().next();
            if (singleton.size() == 1) {
                return mapper.writeValueAsString(singleton.values().iterator().next());
            } else {
                return mapper.writeValueAsString(singleton);
            }
        }

        return mapper.writeValueAsString(resolved);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getJson(final String query) {
        List<Query> parsed = Query.parse(query);
        Map<String, Map<String, Edit>> result = cachedModel;
        boolean expectingSingleton = true;
        for (Query part : parsed) {
            if (!part.singleton) {
                expectingSingleton = false;
            }
            result = part.applyAsFilter(result);
        }
        try {
            return jsonify(result, expectingSingleton);
        } catch (Exception err) {
            throw new RuntimeException(err);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void put(final String query, final String value) {
        List<Query> parsed = Query.parse(query);
        Map<String, Map<String, Edit>> result = cachedModel;
        for (Query part : parsed) {
            result = part.applyAsFilter(result);
        }
        for (Map<String, Edit> items : result.values()) {
            for (Edit ed : items.values()) {
                ed.set(value);
            }
        }
    }
}
