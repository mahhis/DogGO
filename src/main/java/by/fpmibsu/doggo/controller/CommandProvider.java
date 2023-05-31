package by.fpmibsu.doggo.controller;



import by.fpmibsu.doggo.controller.impl.*;
import by.fpmibsu.doggo.controller.impl.goToCommands.*;

import java.util.HashMap;
import java.util.Map;

public final class CommandProvider {
    private final Map<String, Command> commands = new HashMap<String, Command>();

    public CommandProvider() {
        commands.put("SignIn", new SignInCommand());
        commands.put("SignUp", new SignUpCommand());
        commands.put("AddComment", new AddCommentCommand());
        commands.put("AddPet", new AddPetCommand());

        commands.put("GoToSignUpPage", new GoToSignUpPage());
        commands.put("GoToSignInPage", new GoToSignInPage());

        commands.put("GoToMainPage", new GoToMainPage());
        commands.put("GoToAddPetPage", new GoToAddPetPage());
        commands.put("GoToOrderPage", new GoToOrderPage());
        commands.put("GoToViewWalkerPage", new GoToViewWalkerPage());
    }

    public final Command getCommand(String commandName) {
        Command command = commands.get(commandName);
        return command;
    }
}