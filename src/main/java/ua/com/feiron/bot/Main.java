package ua.com.feiron.bot;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiRequestException;

import java.net.MalformedURLException;
import java.util.Scanner;

/**
 * Created by f on 14.12.2017.
 */
@RequestMapping(value="/")
@Controller
public class Main {

    private static final Logger LOGGER = Logger.getLogger(Main.class);
    @RequestMapping(method = RequestMethod.GET)
    public static void main(String[] args) throws MalformedURLException {
      Scanner sc = new Scanner(System.in);


        System.out.println("Запуск");
        ApiContextInitializer.init();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
//        LOGGER.getLogger(telegramBotsApi.toString());
        LOGGER.info(telegramBotsApi);


        try {

            telegramBotsApi.registerBot(new Bot());
        } catch (TelegramApiRequestException e) {
            e.printStackTrace();
        }
    }
}
