package objects;

/**
 * Enum representing different audiences a post can have.
 */
public enum PostAudience {
    PUBLIC(0, "Public", "/img/ic_public.png"),
    FRIENDS(1, "Friends", "/img/ic_friend.png");

    // Fields representing the properties of each audience type
    private final int id;
    private final String name;
    private final String imgSrc;

    /**
     * Constructor to initialise the enum constants.
     *
     * @param id The unique ID of the audience type.
     * @param name The name of the audience type.
     * @param imgSrc The image source path for the audience icon.
     */
    PostAudience(int id, String name, String imgSrc) {
        this.id = id;
        this.name = name;
        this.imgSrc = imgSrc;
    }

    // Getter methods for accessing audience properties

    /**
     * Gets the unique ID of the audience type.
     *
     * @return The ID of the audience type.
     */
    public int getId() {
        return id;
    }

    /**
     * Gets the name of the audience type.
     *
     * @return The name of the audience type.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the image source path for the audience icon.
     *
     * @return The image source path.
     */
    public String getImgSrc() {
        return imgSrc;
    }
}
