package com.latewind.test.ehcache;

import org.junit.Test;

import net.sf.ehcache.*;

public class TestEhcache{
	
	@Test
	public void t(){
		
	      // Creating a CacheManager based on a specified configuration file.
        CacheManager manager = CacheManager.newInstance("src/main/resources/ehcache.xml");
        // obtains a Cache called sampleCache1, which has been preconfigured in the configuration file
        Cache cache = manager.getCache("myCache");
        // puts an element into a cache
        Element element = new Element("key1", "哈哈");
        cache.put(element);
        //The following gets a NonSerializable value from an element with a key of key1.
        Object value = element.getObjectValue();
        System.out.println(value.toString());
        manager.shutdown();
		
		System.out.println("TT");
	}
	
}