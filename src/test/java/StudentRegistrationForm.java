import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class StudentRegistrationForm {
    @Test
    void SuccessfullFillingStudentRegistrationForm(){
        open("https://demoqa.com/automation-practice-form");

        // Заполнение формы
        $("#firstName").setValue("Yaroslav");
        $("#lastName").setValue("Testov");
        $("#userEmail").setValue("jar@mail.ru");
        $("#gender-radio-1").click();
        $("#userNumber").setValue("7000999323");
        // открываем календарь
        $("#dateOfBirthInput").click();
        // выбираеем 1999 год
        $(".react-datepicker__year-select").selectOptionByValue("1999");
        // выбираем март месяц (второй)
        $(".react-datepicker__month-select").selectOptionByValue("2");
        // кликаем по пятнадцатому дню
        $$(".react-datepicker__day").findBy(attribute("aria-label", "Choose Thursday, March 18th, 1999")).click();
        $("#subjectsInput").setValue("Maths").pressEnter();
        $("#hobbies-checkbox-1").click();
        $("#hobbies-checkbox-2").click();
        $("#hobbies-checkbox-3").click();
        $("#uploadPicture").uploadFromClasspath("bobrNato.jpg");
        $("#currentAddress").setValue("г. Волгоград, ул. Пушкина, д. 10, кв. 5");
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Gurgaon").pressEnter();
        $("#submit").click();

        // Проверка, что фамилия и имя отображаются в форме
        $$("table tbody tr")
                .findBy(text("Student Name"))
                .$$("td").get(1)
                .shouldHave(text("Yaroslav Testov"));

        // Проверка, что email отображается в форме
        $$("table tbody tr")
                .findBy(text("Student Email"))
                .$$("td").get(1)
                .shouldHave(text("jar@mail.ru"));
        // Проверка, что гендер отображаетстя в форме
        $$("table tbody tr")
                .findBy(text("Gender"))
                .$$("td").get(1)
                .shouldHave(text("Male"));
        // Проверка, что номер телефона оторбражается в форме
        $$("table tbody tr")
                .findBy(text("Mobile"))
                .$$("td").get(1)
                .shouldHave(text("7000999323"));
        // Проверка, что дата рождения отображается в форме
        $$("table tbody tr")
                .findBy(text("Date of Birth"))
                .$$("td").get(1)
                .shouldHave(text("18 March,1999"));
        // Проверка, что предмет Maths отображается в форме
        $$("table tbody tr")
                .findBy(text("Subjects"))
                .$$("td").get(1)
                .shouldHave(text("Maths"));
        // Проверка, что выбранные 3 хобби отображаются в форме
        $$("table tbody tr")
                .findBy(text("Hobbies"))
                .$$("td").get(1)
                .shouldHave(text("Sports, Reading, Music"));
        // Проверка, что выбранное изображение отображается в форме
        $$("table tbody tr")
                .findBy(text("Picture"))
                .$$("td").get(1)
                .shouldHave(text("bobrNato.jpg"));
        // Проверка, что указанный адрес отображается в орфме
        $$("table tbody tr")
                .findBy(text("Address"))
                .$$("td").get(1)
                .shouldHave(text("г. Волгоград, ул. Пушкина, д. 10, кв. 5"));
        // Проверка, что выбранный штат и город отображаются в форме
        $$("table tbody tr")
                .findBy(text("State and City"))
                .$$("td").get(1)
                .shouldHave(text("NCR Gurgaon"));

    }
}
