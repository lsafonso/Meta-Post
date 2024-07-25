package facebook.metapost;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import objects.Account;
import objects.Post;
import objects.PostAudience;
import objects.Reactions;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

/**
 * Controller class for handling the logic of a Facebook post.
 */

public class PostController implements Initializable{

    // FXML-injected fields for UI elements
    @FXML
    private ImageView audience, imgAngry, imgCare, imgHaha, imgLike, imgLove, imgPost, imgProfile, imgSad, imgVerified, imgWow, imgReaction;

    @FXML
    private Label caption, date, nbComments, nbReactions, nbShares, reactionName, username;

    @FXML
    private HBox likeContainer, reactionsContainer;

    // Variables to track the reaction state and timing
    private long startTime = 0;
    private Reactions currentReaction;
    private Post post;

    /**
     * Handles the press event on the like container to start timing.
     */
    @FXML
    public void onLikeContainerPressed(MouseEvent me){
        startTime = System.currentTimeMillis();
    }

    /**
     * Handles the release event on the like container to determine if the reaction panel should be shown or a like toggled.
     */
    @FXML
    public void onLikeContainerMouseReleased(MouseEvent me){
        if(System.currentTimeMillis() - startTime > 500){
            reactionsContainer.setVisible(true);
        }else {
            if(reactionsContainer.isVisible()){
                reactionsContainer.setVisible(false);
            }
            toggleReaction(Reactions.LIKE);
        }
    }
    /**
     * Toggles the current reaction between the given reaction and no reaction.
     */
    private void toggleReaction(Reactions reaction) {
        if (currentReaction == Reactions.NON) {
            setReaction(reaction);
        } else {
            setReaction(Reactions.NON);
        }
    }

    /**
     * Handles the press event on any reaction image to set the corresponding reaction.
     */
   @FXML
   private void onReactionImgPressed(MouseEvent me) {
       String sourceId = ((ImageView) me.getSource()).getId();
       Reactions reaction = Reactions.fromId(sourceId);
       setReaction(reaction != null ? reaction : Reactions.LIKE);
       reactionsContainer.setVisible(false);
   }

    /**
     * Sets the current reaction for the post.
     */
    private void setReaction(Reactions reaction) {
        if (reaction != currentReaction) {
            updateReactionDisplay(reaction);
            updateReactionCount(reaction);
        }
    }

    /**
     * Updates the UI elements to reflect the selected reaction.
     */
    private void updateReactionDisplay(Reactions reaction) {
        imgReaction.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream(reaction.getImgSrc()))));
        reactionName.setText(reaction.getName());
        reactionName.setTextFill(Color.web(reaction.getColor()));
    }

    /**
     * Updates the count of reactions on the post.
     */
    private void updateReactionCount(Reactions reaction) {
        if (currentReaction == Reactions.NON) {
            post.setTotalReactions(post.getTotalReactions() + 1);
        }
        if (reaction == Reactions.NON) {
            post.setTotalReactions(post.getTotalReactions() - 1);
        }
        nbReactions.setText(String.valueOf(post.getTotalReactions()));
        currentReaction = reaction;
    }

    /**
     * Sets the data for the post and updates the UI.
     */
    public void setData(Post post) {
        this.post = post;
        updateUI();
    }

    /**
     * Updates the UI elements with the post data.
     */
    private void updateUI() {
        imgProfile.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream(post.getAccount().getProfileImg()))));
        username.setText(post.getAccount().getName());
        imgVerified.setVisible(post.getAccount().isVerified());
        date.setText(post.getDate());
        audience.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream(post.getAudience().getImgSrc()))));
        caption.setText(post.getCaption());
        imgPost.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream(post.getImage()))));
        nbReactions.setText(String.valueOf(post.getTotalReactions()));
        nbComments.setText(post.getNbComments() + " comments");
        nbShares.setText(post.getNbShares() + " shares");
        currentReaction = Reactions.NON;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Initialise the controller with a sample post
        setData(getPost());
    }

    /**
     * Creates a sample post.
     */
    private Post getPost(){
        Post post = new Post();
        Account account = new Account();
        account.setName("Leandro Afonso");
        account.setProfileImg("/img/user.png");
        account.setVerified(true);
        post.setAccount(account);
        post.setDate("9h");
        post.setAudience(PostAudience.PUBLIC);
        post.setCaption("Hello, everybody!");
        post.setImage("/img/img2.jpg");
        post.setTotalReactions(23);
        post.setNbComments(8);
        post.setNbShares(2);

        return post;
    }
}