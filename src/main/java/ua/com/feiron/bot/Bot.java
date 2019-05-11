package ua.com.feiron.bot;

import org.apache.log4j.Logger;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by f on 27.11.2017.
 */
public class Bot extends TelegramLongPollingBot {
    private static final Logger LOGGER = Logger.getLogger(Bot.class.getName());
    //клавиатура https://ru.stackoverflow.com/questions/715154/%D0%9A%D0%BD%D0%BE%D0%BF%D0%BA%D0%B8-%D1%83-%D1%82%D0%B5%D0%BB%D0%B5%D0%B3%D1%80%D0%B0%D0%BC-%D0%B1%D0%BE%D1%82%D0%B0
    ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();

    @Override
    public void onUpdateReceived(Update update) {

        Message message = update.getMessage();
        SendMessage sendMessage = new SendMessage().setChatId(update.getMessage().getChatId());
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        if (message != null && message.hasText()) {
            switch (message.getText()) {
                case "/start":
                    sendMsg(message, "Что Вы хотите построить?");
                    System.out.println(message.getText());
                    break;
                case "Кровля \uD83C\uDFE0":
                    sendMsgRoof(message, "Выберете высоту профиля в зависимости от площади Вашей кровли (чем больше площадь, тем выше профиль. Например НС15 - высота профиля 15 мм, используется для кровель до 200 м.кв.)");
                    System.out.println(message.getText());
                    break;
                case "HC15":
                    sendMsgRoof(message, "Я подобрал тебе лучший вариант!" +
                            " Премиум качества - производитель металла Корея завод DongBuSteel. " +
                            "Перейди по ссылке ниже, выбери покрытие и толщину, которые тебе понравились. " +
                            "Оформите заявку. Наш менеджер с Вами свяжется в течении 5 минут и уточнит все детали." +
                            " www.feiron.com.ua/ru/profnastil/5-profnastil-c-15.html");
                    System.out.println(message.getText());
                    break;
                case "HC35":
                    sendMsgRoof(message, "Я подобрал тебе лучший вариант!" +
                            " Премиум качества - производитель металла Корея завод DongBuSteel. " +
                            "Перейди по ссылке ниже, выбери покрытие и толщину, которые тебе понравились. " +
                            "Оформите заявку. Наш менеджер с Вами свяжется в течении 5 минут и уточнит все детали." +
                            " www.feiron.com.ua/ru/profnastil/8-profnastil-ns-35.html");
                    System.out.println(message.getText());
                    break;
                case "Забор \uD83D\uDEA7":
                    sendMsgFence(message, "Выбери марку профнастила. Рекомендуем для забора более 2 метров высотой выбирать более высокую волну");
                    System.out.println(message.getText());
                    break;
                case "C8":
                    sendMsgFence(message, "Я подобрал тебе лучший вариант!" +
                            " Премиум качества - производитель металла Корея завод DongBuSteel. " +
                            "Перейди по ссылке ниже, выбери покрытие и толщину, которые тебе понравились. " +
                            "Оформите заявку. Наш менеджер с Вами свяжется в течении 5 минут и уточнит все детали." +
                            " www.feiron.com.ua/ru/profnastil/1-profnastil-s-8.html");
                    System.out.println(message.getText());
                    break;
                case "C15":
                    sendMsgFence(message, "Я подобрал тебе лучший вариант!" +
                            " Премиум качества - производитель металла Корея завод DongBuSteel. " +
                            "Перейди по ссылке ниже, выбери покрытие и толщину, которые тебе понравились. " +
                            "Оформите заявку. Наш менеджер с Вами свяжется в течении 5 минут и уточнит все детали." +
                            " www.feiron.com.ua/ru/profnastil/5-profnastil-c-15.html");
                    System.out.println(message.getText());
                    break;

            }
        }


    }


    private void sendMsg(Message message, String s) {

        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);


        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(true);
        //список строк клавиатуры
        List<KeyboardRow> keyboardRows = new ArrayList<KeyboardRow>();
        //перва строка
        KeyboardRow keyboardButtons1 = new KeyboardRow();
        //добавляем кнопки в первую строку клавиатуры
        keyboardButtons1.add("Кровля \uD83C\uDFE0");
        keyboardButtons1.add("Забор \uD83D\uDEA7");
        //Добавляем строки клавиатурі в наш список
        keyboardRows.add(keyboardButtons1);
        //устанавливаем этот список в нашей клавиатуре
        replyKeyboardMarkup.setKeyboard(keyboardRows);

        sendMessage.setChatId(message.getChatId().toString());
        sendMessage.setReplyToMessageId(message.getMessageId());
        sendMessage.setText(s);
        LOGGER.info(message);
        LOGGER.info(message.getText());
        try {
            sendMessage(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }


    private void sendMsgRoof (Message message1, String s1) {

        SendMessage sendMessage1 = new SendMessage();
        sendMessage1.enableMarkdown(true);


        sendMessage1.setReplyMarkup(replyKeyboardMarkup);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(true);

        //список строк клавиатуры
        List<KeyboardRow> keyboardRows = new ArrayList<KeyboardRow>();

        //перва строка
        KeyboardRow keyboardRoof = new KeyboardRow();
        //добавляем кнопки в первую строку клавиатуры
        keyboardRoof.add("HC15");
        keyboardRoof.add("HC35");

        //Добавляем строки клавиатурі в наш список
        keyboardRows.add(keyboardRoof);
        //устанавливаем этот список в нашей клавиатуре
        replyKeyboardMarkup.setKeyboard(keyboardRows);

        sendMessage1.setChatId(message1.getChatId().toString());
        sendMessage1.setReplyToMessageId(message1.getMessageId());
        sendMessage1.setText(s1);
        LOGGER.info(message1);
        LOGGER.info(message1.getText());
        try {
            sendMessage(sendMessage1);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private void sendMsgFence (Message mes, String str) {

        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);


        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(true);

        //список строк клавиатуры
        List<KeyboardRow> keyboard = new ArrayList();

        //перва строка
        KeyboardRow keyboardFence = new KeyboardRow();
        //добавляем кнопки в первую строку клавиатуры
        keyboardFence.add("C8");
        keyboardFence.add("C15");

        //Добавляем строки клавиатурі в наш список
        keyboard.add(keyboardFence);
        //устанавливаем этот список в нашей клавиатуре
        replyKeyboardMarkup.setKeyboard(keyboard);

        sendMessage.setChatId(mes.getChatId().toString());
        sendMessage.setReplyToMessageId(mes.getMessageId());
        sendMessage.setText(str);
        LOGGER.info(mes);
        LOGGER.info(mes.getText());
        try {
            sendMessage(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getBotUsername() {
        return "FEIRON";
    }

    @Override
    public String getBotToken() {
        return "489139697:AAG6b0riMSX1RQgFTvk0jEelivH6vW91TSI";
    }
}
