package lesson2_3.homework;

public class Main { //Класс в своём методе инициирует через создание объекта полей, объявленных в классе Person, вызывает метод date. Вызов этого метода обёрнут в блок
    //try-catch и ожидает выброса какой-либо ошибки (исключения), заложенной в процессе реализации метода date.
    public static void main(String[] args) {
        Person person = new Person("java_skypro_go", "D_1hWiKjjP_9", "D_1hWiKjjP_9"); //Инициирование полей объекта person
        try {
            Person.date(person.login, person.password, person.confirmPassword); //Вызов метода date с проинициированными полями
        } catch (WrongPasswordException | WrongLoginException e) {  //Генерация (выбрасывание) нестандартной (своей) ошибки, если она обнаружена в методе date
            System.out.println(e.getMessage()); //Вызов поля message объекта wrongLoginException или wrongLoginException, по сути, являющимся одной из строк, например, "Строка 'login' содержит более 20 символов!".
            //Это своего рода полиморфизм, т.к. позволяет в одной этой строке вызывать ту именно ошибку, которая произошла (перепутать невозможно)
        }

        System.out.println("Проверка завершена без оператора finally"); //После блока try-catch всегда программа продолжает работу, даже если исключения не было!

//
//      finally { //Зачем этот оператор нужен, если программа после блока try-catch продолжает работать???
//         System.out.println("Проверка завершена (по-любому)");
//        }
    }
}
