import java.util.*;

public class Codec {
    // Maps to store the mapping in both directions
    private Map<String, String> longToShort;
    private Map<String, String> shortToLong;
    private static final String BASE_URL = "http://tinyurl.com/";
    private static final String CHAR_SET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private Random rand;

    public Codec() {
        longToShort = new HashMap<>();
        shortToLong = new HashMap<>();
        rand = new Random();
    }

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        if (longToShort.containsKey(longUrl)) {
            // Already encoded before, return existing short URL
            return BASE_URL + longToShort.get(longUrl);
        }
        // Generate unique 6-char code
        String code;
        do {
            code = generateCode();
        } while (shortToLong.containsKey(code)); // Ensure uniqueness

        longToShort.put(longUrl, code);
        shortToLong.put(code, longUrl);

        return BASE_URL + code;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        String code = shortUrl.replace(BASE_URL, "");
        return shortToLong.get(code);
    }

    // Helper to generate a 6-character code
    private String generateCode() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            int idx = rand.nextInt(CHAR_SET.length());
            sb.append(CHAR_SET.charAt(idx));
        }
        return sb.toString();
    }
}


// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));