package Commands;

import Data.CommandManager;
import Data.Ticket;

import java.util.Hashtable;
import java.util.Map;

/**
 * Класс команды, которая выводит справку по доступным командам
 */
public class Help extends Command {
    /**
     * Объект типа commandManager для доступа к информации о командах
     */
    private  CommandManager commandManager;
    /**
     * Конструктор обращается к родительскому конструктору абстрактного класса и принимает объект CommandManager в качестве аргумента
     * @param commandManager
     */
    public Help(CommandManager commandManager) {
        super("Вывести информацию о командах", false);
        this.commandManager = commandManager;
    }
    /**
     * В методе прописана логика выполнения команды
     * @param arguments
     * @return информацию о результате выполнения
     */
    @Override
    public BaseResponse execute(String arguments) {
        for (Map.Entry<String, Command> pair: commandManager.getCommands().entrySet()){
            System.out.println(pair.getKey() + " - " + pair.getValue().getDescription());
        }
        BaseResponse baseResponse = new BaseResponse(true);
        return baseResponse;
    }
}
