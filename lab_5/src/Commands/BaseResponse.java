package Commands;

/**
 * Класс хранит информацию о результате выполнения команды
 */
public class BaseResponse {
    /**
     * Информация о том, выполнилась команда или нет
     */
    private boolean execution;
    /**
     * Описание результата выполнения/не выполнения команды
     */
    private String description;

    /**
     * В конструктор передается информация о выполнении и описании
     * @param execution Информация о том, выполнилась команда или нет
     * @param description Описание результата выполнения/не выполнения команды
     */
    public BaseResponse(boolean execution, String description){
        this.execution = execution;
        this.description = description;
    }

    /**
     * В конструктор передается информация только о выполнении
     * @param execution Информация о том, выполнилась команда или нет
     */
    public BaseResponse(boolean execution){
        this.execution = execution;
        this.description = null;
    }

    /**
     * Возвращает описание результата выполнения/не выполнения команды
     * @return description
     */
    public String getDescription() {return this.description;}

    /**
     * Возвращает описание результата выполнения/не выполнения команды
     * @return execution
     */
    public boolean getExecution() {return this.execution;}


}
