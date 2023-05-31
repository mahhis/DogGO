package by.fpmibsu.doggo.service;


import by.fpmibsu.doggo.service.impl.CommentServiceImpl;
import by.fpmibsu.doggo.service.impl.OrderServiceImpl;
import by.fpmibsu.doggo.service.impl.PetServiceImpl;
import by.fpmibsu.doggo.service.impl.UserServiceImpl;

public final class FactoryService {

    private static final FactoryService instance = new FactoryService();

    private final UserService userService = new UserServiceImpl();

    private final OrderService orderService = new OrderServiceImpl();
    private final CommentService commentService = new CommentServiceImpl();
    private final PetService petService = new PetServiceImpl();


    private FactoryService(){}

    public static FactoryService getInstance(){
        return instance;
    }
    public UserService getUserService() {
        return userService;
    }
    public OrderService getOrderService(){return orderService;}
    public CommentService getCommentService(){return commentService;}
    public PetService getPetService(){return petService;}
}
