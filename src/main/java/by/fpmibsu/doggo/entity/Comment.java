package by.fpmibsu.doggo.entity;

public class Comment {
    private int commentId;
    private WalkerInfo walkerId;
    private User author;
    private String content;


    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public WalkerInfo getWalkerInfo() {
        return walkerId;
    }

    public void setWalkerInfo(WalkerInfo walkerId) {
        this.walkerId = walkerId;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


}