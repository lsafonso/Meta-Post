package objects;

import java.util.HashMap;
import java.util.Map;

/**
 * Enum representing different reactions available for a post.
 */
public enum Reactions {
    NON(0, "Like", "#606266", "/img/ic_like_outline.png", "imgLike"),
    LIKE(1, "Like", "#056BE1", "/img/ic_like.png", "imgLike"),
    LOVE(2, "Love", "#E12C4A", "/img/ic_love_.png", "imgLove"),
    CARE(3, "Care", "#EAA823", "/img/ic_care.png", "imgCare"),
    HAHA(4, "Haha", "#EAA823", "/img/ic_haha.png", "imgHaha"),
    WOW(5, "Wow", "#EAA823", "/img/ic_wow.png", "imgWow"),
    SAD(6, "Sad", "#EAA823", "/img/ic_sad.png", "imgSad"),
    ANGRY(7, "Angry", "#DD6B0E", "/img/ic_angry.png", "imgAngry");

    // Static map to hold the mapping from idString to Reactions enum
    private static final Map<String, Reactions> BY_ID = new HashMap<>();

    // Static block to initialise the map
    static {
        for (Reactions r : values()) {
            BY_ID.put(r.idString, r);
        }
    }

    // Fields for reaction properties
    private final int id;
    private final String name;
    private final String color;
    private final String imgSrc;
    private final String idString;

    /**
     * Constructor to initialize the reaction enum constants.
     *
     * @param id      The unique ID of the reaction.
     * @param name    The name of the reaction.
     * @param color   The color associated with the reaction.
     * @param imgSrc  The image source path for the reaction icon.
     * @param idString The ID string used for mapping.
     */
    Reactions(int id, String name, String color, String imgSrc, String idString) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.imgSrc = imgSrc;
        this.idString = idString;
    }

    // Getter methods for accessing reaction properties
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    /**
     * Returns the Reactions enum corresponding to the given id string.
     *
     * @param id The id string of the reaction.
     * @return The Reactions enum associated with the id string.
     */
    public static Reactions fromId(String id) {
        return BY_ID.get(id);
    }
}
