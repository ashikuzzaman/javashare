package com.java.share.collection;

import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;
import java.util.Collections;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;

/**
 * Demonstartion of better ways to make collections immutable or unmodifiable including the contents/values
 * @author ashik
 */
public class FixedContentMap extends FixedMap {

	public void populateData() {

		modifiable = new HashMap<String, Set<String>>();
		Set<String> modifiableAnimals  = new HashSet<String>();
		modifiableAnimals.add("cat");
		modifiableAnimals.add("dog");
		modifiableAnimals.add("cow");
		modifiableAnimals.add("lion");
		modifiable.put("animals", modifiableAnimals);

		Set<String> fixedContentAnimals =  ImmutableSet.copyOf(modifiableAnimals);
		// Java's standard way of making a collection immutable
		unmodifiable = Collections.unmodifiableMap(modifiable);
		// Another way of creating an immutable collection in Google Guava
		immutable = ImmutableMap
            		.<String, Set<String>> builder()
            		.put("animals", ImmutableSet.<String> builder().addAll(modifiableAnimals).build())
            		.build();
	}

}


