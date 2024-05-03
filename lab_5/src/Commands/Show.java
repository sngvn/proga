package Commands;
import Data.*;

/**
 * Класс команды, которая выводит в стандартный поток вывода все элементы коллекции в строковом представлении
 */
public class Show extends Command{
    /**
     * Элемент типа Data для доступа к коллекции
     */
    private Data data;
    /**
     * Конструктор обращается к родительскому конструктору абстрактного класса и принимает объект Data в качестве аргумента
     * @param data
     */
    public Show(Data data) {
        super("Вывести коллекцию", false);
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
            for (Ticket ticket : data.getList()){
                System.out.println(ticket.toString());
            }
            BaseResponse baseResponse = new BaseResponse(true);
            return baseResponse;
        }
        catch (Exception ex)
        {
            return new BaseResponse(false, "Нет коллекции");
        }
    }
}
