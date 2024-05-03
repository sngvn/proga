package Commands;
import Data.*;
import java.util.Collections;
import java.util.LinkedList;

/**
 * Класс команды, которая выводит элементы коллекции в порядке возрастания
 */
public class PrintAscending extends Command {
    /**
     * Элемент типа Data для доступа к коллекции
     */
    private Data data;
    /**
     * Конструктор обращается к родительскому конструктору абстрактного класса и принимает объект Data в качестве аргумента
     * @param data
     */
    public PrintAscending(Data data)
    {
        super("Вывести отсортированные элементы по id", false);
        this.data = data;
    }
    /**
     * В методе прописана логика выполнения команды
     * @param arguments
     * @return информацию о результате выполнения
     */
    @Override
    public BaseResponse execute(String arguments){
        LinkedList<Ticket> list = data.getList();
        Collections.sort(list, new IdComparator());
        for (Ticket ticket : list){
            System.out.println(ticket.toString());
        }
        BaseResponse baseResponse = new BaseResponse(true);
        return baseResponse;
    }
}
