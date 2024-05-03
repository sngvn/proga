package Commands;
import Data.*;
import java.util.Date;
import java.util.Scanner;

/**
 * Класс для генерации элемента класса Ticket
 */
public class CreateElement{
    /**
     * Возвращает элемент созданный путем вызова методов fastCreate/create в зависимости от переданных параметров
     * @param scanner
     * @param fastCreate
     * @return элемент типа Ticket
     */
    public static Ticket getNewTicket(Scanner scanner, boolean fastCreate){
        long id = IdGenerator.generateId(100);
        if(fastCreate)
            return fastCreate(scanner, id);
        else
            return create(scanner, id);
    }

    /**
     * Возвращает элемент созданный путем вызова методов fastCreate/create в зависимости от переданных параметров
     * В отличии от getNewTicket не генерирует id, а принимает в качестве параметра, что нужно для команды updateId
     * @param scanner
     * @param id
     * @param fastCreate
     * @return элемент типа Ticket
     */
    public static Ticket updateTicket(Scanner scanner, long id, boolean fastCreate){
        if(fastCreate)
            return fastCreate(scanner, id);
        else
            return create(scanner, id);
    }

    /**
     * Инициализация объекта Ticket (заполнения всех его полей) из терминала
     * @param scanner объект типа Scanner
     * @param id id элемента
     * @return элемент типа Ticket
     */
    private static Ticket create(Scanner scanner, long id)
    {
        Ticket ticket = new Ticket();
        ticket.setId(id);
        System.out.println("ID билета: " + id);
        try {
            while (true){
                System.out.println("Введите название билета");
                String name = scanner.nextLine();
                if (name == null || name.trim().isEmpty()){
                    System.out.println("Имя не может быть null или пустой строкой");
                }else {
                    ticket.setName(name);
                    break;
                }
            }
        }catch (Exception e){
            System.out.println("Ошибка ввода");
        }

        while (true){
            try {
                while (true){
                    System.out.println("Введите координаты");
                    String coordinatesStr = scanner.nextLine();

                    if (coordinatesStr == null)
                        System.out.println("Координаты не могут быть null");
                    String[] coordinate = coordinatesStr.split(" ");
                    if(coordinate.length != 2)
                    {
                        System.out.println("Ввести можно только две координаты");
                        throw  new Exception();
                    }
                    double x = Double.parseDouble(coordinate[0]);
                    double y = Double.parseDouble(coordinate[1]);
                    if (x > 528 || y < -517){
                        System.out.println("x не может быть больше 528 и y не может быть меньше -517");
                    }else{
                        Coordinates coordinates = new Coordinates(x,y);
                        ticket.setCoordinates(coordinates);
                        break;
                    }
                } break;
            }catch (Exception e){
                System.out.println("Ошибка ввода");
            }
        }

        Date date = new Date();
        ticket.setCreationDate(date);
        System.out.println("Дата создания: " + date);

        while (true){
            try{
                while (true){
                    System.out.println("Введите цену билета");
                    String nextLine = scanner.nextLine();
                    float price = Float.parseFloat(nextLine);
                    if ((nextLine.charAt(0) == '0') || (price <= 0)){
                        System.out.println("Цена не может быть такой");
                    }else{
                        ticket.setPrice(price);
                        break;
                    }
                }break;
            }catch(NumberFormatException e){
                System.out.println("Ошибка ввода");
            }
        }
        try {
            while (true){
                System.out.println("Введите комментарий");
                String comment = scanner.nextLine();
                if (comment == null || comment.trim().isEmpty()){
                    System.out.println("Комментарий не может быть null или пустой строкой");
                }else {
                    ticket.setComment(comment);
                    break;
                }
            }
        }catch (Exception e){
            System.out.println("Ошибка ввода");
        }

        try {
            while (true){
                System.out.println("Билет подлежит возврату? Введите Да/Нет");
                String refund = scanner.nextLine();
                if (!refund.equals("Да") && !refund.equals("Нет")){
                    System.out.println("Требуется ввести Да/Нет");
                }else{
                    boolean refundable = refund.equals("Да");
                    ticket.setRefundable(refundable);
                    break;
                }
            }
        }catch (Exception e){
            System.out.println("Ошибка ввода");
        }

        try{
            while (true){
                System.out.println("Введите тип билета VIP/USUAL/BUDGETARY/CHEAP");
                String ticketType = scanner.nextLine();
                if (!ticketType.trim().isEmpty() && !ticketType.equals("VIP") && !ticketType.equals("USUAL") && !ticketType.equals("BUDGETARY") && !ticketType.equals("CHEAP")){
                    System.out.println("Тип билета должен быть задан как VIP/USUAL/BUDGETARY/CHEAP или null");

                }else{
                    if (!ticketType.trim().isEmpty()){
                        TicketType type = TicketType.valueOf(ticketType);
                        ticket.setType(type);
                    }
                    break;
                }
            }
        }catch (Exception e){
            System.out.println("Ошибка ввода");
        }

        try {
            while (true){
                System.out.println("Вы хотите указать местоположение? Введите Да/Нет");
                String answer = scanner.nextLine();
                if (!answer.equals("Да") && !answer.equals("Нет")){
                    System.out.println("Требуется ввести Да/Нет");
                }else{
                    if (answer.equals("Нет")){
                        return ticket;
                    }
                    break;
                }
            }
        }catch (Exception e){
            System.out.println("Ошибка ввода");
        }

        Venue venue = new Venue();
        int venueId = IdGenerator.generateId(100);
        venue.setId(venueId);
        System.out.println("ID места проведения мероприятия: " + venueId);
        try {
            while (true){
                System.out.println("Введите название места проведения мероприятия");
                String name = scanner.nextLine();
                if (name == null || name.trim().isEmpty()){
                    System.out.println("Название не может быть null или пустой строкой");
                }else {
                    venue.setName(name);
                    break;
                }
            }
        }catch (Exception e){
            System.out.println("Ошибка ввода");
        }
        while (true){
            try{
                while (true){
                    System.out.println("Введите вместимость площадки мероприятия");
                    String nextLine = scanner.nextLine();
                    int capacity = Integer.parseInt(nextLine);
                    if ((nextLine.charAt(0) == '0') || (capacity <= 0)){
                        System.out.println("Вместимость не может быть нулевой или меньше нуля");
                    }else{
                        venue.setCapacity(capacity);
                        break;
                    }
                }break;
            }catch(NumberFormatException e){
                System.out.println("Ошибка ввода");
            }
        }
        try{
            while (true){
                System.out.println("Введите место проведения THEATRE/CINEMA/STADIUM");
                String venueType = scanner.nextLine();
                if (!venueType.equals("THEATRE") && !venueType.equals("CINEMA") && !venueType.equals("STADIUM")){
                    System.out.println("Место проведения должно быть задано как THEATRE/CINEMA/STADIUM и не может быть null");

                }else{
                    VenueType type = VenueType.valueOf(venueType);
                    venue.setType(type);
                    ticket.setVenue(venue);
                    break;
                }
            }
        }catch (Exception e){
            System.out.println("Ошибка ввода");
        }
        return ticket;
    }
    /**
     * Инициализация объекта Ticket (заполнения всех его полей) из скрипта
     * @param scanner объект типа Scanner
     * @param id id элемента
     * @return элемент типа Ticket
     */
    private static Ticket fastCreate(Scanner scanner, long id){
        Ticket ticket = new Ticket();
        boolean result = true;

        ticket.setId(id);
        ticket.setName(scanner.nextLine());

        String coordinatesStr = scanner.nextLine();
        if (coordinatesStr == null)
            result = false;
        String[] coordinate = coordinatesStr.split(" ");
        if(coordinate.length != 2)
            result = false;
        double x = Double.parseDouble(coordinate[0]);
        double y = Double.parseDouble(coordinate[1]);
        Coordinates coordinates = new Coordinates(x,y);
        ticket.setCoordinates(coordinates);
        ticket.setCreationDate(new Date());

        try{
            String nextLine = scanner.nextLine();
            ticket.setPrice(Float.parseFloat(nextLine));
            ticket.setComment(scanner.nextLine());
        }
        catch (Exception ex){ result = false; }

        String refund = scanner.nextLine();
        if (!refund.equals("Да") && !refund.equals("Нет"))
            result = false;
        ticket.setRefundable(refund.equals("Да"));

        String ticketType = scanner.nextLine();
        if (!ticketType.trim().isEmpty() && !ticketType.equals("VIP") && !ticketType.equals("USUAL") && !ticketType.equals("BUDGETARY") && !ticketType.equals("CHEAP"))
            result = false;
        if (!ticketType.trim().isEmpty()){
            TicketType type = TicketType.valueOf(ticketType);
            ticket.setType(type);
        }

        String answer = scanner.nextLine();
        if (!answer.equals("Да") && !answer.equals("Нет"))
            result = false;

        if(answer.equals("Нет"))
        {
            if(!result || !ticket.validate())
                return null;
            return ticket;
        }

        Venue venue = new Venue();
        int venueId = IdGenerator.generateId(100);
        venue.setId(venueId);
        venue.setName(scanner.nextLine());
        venue.setCapacity(Integer.parseInt(scanner.nextLine()));
        String venueType = scanner.nextLine();
        if (!venueType.equals("THEATRE") && !venueType.equals("CINEMA") && !venueType.equals("STADIUM"))
            result = false;
        venue.setType(VenueType.valueOf(scanner.nextLine()));
        ticket.setVenue(venue);

        if(!result || !ticket.validate())
            return null;
        return ticket;
    }
}
