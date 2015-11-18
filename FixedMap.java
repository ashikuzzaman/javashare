package com.java.share.collection;

import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;
import java.util.Collections;
import com.google.common.collect.ImmutableMap;

/**
 * Demonstartion of one way to make collections immutable or unmodifiable
 * @author ashik
 */
public class FixedMap {

	protected static Map<String, Set<String>> modifiable;
	protected static Map<String, Set<String>> unmodifiable;
	protected static Map<String, Set<String>> immutable;


	public void populateData() {

		modifiable = new HashMap<String, Set<String>>();
		Set<String> modifiableAnimals  = new HashSet<String>();
		modifiableAnimals.add("cat");
		modifiableAnimals.add("dog");
		modifiableAnimals.add("cow");
		modifiableAnimals.add("lion");
		modifiable.put("animals", modifiableAnimals);

		// Java's standard way of making a collection immutable
		unmodifiable = Collections.unmodifiableMap(modifiable);
		// One of Google Guava's way of creating an immutable collection
		immutable = ImmutableMap.<String, Set<String>> builder().putAll(modifiable).build();
	}

	/** give access to modifiable map to demonstrate the difference in behavior 
	 *  between immutable maps and unmodifiable maps 
	 */
	public Map<String, Set<String>> getModifiableMap() {
		return this.modifiable;
	}

	public Set<String> getUnmodifiable(String key) {
		return this.unmodifiable.get(key);
	}

	public Set<String> getImmutable(String key) {
		return this.immutable.get(key);
	}

	public Set<String> getKeySetForUnmodifiable() {
		return this.unmodifiable.keySet();
	}

	public Set<String> getKeySetForImmutable() {
		return this.immutable.keySet();
	}

}


