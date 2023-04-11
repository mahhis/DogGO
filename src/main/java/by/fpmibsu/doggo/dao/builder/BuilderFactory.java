package by.fpmibsu.doggo.dao.builder;

public class BuilderFactory {

    private static final UserBuilder userBuild = new UserBuilder();
    private static final OrderBuilder orderBuilder = new OrderBuilder();

    public static UserBuilder getUserBuild(){
        return userBuild;
    }
    public static OrderBuilder getOrderBuilder(){
        return orderBuilder;
    }

}
