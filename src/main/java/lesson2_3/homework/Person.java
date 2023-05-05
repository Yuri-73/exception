package lesson2_3.homework;

public class Person {
    String login;
    String password;
    String confirmPassword;

    public Person(String login, String password, String confirmPassword) {
        this.login = login;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }
    public static void date(String login, String password, String confirmPassword) { //Можно было не добавлять throws RuntimeException, т.к. наше исключение Un-Check
        if (login.length() > 20) {
            System.out.println("Строка " + login);
            throw new WrongLoginException("Строка 'login' содержит более 20 символов!"); //Здесь и далее в следующих строках: объявление моей самодельной ошибки WrongLoginException (или WrongPasswordException)
            // в виде ссылки на её объект. Теперь Джава знает, что при данном условии надо вызвать именно это исключение
        }
        if (!login.matches("[a-zA-Z0-9_]+")) {
            System.out.println("Строка 'login' " + login);
            throw new WrongLoginException("В этой строке есть символы, не являющиеся латиницей, цифрами или нижним подчёркиванием!");
        }
        if (password.length() > 19) {
            System.out.println("Строка " + confirmPassword);
            throw new WrongPasswordException("Строка 'password' содержит более 19 символов!");
        }
        if (!password.matches("[a-zA-Z0-9_]+")) {
            System.out.println("Строка 'password' " + password);
            throw new WrongPasswordException("В этой строке есть символы, не являющиеся латиницей, цифрами или нижним подчёркиванием!");
        }
        if (password.equals(confirmPassword) == false) {
            System.out.println("Строки " + password + " и " + confirmPassword);
            throw new WrongPasswordException("Параметры password и confirmPassword не равны!");
        }
    }
}
