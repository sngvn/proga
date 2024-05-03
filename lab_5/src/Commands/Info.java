package Commands;

import Data.*;

/**
 * Класс команды, вывоядящей в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)
 */
public class Info extends Command{
    /**
     * Элемент типа Data для доступа к коллекции
     */
    private Data data;
    /**
     * Конструктор обращается к родительскому конструктору абстрактного класса и принимает объект Data в качестве аргумента
     * @param data
     */
    public Info(Data data) {
        super("Информация о коллекции", false);
        this.data = data;
    }
    /**
     * В методе прописана логика выполнения команды
     * @param arguments
     * @return информацию о результате выполнения
     */
    @Override
    public BaseResponse execute(String arguments){
        try {
            System.out.println("Тип коллекции: " + data.getList().getClass().getName() + "/n"
                    + " Дата создания: " + data.getDate() + "/n" + "Количество элементов в коллекции: " + data.getList().size());
            return new BaseResponse(true);
        }
        catch (Exception exception)
        {
            return new BaseResponse(false, "Нет коллекции");
        }
    }
}
