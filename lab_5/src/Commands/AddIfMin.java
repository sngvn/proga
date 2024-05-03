package Commands;
import Data.*;

import java.io.InputStream;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;
/**
 * Класс команды, добавляющей элемент в список, если он меньше, чем минимальный в коллекции
 * При вызове команды выполняется создание нового элемента
 */
public class AddIfMin extends Command implements IUseScanner {
    /**
     * Элемент типа Data для доступа к коллекции
     */
    private final Data data;
    /**
     * Scanner для считывания параметров элемента
     */
    private Scanner scanner;
    /**
     * Информация о том, используется ли быстрое создание объекта
     */
    private boolean useFastCreate = false;
    /**
     * Конструктор обращается к родительскому конструктору абстрактного класса и принимает объект Data в качестве аргумента
     * @param data
     */
    public AddIfMin(Data data) {
        super( "Добавить новый элемент, если его значение меньше, чем у наименьшего", true);
        this.data = data;
        scanner = new Scanner(System.in);
    }
    /**
     * В методе прописана логика выполнения команды
     * @param arguments
     * @return информацию о результате выполнения
     */
    @Override
    public BaseResponse execute(String arguments){
        LinkedList<Ticket> list = data.getList();
        Collections.sort(list);
        Ticket ticket = CreateElement.getNewTicket(scanner, useFastCreate);
        if(ticket == null)
            return new BaseResponse(false, "Не удалось добавить элемент");
        if(ticket.compareTo(list.getFirst()) < 0)
        {
            data.addElement(ticket);
            return new BaseResponse(true, "Элемент добавлен");
        }
        return new BaseResponse(false, "Элемент больше, чем наименьший");
    }
    /**
     * Устанавливается быстрое/обыкновенное создание нового элемента, в зависимости от использования в скрипте/консоли
     * @param scanner объект типа Scanner
     * @param isSystemIn параметр true или false
     */
    @Override
    public void setScanner(Scanner scanner, boolean isSystemIn) {
        this.scanner = scanner;
        useFastCreate = !isSystemIn;
    }

}