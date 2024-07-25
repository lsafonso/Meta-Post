package objects;

/**
 * Class representing a Facebook post.
 */
public class Post {
    // Fields representing the properties of a post
    private Account account;
    private PostAudience audience;
    private String date;
    private String caption;
    private String image;
    private int totalReactions;
    private int nbComments;
    private int nbShares;

    // Getter and setter methods for accessing and modifying the post properties

    /**
     * Gets the account associated with the post.
     *
     * @return The account associated with the post.
     */
    public Account getAccount() {
        return account;
    }

    /**
     * Sets the account associated with the post.
     *
     * @param account The account to associate with the post.
     */
    public void setAccount(Account account) {
        this.account = account;
    }

    /**
     * Gets the audience of the post.
     *
     * @return The audience of the post.
     */
    public PostAudience getAudience() {
        return audience;
    }

    /**
     * Sets the audience of the post.
     *
     * @param audience The audience to set for the post.
     */
    public void setAudience(PostAudience audience) {
        this.audience = audience;
    }

    /**
     * Gets the date the post was created.
     *
     * @return The date the post was created.
     */
    public String getDate() {
        return date;
    }

    /**
     * Sets the date the post was created.
     *
     * @param date The date to set for the post.
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * Gets the caption of the post.
     *
     * @return The caption of the post.
     */
    public String getCaption() {
        return caption;
    }

    /**
     * Sets the caption of the post.
     *
     * @param caption The caption to set for the post.
     */
    public void setCaption(String caption) {
        this.caption = caption;
    }

    /**
     * Gets the image URL or path of the post.
     *
     * @return The image URL or path of the post.
     */
    public String getImage() {
        return image;
    }

    /**
     * Sets the image URL or path of the post.
     *
     * @param image The image URL or path to set for the post.
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * Gets the total number of reactions to the post.
     *
     * @return The total number of reactions to the post.
     */
    public int getTotalReactions() {
        return totalReactions;
    }

    /**
     * Sets the total number of reactions to the post.
     *
     * @param totalReactions The total number of reactions to set for the post.
     */
    public void setTotalReactions(int totalReactions) {
        this.totalReactions = totalReactions;
    }

    /**
     * Gets the number of comments on the post.
     *
     * @return The number of comments on the post.
     */
    public int getNbComments() {
        return nbComments;
    }

    /**
     * Sets the number of comments on the post.
     *
     * @param nbComments The number of comments to set for the post.
     */
    public void setNbComments(int nbComments) {
        this.nbComments = nbComments;
    }

    /**
     * Gets the number of shares of the post.
     *
     * @return The number of shares of the post.
     */
    public int getNbShares() {
        return nbShares;
    }

    /**
     * Sets the number of shares of the post.
     *
     * @param nbShares The number of shares to set for the post.
     */
    public void setNbShares(int nbShares) {
        this.nbShares = nbShares;
    }
}
