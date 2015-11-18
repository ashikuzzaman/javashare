package com.java.share.collection;

import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;
import java.util.Collections;
import com.google.common.collect.ImmutableMap;
// import com.java.share.collection.FixedMap;

/**
 * Demonstartion of better ways to make collections immutable
 * @author ashik
 * To compile: javac -d . *.java
 * To run: java com.java.share.collection.FixedMapRunner
 */
public class FixedMapRunner {

	public static void main(String args[]) {
		FixedMap dataHolder = new FixedMap();
		dataHolder.populateData();

		Set<String> birds = new HashSet<String>();
		birds.add("eagle");
		birds.add("crow");

		// test the size of the maps
		System.out.println("Before adding new element birds, dataHolder.getKeySetForUnmodifiable().size() = " + dataHolder.getKeySetForUnmodifiable().size());
		System.out.println("Before adding new element birds, dataHolder.getKeySetForImmutable().size() = " + dataHolder.getKeySetForImmutable().size());
	
		dataHolder.getModifiableMap().put("birds", birds);
	
		System.out.println("After adding new element birds, dataHolder.getKeySetForUnmodifiable().size() = " + dataHolder.getKeySetForUnmodifiable().size());
		System.out.println("After adding new element birds, dataHolder.getKeySetForImmutable().size() = " + dataHolder.getKeySetForImmutable().size());

		// test the values/contents of the maps 
		System.out.println("Before adding new animal value to unmodifiable, total animals = " + dataHolder.getUnmodifiable("animals").size());
		System.out.println("Before adding new animal value to immutable, total animals = " + dataHolder.getImmutable("animals").size());
	
		dataHolder.getUnmodifiable("animals").add("tiger");
		dataHolder.getImmutable("animals").add("elephant");
	
		System.out.println("After adding new animal value to unmodifiable total animals = " + dataHolder.getUnmodifiable("animals").size());
		System.out.println("After adding new animal value to immutable total animals = " + dataHolder.getImmutable("animals").size());

		// test the values/contents of the maps with truly fixed content map
		dataHolder = new FixedContentMap();
		dataHolder.populateData();

		System.out.println("Before adding new animal value to modifiable, total animals = " + dataHolder.getModifiableMap().get("animals").size());

		dataHolder.getModifiableMap().get("animals").add("monkey");

		System.out.println("After adding new animal value to modifiable, total animals = " + dataHolder.getModifiableMap().get("animals").size());
		System.out.println("After adding new animal value to modifiable, total animals for immutable = " + dataHolder.getImmutable("animals").size());

		dataHolder.getImmutable("animals").add("zebra");

		System.out.println("After adding new animal value to immutable total animals = " + dataHolder.getImmutable("animals").size());

	}

}


