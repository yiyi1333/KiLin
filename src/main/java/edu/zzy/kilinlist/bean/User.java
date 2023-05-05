package edu.zzy.kilinlist.bean;

public class User {
    private int kilinUserId;
    private String userName;
    private String password;
    private String email;
    private String imageUrl;
    private String roomCode;

    @Override
    public String toString() {
        return "User{" +
                "kilinUserId=" + kilinUserId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", roomCode='" + roomCode + '\'' +
                '}';
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getRoomCode() {
        return roomCode;
    }

    public void setRoomCode(String roomCode) {
        this.roomCode = roomCode;
    }

    public int getKilinUserId() {
        return kilinUserId;
    }

    public void setKilinUserId(int kilinUserId) {
        this.kilinUserId = kilinUserId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
