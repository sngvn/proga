package Commands;

/**
 * Класс команды, завершающей программу (без сохранения в файл)
 */
public class Exit extends Command{
    /**
     * Конструктор обращается к родительскому конструктору абстрактного класса
     */
    public Exit() {
        super("Закрыть приложение", false);
    }

    @Override
    public BaseResponse execute(String arguments){
        System.exit(0);
        return null;
    }
}
