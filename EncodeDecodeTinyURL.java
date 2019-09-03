package HashTable;

import java.util.HashMap;
import java.util.Map;

/*
 	https://leetcode.com/problems/encode-and-decode-tinyurl/description/
 	535. Encode and Decode TinyURL
	TinyURL is a URL shortening service where you enter a URL such as https://leetcode.com/problems/design-tinyurl and it returns a short URL such as 
	http://tinyurl.com/4e9iAk. Design the encode and decode methods for the TinyURL service. There is no restriction on how your encode/decode 
	algorithm should work. You just need to ensure that a URL can be encoded to a tiny URL and the tiny URL can be decoded to the original URL.
 	Explanation and Code from: @selim https://leetcode.com/problems/encode-and-decode-tinyurl/discuss/100268/Two-solutions-and-thoughts
 	
 */

public class EncodeDecodeTinyURL {

	    public static Map<String, String> index = new HashMap<String, String>();		//key - random 6 digit key; value - longUrl 
	    public static Map<String, String> revIndex = new HashMap<String, String>();		//key - longUrl; value - random 6 digit key 
	    public static String BASE_HOST = "http://tinyurl.com/";
	    
	    // Encodes a URL to a shortened URL.
	    public static String encode(String longUrl) {
	    	System.out.println("revIndex: "+revIndex+" longUrl: "+longUrl);
	    	
	        if(revIndex.containsKey(longUrl)) { 
	        	return BASE_HOST + revIndex.get(longUrl);
	        }
	        
	        String charSet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	        String key = null;
	        
	        System.out.println("charSet.length(): "+charSet.length());
	        
	        StringBuilder sb = new StringBuilder();
	        for (int i=0; i<6; i++) {
	            	System.out.println("Math.random(): "+Math.random());
	                int r = (int) (Math.random() * charSet.length());
	                System.out.println("r: "+r);
	                sb.append(charSet.charAt(r));
	        }
	        
	        key = sb.toString();
	        System.out.println("index: "+index+" key: "+key);
	        
	        System.out.println("key: "+key+" longUrl: "+longUrl);
	        
	        index.put(key, longUrl);
	        revIndex.put(longUrl, key);
	        
	        return BASE_HOST + key;
	    }

	    // Decodes a shortened URL to its original URL.
	    public static String decode(String shortUrl) {
	    	System.out.println("shortUrl: "+shortUrl);
	    	String s = shortUrl.replace(BASE_HOST, "");
	    	System.out.println("index: "+index+" s: "+s+" index.get(s): "+index.get(s));
	        return index.get(s);
	    }
	
	public static void main(String[] args) {
		String longUrl = "https://leetcode.com/problems/design-tinyurl";
		
		String tinyURL = encode(longUrl);
		System.out.println(tinyURL);
		
		System.out.println(encode(longUrl));
		
		String originalUrl = decode(tinyURL);
		System.out.println(originalUrl);
	}
}