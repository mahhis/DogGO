package by.fpmibsu.doggo.dao;

public class FactoryDAO {

    private final static FactoryDAO instance = new FactoryDAO();

    private final UserDAO userDAO = new UserDAOImpl();
    private final OrderDAO orderDAO = new OrderDAOImpl();

    private FactoryDAO(){

    }

    public static FactoryDAO getInstance(){

        return instance;
    }
    public UserDAO getUserDAO(){
        return userDAO;
    }
    public OrderDAO getOrderDAO(){
        return orderDAO;
    }





}
