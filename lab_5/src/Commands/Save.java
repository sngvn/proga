package Commands;
import Data.*;

/**
 * Класс команды, сохраняющей коллекцию в файл
 */
public class Save extends Command{
    /**
     * Элемент типа Data для доступа к коллекции
     */
    private final Data data;
    /**
     * Конструктор обращается к родительскому конструктору абстрактного класса и принимает объект Data в качестве аргумента
     * @param data
     */
    public Save(Data data) {
        super( "Сохранить коллекцию в файл (укажите имя файла)", false);
        this.data = data;
    }
    /**
     * В методе прописана логика выполнения команды
     * @param arguments
     * @return информацию о результате выполнения
     */
    @Override
    public BaseResponse execute(String arguments){
        DataProvider dataProvider = new DataProvider();
        dataProvider.saveToFile(data.getFilePath(), data.getList());
        return new BaseResponse(true);
    }
}
