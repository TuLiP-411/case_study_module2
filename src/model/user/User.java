package model.user;

public class User {
    private String name;
    private String phoneNumber;
    private int rewardPoint;

    public User() {
    }

    public User(String name, String phoneNumber, int rewardPoint) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.rewardPoint = rewardPoint;
    }

    public User(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.rewardPoint = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRewardPoint() {
        return rewardPoint;
    }

    public void setRewardPoint(int rewardPoint) {
        this.rewardPoint = rewardPoint;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "User {" +
                "name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", rewardPoint=" + rewardPoint +
                '}';
    }

    public int addPoint(int addingPoint) {
        return getRewardPoint() + addingPoint;

    }
}
